package com.ratpack.xin.handler;

import com.fasterxml.jackson.databind.JsonNode;
import com.google.inject.Inject;
import com.ratpack.xin.db.Tables;
import com.ratpack.xin.db.tables.pojos.Article;
import com.ratpack.xin.db.tables.records.ArticleRecord;
import com.ratpack.xin.tools.JsonTool;
import lombok.extern.log4j.Log4j2;
import org.jooq.DSLContext;
import org.jooq.Table;
import org.reflections.Store;
import ratpack.exec.Promise;
import ratpack.handling.Context;
import ratpack.handling.Handler;

import java.util.UUID;

import static ratpack.jackson.Jackson.json;
import static ratpack.jackson.Jackson.jsonNode;
import static ratpack.rx.RxRatpack.observe;

@Log4j2
public class ArticleAddHandler implements Handler{
    @Inject
    private static DSLContext dslContext;
    @Override
    public void handle(Context context) throws Exception {
        Promise<JsonNode> promise = context.parse(jsonNode());
        observe(promise).subscribe(bodyJsonNode -> {
            Article article = JsonTool.convertValue(bodyJsonNode,Article.class);
            article.setCreateUuid(UUID.randomUUID().toString());
            log.debug("article insert 内容:{}",article);
         /*   dslContext.insertInto(Article).values(article);
            //ArticleRecord articleRecord = dslContext.newRecord(Tables.ARTICLE,article);
            //int insert = articleRecord.insert();
            dslContext.insertInto()*/
            //log.info("insert:{}",insert);
            context.render(json( JsonTool.createObjectNode().put("result","1")));
        });
    }
}
