class Solution {
    static int answer = 0 ;
    public static int solution(int[] numbers, int target) {
        fs(0,0,target,numbers);
        return answer;
    }

    public static void fs(int sum, int index, int target, int[] numbers) {
        if (sum == target && index == numbers.length) {
            answer++;
            return;
        }

        if(index >= numbers.length) {
            return;
        }

        fs(sum + numbers[index], index+1, target, numbers);
        fs(sum - numbers[index], index+1, target, numbers);
    }
}