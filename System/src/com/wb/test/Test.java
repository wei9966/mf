package com.wb.test;


import com.alibaba.fastjson.JSON;

import java.util.Map;

public class Test {
    public static void main(String[] args) {
        String str="{\"a\":1,\"b\":2,\"c\":3,\"d\":4}\n";
        System.out.println(str);
        Map map = JSON.parseObject(str, Map.class);
        Object a = map.get("a");
        System.out.println(a);
    }
}
