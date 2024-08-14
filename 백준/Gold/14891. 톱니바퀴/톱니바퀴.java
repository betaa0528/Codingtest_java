import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] gears = new String[4];

        for (int i = 0; i < 4; i++) {
            gears[i] = br.readLine();
        }

        int k = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int gearIdx = Integer.parseInt(st.nextToken()) - 1;
            int direction = Integer.parseInt(st.nextToken());

            // 각 톱니바퀴의 회전 방향을 저장할 배열
            int[] rotations = new int[4];
            rotations[gearIdx] = direction;

            // 현재 톱니바퀴의 왼쪽 톱니바퀴를 검사하면서 회전 방향 결정
            for (int j = gearIdx; j > 0; j--) {
                if (gears[j].charAt(6) != gears[j - 1].charAt(2)) {
                    rotations[j - 1] = -rotations[j];
                } else {
                    break;
                }
            }

            // 현재 톱니바퀴의 오른쪽 톱니바퀴를 검사하면서 회전 방향 결정
            for (int j = gearIdx; j < 3; j++) {
                if (gears[j].charAt(2) != gears[j + 1].charAt(6)) {
                    rotations[j + 1] = -rotations[j];
                } else {
                    break;
                }
            }

            // 결정된 방향에 따라 톱니바퀴 회전
            for (int j = 0; j < 4; j++) {
                if (rotations[j] != 0) {
                    gears[j] = rotate(gears[j], rotations[j]);
                }
            }
        }

        int score = 0;
        for (int i = 0; i < 4; i++) {
            if (gears[i].charAt(0) == '1') {
                score += (1 << i); // 1, 2, 4, 8 점 계산
            }
        }

        System.out.println(score);
    }

    public static String rotate(String gear, int direction) {
        if (direction == 1) { // 시계 방향
            return gear.charAt(7) + gear.substring(0, 7);
        } else { // 반시계 방향
            return gear.substring(1) + gear.charAt(0);
        }
    }
}