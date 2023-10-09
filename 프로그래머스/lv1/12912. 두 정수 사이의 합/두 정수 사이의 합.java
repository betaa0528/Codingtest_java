class Solution {
    public long solution(int a, int b) {
        int min = Math.min(a,b);
        int max = Math.max(a,b);
        if(min == max) {
            return (long)min;
        }

        return (((long) (max + 1) * max) / 2) - (((long) min * (min - 1)) / 2);
    }
}