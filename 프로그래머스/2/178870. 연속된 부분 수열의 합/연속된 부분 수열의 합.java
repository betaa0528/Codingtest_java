class Solution {
    public int[] solution(int[] sequence, int k) {
        int left = 0;
        int right = 0;
        int sum = sequence[0];
        int[] answer = {0,1000000};
        while(right < sequence.length-1) {
            right++;
            sum += sequence[right];
            while(sum > k) {
                sum -= sequence[left];
                left++;
            }

            if(sum == k) {
                if(answer[1] - answer[0] > right - left) {
                    answer = new int[]{left, right};
                }
            }
        }
        return answer;
    }
}