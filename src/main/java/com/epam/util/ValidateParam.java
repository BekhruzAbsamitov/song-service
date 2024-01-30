package com.epam.util;

public class ValidateParam {

    private ValidateParam() {}

    public static boolean isNotValid(String ids) {
        return ids.length() >= 200;
    }
}
