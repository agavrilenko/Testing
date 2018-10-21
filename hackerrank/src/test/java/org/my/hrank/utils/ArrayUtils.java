package org.my.hrank.utils;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class ArrayUtils {
    public static <T extends Number> List<T> readArray(Scanner outScanner, Class clazz) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        LinkedList<T> list = new LinkedList<>();
        String[] split = outScanner.nextLine().trim().split(" ");
        for (String in : split) {
            Constructor con = clazz.getConstructor(String.class);
            list.add((T) con.newInstance(in));
        }
        return list;

    }
}
