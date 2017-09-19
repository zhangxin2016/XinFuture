package com.ratpack.xin.tools;

import lombok.extern.log4j.Log4j2;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by zhangx on 2017/9/19
 */
@Log4j2
public class TimeTool {
    private static SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static String formatTimestamp(Long timestamp){
        try{
            Date date = new Date();
            date.setTime(timestamp);
            return sdf.format(date);
        }catch (Exception e){
            log.info("格式化时间出错",e);
            return "";
        }
    }
}
