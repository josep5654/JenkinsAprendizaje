package com.josepa.prueba.conocimientos.configs;

import java.util.Arrays;
import java.util.List;

public class StringUtil {

    public static boolean isNullOrEmpty(String string) {
        return string == null || string.isEmpty();
    }

    public static String getNullIfEmpty(String string) {
        if (string == null) return null;
        if (string.trim().equals("")) return null;
        return string;
    }

    public static String listToStringSemicolon(List<String> strings) {
        String string = "";
        for (String section : strings) {
            string += ";" + section;
        }
        if (string.startsWith(";")) string = string.substring(1);
        return string;
    }

    public static List<String> stringSemicolonToList(String string) {
        return Arrays.asList(string.split(";"));
    }

    /** Permite añadir un nuevo parametro al String que ya este separado por ";" */
    public static String addParameterToStringSplitedSemicolon(
            String stringToAdd, String stringSplited) {
        return (stringSplited.endsWith(";"))
                ? stringSplited + stringToAdd
                : stringSplited + ";" + stringToAdd;
    }

    /** Permite añadir una lista de Strings al String que ya este separado por ";" */
    public static String addParametersToStringSplitedSemicolon(
            List<String> stringsToAdd, String stringSplited) {

        for (String string : stringsToAdd) {
            stringSplited = addParameterToStringSplitedSemicolon(string, stringSplited);
        }
        return stringSplited;
    }
}
