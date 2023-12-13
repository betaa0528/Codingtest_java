import java.util.*;
class Solution {
    public long solution(long n) {
        char[] charArrN = String.valueOf(n).toCharArray();
        int[] intArr = new int[charArrN.length];
        for(int i=0; i<intArr.length; i++) {
            intArr[i] = charArrN[i]-48;
        }
        Arrays.sort(intArr);
        StringBuilder sb = new StringBuilder();
        for(int num : intArr) {
            sb.append(num+"");
        }
        return Long.parseLong(sb.reverse().toString());
    }
}