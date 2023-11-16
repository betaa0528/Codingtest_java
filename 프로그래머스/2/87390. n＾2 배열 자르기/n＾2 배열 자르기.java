class Solution {
    public int[] solution(int n, long left, long right) {
        int[] answer = new int[(int) (right - left + 1)];
        int cnt = 0;
        for(long i = left ; i<right + 1; i++) {
            answer[cnt++] = (int) Math.max(i/n + 1, i%n + 1);
        }

        return answer;
    }
}