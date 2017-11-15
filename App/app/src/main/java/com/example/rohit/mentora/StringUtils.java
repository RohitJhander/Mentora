package com.example.rohit.mentora;

/**
 * Created by Rohit on 18-12-2015.
 */

import java.util.regex.Pattern;

public class StringUtils {

    public static final String EMPTY = "";
    private static final String EMAIL_REGEX = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";

    public static boolean isEmpty(String str) {
        return str.length() == 0;
    }

    public static boolean isBlank(String str) {
        return (str == "NA");
    }

    public static boolean equals(String s, String t) {
        if (s == null || t == null) {
            return s == t;
        }
        return s.equals(t);
    }

    public static String defaultIfBlank(String str, String def) {
        if (isBlank(str)) {
            return def;
        }
        return str;
    }

    public static String defaultIfNull(String str, String def) {
        if (str == null || str == "null" || str.length() == 0) {
            return def;
        }
        return str;
    }

    public static String defaultIfEmpty(String str, String def) {
        if (isEmpty(str)) {
            return def;
        }
        return str;
    }

    public static boolean isNameValid(String name) {
        return true;
    }

    public static boolean isEmailValid(String email) {
        if (email.length() == 0) {
            return true;
        }
        return Pattern.compile(EMAIL_REGEX, Pattern.CASE_INSENSITIVE)
                .matcher(email).matches();
    }

    public static boolean isMobilePhoneValid(String phoneNo) {
        return true;
    }
}