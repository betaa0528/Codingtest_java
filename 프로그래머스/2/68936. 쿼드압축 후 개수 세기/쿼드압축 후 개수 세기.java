class Solution {
    public static int zero = 0;
    public static int one = 0;
    public int[] solution(int[][] arr) {
        
        quad(arr, arr.length, 0, 0);
        return new int[]{zero, one};
    }
    
    public static void quad(int[][] arr, int n, int r, int c) {
        int z = 0;
        for(int i=r; i<n+r; i++) {
            for(int j=c; j<n+c; j++) {
                if(arr[i][j] == 0) {
                    z++;
                }
            }
        }
        
        if(z == n*n) {
            zero++;
        } else if(z == 0) {
            one++;
        } else {
            quad(arr, n/2, r, c);
            quad(arr, n/2, r, c+n/2);
            quad(arr, n/2, r+n/2, c);
            quad(arr, n/2, r+n/2, c+n/2);
        }
    }
}