package com.wb.com.wb.test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Test {
    public static void main(String[] args) {
        Date d=new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("YYYY/MM/dd");
        String format = simpleDateFormat.format(d);
        System.out.println(format);
    }
}
