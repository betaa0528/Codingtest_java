import java.io.*;
import java.util.*;

class Main{
    public static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] eggs = new int[n][2];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            eggs[i][0] = Integer.parseInt(st.nextToken());
            eggs[i][1] = Integer.parseInt(st.nextToken());
        }
        crashEgg(eggs, 0);
        System.out.println(answer);
    }

    public static void crashEgg(int[][] eggs, int now) {
        answer = Math.max(answer, findCrashedEgg(eggs));
        if(now == eggs.length) {
            return;
        }
        


        for (int i = 0; i < eggs.length; i++) {
            if (eggs[now][0] <= 0) {
                crashEgg(eggs, now + 1);
                continue;
            }

            if (now == i || eggs[i][0] <= 0) {
                continue;
            }

            eggs[now][0] -= eggs[i][1];
            eggs[i][0] -= eggs[now][1];
            crashEgg(eggs, now + 1);
            eggs[now][0] += eggs[i][1];
            eggs[i][0] += eggs[now][1];
        }

    }

    private static int findCrashedEgg(int[][] eggs) {
        int cnt = 0;
        for (int[] egg : eggs) {
            cnt += egg[0] <= 0 ? 1 : 0;
        }
        return cnt;
    }
}