package com.ratpack.xin.tools;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import lombok.extern.log4j.Log4j2;

import java.io.IOException;
import java.util.function.Function;

/**
 * Created by zhangx on 2017/8/7.
 */
@Log4j2
public class JsonTool {

    private final static ObjectMapper objectMapper;
    static {
        objectMapper = new ObjectMapper();
        //属性为空不参加序列化
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
    }

    public final static JsonNode strToJsonNode(String str){
        try {
            return objectMapper.readTree(str);
        } catch (IOException e) {
            log.error("strToJsonNode errpr:{}", str, e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public final static ObjectNode strToObjectNode(String str){
        JsonNode jsonNode = strToJsonNode(str);
        if(jsonNode==null){
            return null;
        }
        if(jsonNode.isObject()){
            return (ObjectNode) jsonNode;
        }
        throw new ClassCastException(String.format("%s is not ObjectNode",str));
    }

    public static String objectToStr(Object object) throws JsonProcessingException {
        return objectMapper.writeValueAsString(object);
    }

    public static JsonNode objectToJson(Object object) throws JsonProcessingException {
        return strToJsonNode(objectToStr(object));
    }

    public final static ArrayNode strToArrayNode(String str) {
        JsonNode jsonNode = strToJsonNode(str);
        if(jsonNode==null){
            return null;
        }
        if(jsonNode.isArray()){
            return (ArrayNode) jsonNode;
        }
        throw new ClassCastException(String.format("%s is not ArrayNode",str));
    }

    public final static <T> T strToObject(String str,Class<T> clazz) throws IOException {
        return objectMapper.readValue(str,clazz);
    }

    public final static <T> T jsonToObject(JsonNode json, Class<T> clazz) throws IOException {
        if(json==null){
            return null;
        }
        return JsonTool.strToObject(JsonTool.objectToStr(json),clazz);
    }

    public final static ObjectNode newObjNode(){
        return objectMapper.createObjectNode();
    }

    public final static ArrayNode newArrNode(){
        return objectMapper.createArrayNode();
    }


    public final static String getStr(JsonNode jsonNode,String at){
        return getObject(jsonNode, at, json -> json.asText());
    }

    public final static Integer getInt(JsonNode jsonNode,String at){
        return getObject(jsonNode, at, json -> json.asInt());
    }

    public final static Long getLong(JsonNode jsonNode,String at){
        return getObject(jsonNode, at, json -> json.asLong());
    }

    public final static JsonNode getJsonNode(JsonNode jsonNode,String at){
        return getObject(jsonNode,at,json->json);
    }

    private static <T> T getObject(JsonNode jsonNode, String at, Function<JsonNode,T> supplier){
        if(jsonNode==null||at==null){
            return null;
        }
        JsonNode posNode = jsonNode.at(at);
        if(posNode.isMissingNode()){
            return null;
        }
        return supplier.apply(posNode);
    }
}
