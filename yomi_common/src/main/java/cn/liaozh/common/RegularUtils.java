package cn.liaozh.common;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularUtils {
    public RegularUtils() {
    }

    public static boolean match(String rex, String str) {
        Pattern pattern = Pattern.compile(rex);
        Matcher matcher = pattern.matcher(str);
        return matcher.matches();
    }

    public static boolean validationPhone(String phone) {
        return match("^1(3[0-9]|5[0-3,5-9]|7[1-3,5-8]|8[0-9])\\d{8}$", phone);
    }
}
