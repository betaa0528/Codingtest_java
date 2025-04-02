import java.util.*;

class Solution {
    public int solution(int[] stones, int k) {
        int answer = Integer.MAX_VALUE;
        Deque<int[]> q = new ArrayDeque<>();

        // 첫 번째 윈도우 초기화
        for (int i = 0; i < k; i++) {
            while (!q.isEmpty() && q.peekLast()[0] <= stones[i]) {
                q.pollLast();
            }
            q.addLast(new int[]{stones[i], i});
        }
        answer = Math.min(answer, q.peekFirst()[0]);

        // 슬라이딩 윈도우 이동
        for (int i = k; i < stones.length; i++) {
            // 새로운 값 추가 (현재 윈도우에서 최댓값 관리)
            while (!q.isEmpty() && q.peekLast()[0] <= stones[i]) {
                q.pollLast();
            }
            q.addLast(new int[]{stones[i], i});

            // 윈도우에서 벗어난 요소 제거
            if (q.peekFirst()[1] <= i - k) {
                q.pollFirst();
            }

            answer = Math.min(answer, q.peekFirst()[0]);
        }
        return answer;
    }
}
