package com.nou.mad.java.juc.threadlocal;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

    static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    private final static java.lang.ThreadLocal<SimpleDateFormat> threadLocal = ThreadLocal.withInitial(()->new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));

    public static Date parse(String date){

        try {
            threadLocal.get().parse(date);
            //simpleDateFormat.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();

        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

}
