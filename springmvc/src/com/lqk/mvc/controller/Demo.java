package com.lqk.mvc.controller;

import java.rmi.MarshalledObject;
import java.util.HashMap;

public class Demo {
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("A",1);
        System.out.println(map.values());
        System.out.println(map.keySet().toString());
    }
}
