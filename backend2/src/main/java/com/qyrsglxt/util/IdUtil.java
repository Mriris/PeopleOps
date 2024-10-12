package com.qyrsglxt.util;

import java.util.UUID;

public class IdUtil {

    public static String getId() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    public static void main(String[] args) {
        for (int i = 1; i <= 10; i++) {
            System.out.println(getId());
        }
    }

}