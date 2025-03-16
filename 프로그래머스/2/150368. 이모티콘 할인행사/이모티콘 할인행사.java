import java.util.*;
class Solution {
    public static Queue<int[]> pq;
    public int[] solution(int[][] users, int[] emoticons) {
        // 1번 40 2번 25
        // 40 30 /  40 40 일때 유저 두명이 구매함
        // 
        pq = new PriorityQueue<>((o1, o2) -> {
            int result = o2[0] - o1[0];
            if(result == 0) {
                result = o2[1] - o1[1];
            }
            return result;
        });

        // System.out.println(Math.pow(4, 7 ));
        int[] sale = {10, 20, 30, 40};
        permutation(0, new int[emoticons.length], sale, emoticons, 0, users);
        return pq.poll();
    }
    public static void permutation(int cnt, int[] arr, int[] sale, int[] emoticons, int s, int[][] users) {
        if(cnt == emoticons.length) {
            int[] result = new int[2];
            for(int[] user : users) {
                int sum = 0;
                for(int i=0; i<arr.length; i++) {
                    if(user[0] > sale[arr[i]]) {
                        continue;
                    }
                    sum += emoticons[i] * (100- sale[arr[i]]) / 100;
                }
                if(sum >= user[1]) {
                    result[0]++;
                } else {
                    result[1] += sum;
                }
                
            }
            pq.add(result);
            // System.out.println(Arrays.toString(result));
            return ;
        }
        
        for(int i=0; i<sale.length; i++) {
            for(int j=s; j<emoticons.length; j++) {
                arr[cnt] = i;
                permutation(cnt + 1, arr, sale, emoticons, j+1, users);
            }
        }
    }
}