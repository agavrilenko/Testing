public class IBInterivew {
    /*public int solution(int[] A) {
        int len = 1000005;
        int[] aux = new int[len];

        for (int i = 0; i < A.length; i++) {
            if (A[i] > 0) {
                aux[A[i]] = 1;
            }
        }
        for (int i = 1; i < aux.length; i++) {
            if(aux[i] == 0){
                return i;
            }
        }
        return len;
    }*/

    public int solution(int[] A) {
        if (A.length < 1) {
            return 0;
        }
        int cnt = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] < 0) {
                cnt++;
            }
            if (A[i] == 0) {
                return 0;
            }
        }
        if (cnt % 2 == 0) {
            return 1;
        } else {
            return -1;
        }
    }
}
