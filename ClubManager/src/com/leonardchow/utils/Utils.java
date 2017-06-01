package com.leonardchow.utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Utils {
    public static String readFromConsole() {
        InputStreamReader input = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(input);
        try {
            return reader.readLine();
        } catch (Exception e){
            System.err.println("Exception error=" + e.getMessage());
            return null;
        }
    }

    public static <T, U> List<U> convertList(List<T> from, Function<T, U> func) {
        return from.stream().map(func).collect(Collectors.toList());
    }
}

