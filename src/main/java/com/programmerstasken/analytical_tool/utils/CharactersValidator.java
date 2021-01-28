package com.programmerstasken.analytical_tool.utils;

import java.util.regex.Pattern;

public class CharactersValidator {
    private static final Pattern numericPattern = Pattern.compile("^\\d+(\\.\\d+)*$");

    public static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        return numericPattern.matcher(strNum).matches();
    }

    private static final Pattern datePattern = Pattern.compile("^(?:(?:31(\\/|-|\\.)(?:0?[13578]|1[02]))\\1|(?:(?:29|30)(\\/|-|\\.)(?:0?[13-9]|1[0-2])\\2))(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$|^(?:29(\\/|-|\\.)0?2\\3(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\\d|2[0-8])(\\/|-|\\.)(?:(?:0?[1-9])|(?:1[0-2]))\\4(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$");

    public static boolean isDate(String strDate) {
        if (strDate == null) {
            return false;
        }
        return datePattern.matcher(strDate).matches();
    }
}
