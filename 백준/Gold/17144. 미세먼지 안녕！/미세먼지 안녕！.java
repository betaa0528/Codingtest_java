import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    public static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        answer = 0;
        // 1. r,c,t를 입력받기
        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());
        // 2. 미세먼지 맵 생성
        int[][][] map = new int[r][c][2];
        Deque<int[]> q = new ArrayDeque<>();
        int[][] air = new int[2][2];
        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < c; j++) {
                int num = Integer.parseInt(st.nextToken());
                if (num == -1) {
                    if (air[0][0] == 0) {
                        air[0][0] = i;
                        air[0][1] = j;
                    } else {
                        air[1][0] = i;
                        air[1][1] = j;
                    }
                } else if (num != 0) {
                    q.add(new int[]{i, j});
                    answer += num;
                }
                map[i][j][0] = num;
            }
        }

        for(int i=0; i<t; i++) {
            dustDiffusion(map, r, c, q);
            refresh(map, air, r, c);
            q = qInput(map, r, c);
        }

        System.out.println(answer);
    }

    public static Deque<int[]> qInput(int[][][] map, int r, int c) {
        Deque<int[]> q = new ArrayDeque<>();
        for(int i=0; i<r; i++) {
            for(int j=0; j<c; j++) {
                if(map[i][j][0] != 0 && map[i][j][0] != -1) {
                    q.add(new int[]{i, j});
                }
            }
        }
        return q;
    }

    public static void dustDiffusion(int[][][] map, int r, int c, Deque<int[]> q) {
        int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int dust = map[cur[0]][cur[1]][0] / 5;
            for (int i = 0; i < dir.length; i++) {
                int nr = dir[i][0] + cur[0];
                int nc = dir[i][1] + cur[1];

                if (nr < 0 || nr >= r || nc < 0 || nc >= c || map[nr][nc][0] == -1) {
                    continue;
                }
                map[cur[0]][cur[1]][0] -= dust;
                map[nr][nc][1] += dust;
            }
        }

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                map[i][j][0] += map[i][j][1];
                map[i][j][1] = 0;
            }
        }
    }


    public static void refresh(int[][][] map, int[][] air, int r, int c) {
        // 1. 위쪽 공기청정기 아래로 이동
        for (int i = air[0][0] - 1; i >= 0; i--) {
            int nr = i + 1;
            int dust = map[i][0][0];
            if (map[nr][0][0] != -1) {
                map[nr][0][0] = dust;
            } else {
                answer -= dust;
            }
            map[i][air[0][1]][0] = 0;
        }

        for (int i = 1; i < c; i++) {
            map[0][i - 1][0] = map[0][i][0];
            map[0][i][1] = 0;
        }

        for (int i = 0; i < air[0][0]; i++) {
            map[i][c - 1][0] = map[i + 1][c - 1][0];
            map[i + 1][c - 1][0] = 0;
        }

        for (int i = c - 1; i > 1; i--) {
            map[air[0][0]][i][0] = map[air[0][0]][i - 1][0];
            map[air[0][0]][i - 1][0] = 0;
        }

        // 2. 아래쪽 공기 청정기 작동
        for (int i = air[1][0] + 1; i < r; i++) {
            int nr = i - 1;
            int dust = map[i][0][0];
            if (map[nr][0][0] != -1) {
                map[nr][0][0] = dust;
            } else {
                answer -= dust;
            }
            map[i][0][0] = 0;
        }

        for (int i = 1; i < c; i++) {
            map[r - 1][i - 1][0] = map[r - 1][i][0];
            map[r - 1][i][1] = 0;
        }

        for (int i = r - 1; i > air[1][0]; i--) {
            map[i][c - 1][0] = map[i - 1][c - 1][0];
            map[i - 1][c - 1][0] = 0;
        }

        for (int i = c - 1; i > 1; i--) {
            map[air[1][0]][i][0] = map[air[1][0]][i - 1][0];
            map[air[1][0]][i - 1][0] = 0;
        }
    }
}
