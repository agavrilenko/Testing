package org.my.hrank.utils;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.LinkedList;
import java.util.List;

public class ArrayUtils {
    public static <T extends Number> List<T> readArray(String line, Class<T> clazz) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        LinkedList<T> list = new LinkedList<>();
        String[] split = line.trim().split(" ");
        for (String in : split) {
            Constructor<T> con = clazz.getConstructor(String.class);
            list.add(con.newInstance(in));
        }
        return list;

    }
}
