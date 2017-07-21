package com.hik.studentms.util;

import java.util.UUID;

public class IdUtil {
    public static String generateId(){
        return UUID.randomUUID().toString();
    }
}
