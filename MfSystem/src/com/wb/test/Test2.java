package com.wb.test;

public class Test2 {
    public static void main(String[] args) {
        String a="h1f3";
        int h = a.indexOf("h");
        int f = a.lastIndexOf("f");
        int id = Integer.valueOf(a.substring(h+1, f));
        String flag=a.substring(f+1);
        System.out.println(flag);
    }
}
