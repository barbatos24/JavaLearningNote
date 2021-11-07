package com.russellzhou.javalearningnote.utils;

import java.util.UUID;

public class StringUtil {

    public static String getuuid() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

    public static String Object2String(Object o) {
        if (o == null) {
            return "";
        } else {
            return o.toString();
        }
    }
}
