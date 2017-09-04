package com.zx.tvm.java;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by zhangx on 2017/9/4
 */
public class ListTest {
    public static void main(String[] args) throws ParseException {
        //listStreamTest();
        long dayTimeFlag = LocalDate.now().atStartOfDay().atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
        Calendar c = Calendar.getInstance();
        int hour = c.get(Calendar.HOUR_OF_DAY);
        int minute = c.get(Calendar.MINUTE);
        getTimeByFormat();
       /* SimpleDateFormat simpleDateFormat =  new SimpleDateFormat(" yyyy-MM-dd HH:mm:ss ");
        String format = new SimpleDateFormat("yyyy-MM-dd HH:mm:00").format(System.currentTimeMillis());
        Date date = simpleDateFormat.parse(format);
        System.out.print("Format To times:"+date.getTime());*/
    }
    public static void listStreamTest(){
        List<String> list = new ArrayList<>();
        list.add("ZHANG");
        list.add("liSi");
        list.add("wangwu");
        long count = list.stream().filter(num -> num != "zhangsan").count();
        Stream<String> stringStream = list.stream().map(a -> {
            return a.toLowerCase();
        });
        List<String> collect = stringStream.collect(Collectors.toList());
        for (int i=0;i<collect.size();i++){
            System.out.println(collect.get(i));
        }
        list.stream().forEach(i -> {
            i.intern();
            System.out.println(i.intern());
        });
    }

    public static Long getTimeByFormat() throws ParseException {
        Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:00");
        String dateString = formatter.format(currentTime);
        Date date = formatter.parse(dateString);
        long ts = date.getTime();
        System.out.println(ts);
        return ts;
    }
}
