package org.my.hrank.algorithms.strings.urlify;

public class URLifySolution {
    public String getString(String st) {

        char[] in = st.toCharArray();
        boolean started = false;
        int lastIdx = in.length - 1;
        for (int i = in.length - 1; i >= 0; i--) {
            if (in[i] != ' ' || started) {
                started = true;
                if (in[i] != ' ') {
                    in[lastIdx--] = in[i];
                } else {
                    in[lastIdx--] = '0';
                    in[lastIdx--] = '2';
                    in[lastIdx--] = '%';
                }

            }
        }
        return new String(in);
    }

}
