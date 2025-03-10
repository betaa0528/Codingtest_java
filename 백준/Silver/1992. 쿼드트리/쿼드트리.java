import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int[][] map = new int[N][N];
        for(int i=0; i<N; i++) {
            String str = br.readLine();
            for(int j=0; j<str.length(); j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }
        quad(N, 0, 0, map);
        System.out.println(sb.toString());
    }

    public static void quad(int N, int r, int c, int[][] map) {
        int cnt = 0;
        for(int i=r; i<N+r; i++) {
            for(int j=c; j<N+c; j++) {
                if(map[i][j] == 0) {
                    cnt++;
                }
            }
        }

        if(cnt == N*N) {
            sb.append("0");
        } else if(cnt == 0) {
            sb.append("1");
        } else {
            sb.append("(");
            quad(N/2, r, c, map);
            quad(N/2, r, c+N/2, map);
            quad(N/2, r+N/2, c, map);
            quad(N/2, r+N/2, c+N/2, map);
            sb.append(")");
        }
    }
}
