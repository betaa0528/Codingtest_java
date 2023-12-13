class Solution {
    public int[] solution(int[] arr) {
        int min = arr[0];
        int cnt = 0;
        for(int n : arr) {
            if(min > n) {
                min = n;
                cnt = 1;
            } else if(min == n) {
                cnt++;
            }
        }
        if(cnt == arr.length) {
            for(int i=0; i<arr.length; i++) {
                arr[i] = -1;
            }
            return arr;
        }
        int[] answer = new int[arr.length-cnt];
        int idx = 0;
        
        for(int i=0; i<arr.length; i++) {
            if(arr[i] != min) {
                answer[idx] = arr[i];
                idx++;
            }
        }
        
        return answer;
    }
}