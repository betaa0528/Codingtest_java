class Solution {
    static boolean[] visit;
    static int max = 0;
    public int solution(int k, int[][] dungeons) {
        visit = new boolean[dungeons.length];
        adventure(k, 0, dungeons);
        return max;
    }
    public static void adventure(int p, int cnt,int[][] dungeons) {
        if (cnt > max) {
            max = Math.max(cnt, max);
        }

        for (int i = 0; i < dungeons.length; i++) {
            if (!visit[i] && p >= dungeons[i][0]) {
                visit[i] = true;
                adventure(p - dungeons[i][1], cnt + 1, dungeons);
                visit[i] = false;
            }
        }
    }
}