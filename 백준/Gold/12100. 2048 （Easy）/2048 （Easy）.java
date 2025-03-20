import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public static int answer = 0;
    static int up = 0;
    static int down = 1;
    static int left = 2;
    static int right =3;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] board = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        permutation(board, 0, N);
        System.out.println(answer);

    }
    
    private static void updateMax(int[][] board, int N) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                answer = Math.max(answer, board[i][j]);
            }
        }
    }

    public static void permutation(int[][] board, int cnt, int N) {
        if (cnt == 5){
            updateMax(board, N);
            return;
        }

        permutation(moveRight(board, N), cnt + 1, N);
        permutation(moveLeft(board, N), cnt + 1, N);
        permutation(moveDown(board, N), cnt + 1, N);
        permutation(moveUp(board, N), cnt + 1, N);
    }

    public static int[][] moveRight(int[][] origin, int N) {
        int[][] board = new int[N][N];
        for(int i = 0; i < N; i++) {
            board[i] = Arrays.copyOf(origin[i], origin[i].length);
        }
        boolean[][] merged = new boolean[N][N];
        for(int i=N-1; i>=0; i--) {
            for(int j=N-1; j>=0; j--) {
                if(board[i][j] != 0) {
                    int now = board[i][j];
                    boolean flag = false;
                    int nr = i;
                    int nc = j;
                    while(true) {
                        nr += dir[right][0];
                        nc += dir[right][1];
                        if(nc >= N ) { // 범위를 벗어날때
                            break;
                        }

                        if((board[nr][nc] != 0 && board[nr][nc] != now) || (board[nr][nc] == now && merged[nr][nc])) {
                            break;
                        }

                        if(board[nr][nc] == now && !merged[nr][nc]) {
                            board[nr][nc] = now * 2;
                            merged[nr][nc] = true;
                            board[nr + dir[left][0]][nc + dir[left][1]] = 0;
                            break;
                        }
                        board[nr][nc] = now;
                        board[nr + dir[left][0]][nc + dir[left][1]] = 0;
                    }

                }
            }
        }

        return board;
    }

    public static int[][] moveLeft(int[][] origin, int N) {
        int[][] board = new int[N][N];
        for(int i = 0; i < N; i++) {
            board[i] = Arrays.copyOf(origin[i], origin[i].length);
        }
        boolean[][] merged = new boolean[N][N];
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(board[i][j] != 0) {
                    int now = board[i][j];
                    boolean flag = false;
                    int nr = i;
                    int nc = j;
                    while(true) {
                        nr += dir[left][0];
                        nc += dir[left][1];
                        if(nc < 0 ) { // 범위를 벗어날때
                            break;
                        }

                        if((board[nr][nc] != 0 && board[nr][nc] != now) || (board[nr][nc] == now && merged[nr][nc])) {
                            break;
                        }

                        if(board[nr][nc] == now && !merged[nr][nc]) {
                            board[nr][nc] = now * 2;
                            merged[nr][nc] = true;
                            board[nr + dir[right][0]][nc + dir[right][1]] = 0;
                            break;
                        }
                        board[nr][nc] = now;
                        board[nr + dir[right][0]][nc + dir[right][1]] = 0;
                    }

                }
            }
        }

        return board;
    }

    public static int[][] moveDown(int[][] origin, int N) {
        int[][] board = new int[N][N];
        for(int i = 0; i < N; i++) {
            board[i] = Arrays.copyOf(origin[i], origin[i].length);
        }
        boolean[][] merged = new boolean[N][N];
        for(int i=N-1; i>=0; i--) {
            for(int j=N-1; j>=0; j--) {
                if(board[j][i] != 0) {
                    int now = board[j][i];
                    boolean flag = false;
                    int nr = j;
                    int nc = i;
                    while(true) {
                        nr += dir[down][0];
                        nc += dir[down][1];
                        if(nr >= N ) { // 범위를 벗어날때
                            break;
                        }

                        if((board[nr][nc] != 0 && board[nr][nc] != now) || (board[nr][nc] == now && merged[nr][nc])) {
                            break;
                        }

                        if(board[nr][nc] == now && !merged[nr][nc]) {
                            board[nr][nc] = now * 2;
                            merged[nr][nc] = true;
                            board[nr + dir[up][0]][nc + dir[up][1]] = 0;
                            break;
                        }
                        board[nr][nc] = now;
                        board[nr + dir[up][0]][nc + dir[up][1]] = 0;
                    }

                }
            }
        }
        return board;
    }

    public static int[][] moveUp(int[][] origin, int N) {
        int[][] board = new int[N][N];
        for(int i = 0; i < N; i++) {
            board[i] = Arrays.copyOf(origin[i], origin[i].length);
        }
        boolean[][] merged = new boolean[N][N];
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(board[j][i] != 0) {
                    int now = board[j][i];
                    boolean flag = false;
                    int nr = j;
                    int nc = i;
                    while(true) {
                        nr += dir[up][0];
                        nc += dir[up][1];
                        if(nr < 0 ) { // 범위를 벗어날때
                            break;
                        }

                        if((board[nr][nc] != 0 && board[nr][nc] != now) || (board[nr][nc] == now && merged[nr][nc])) {
                            break;
                        }

                        if(board[nr][nc] == now && !merged[nr][nc]) {
                            board[nr][nc] = now * 2;
                            merged[nr][nc] = true;
                            board[nr + dir[down][0]][nc + dir[down][1]] = 0;
                            break;
                        }
                        board[nr][nc] = now;
                        board[nr + dir[down][0]][nc + dir[down][1]] = 0;
                    }

                }
            }
        }

        return board;
    }

    public static void print(int[][] board) {
        for(int[] row : board) {
            System.out.println(Arrays.toString(row));
        }
    }
}
