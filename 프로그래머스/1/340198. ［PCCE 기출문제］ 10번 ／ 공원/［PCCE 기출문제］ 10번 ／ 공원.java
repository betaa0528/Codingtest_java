import java.util.*;
class Solution {
    public int solution(int[] mats, String[][] park) {
        Arrays.sort(mats);
        for(int i=0; i<mats.length/2; i++) {
            int tmp = mats[i];
            mats[i] = mats[mats.length - i - 1];
            mats[mats.length - i - 1] = tmp;
        }
        for(int mat : mats) {
            for(int i=0; i<park.length; i++) {
                for(int j=0; j<park[i].length; j++) {
                    if(park[i][j].equals("-1") && i+mat-1 < park.length && j+mat-1 < park[0].length) {
                        if(check(park, new int[]{i,j}, mat)) {
                            return mat;
                        }
                    }                   
                }
            }
        }
        return -1;
    }
    
    public static boolean check(String[][] park, int[] start, int mat) {
        for(int i=start[0]; i<start[0] + mat; i++) {
            for(int j=start[1]; j<start[1] + mat; j++) {
                if(!park[i][j].equals("-1")) {
                    return false;
                }
            }
        }
        return true;
    }
}