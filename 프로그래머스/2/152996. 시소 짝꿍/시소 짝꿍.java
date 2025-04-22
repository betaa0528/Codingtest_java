class Solution {
    public long solution(int[] weights) {
        long answer = 0;
        long[] arr = new long[1001];
        for(int weight : weights) {
            arr[weight]++;
        }
        
        for(int i=100; i<arr.length; i++) {
            if(arr[i] == 0) {
                continue;
            }
            if(arr[i] > 1) {
                // System.out.println("갯수가 1보다 많음" + arr[i] +" ," + combi(arr[i], 2));
                answer += (long) arr[i] * (arr[i] - 1) / 2;
            }
            for(int j=4; j>=3; j--) {
                for(int k=j-1; k>=2; k--) {
                    if(i*j/k > 1000) continue;
                    if((i*j % k) == 0 && arr[(i*j/k)] != 0) {
                        answer += (arr[i] * arr[(i*j/k)]);
                    }
                }
            }
        }
        return answer;
    }
}