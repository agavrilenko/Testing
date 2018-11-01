package org.my.hrank.utils;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
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

    /**
     * Insert items into sorted array
     *
     * @param values
     * @param value
     * @return
     */
    public static ArrayList<Long> binaryInsert(ArrayList<Long> values, long value) {
        ArrayList<Long> result = new ArrayList<>(values.size() + 1);
        result.addAll(values);
        if (result.size() == 0) {
            result.add(value);
            return result;
        }
        if (result.size() == 1) {
            if (value >= result.get(0)) {
                result.add(value);
            } else {
                result.add(0, value);
            }
            return result;
        }
        int left = 0;
        int right = result.size() - 1;
        int middle = -1;
        int position = -1;
        while (position == -1) {

            if (right - left == 1) {
                if (value <= result.get(right)) {
                    position = right;
                }
                if (value > result.get(right)) {
                    position = right + 1;
                }
                if (value < result.get(left)) {
                    position = left;
                }
            }
            middle = (left + right + 1) / 2;
            if (value > result.get(middle)) {
                left = middle;
            }
            if (value < result.get(middle)) {
                right = middle;
            }
            if (value == result.get(middle)) {
                position = middle + 1;
                break;
            }

        }
        result.add(position, value);

        return result;
    }

}
