package org.my.hrank.algorithms.strings.group_anagrams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupAnagramSolution {

    public List<List<String>> groupAnagrams(String[] strs) {

        HashMap<String, List> buffer = new HashMap<>();
        for (String str:strs) {
            char[] buff = str.toCharArray();
            Arrays.sort(buff);
            String tmp = new String(buff);
            if(buffer.get(tmp) == null){
                buffer.put(tmp, new ArrayList());
            }
            buffer.get(tmp).add(str);
        }
        return new ArrayList(buffer.values());

    }
}
