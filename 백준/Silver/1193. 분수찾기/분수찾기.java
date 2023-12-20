import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(bf.readLine());
        System.out.println(solution(num));
    }


    private static String solution(int num) {
        int row = 0;
        int col = 0;
        int preRow = 0;
        int preCol = 0;
        int answer = 1;
        int cnt = 0;
        while (true) {
            if (answer == num) return (row + 1) + "/" + (col + 1);

            if (row == 0 && col == 0) {
                preRow = row;
                preCol = col;
                col++;
                answer++;
            } else if (row == 0 && col != 0) {
                answer++;
                if (preRow != 0) {
                    preRow = row;
                    preCol = col;
                    col++;
                } else {
                    preRow = row;
                    preCol = col;
                    row++;
                    col--;
                }

            } else if (row != 0 && col == 0) {
                answer++;
                if (preCol != 0) {
                    preRow = row;
                    preCol = col;
                    row++;
                } else {
                    preRow = row;
                    preCol = col;
                    row--;
                    col++;
                }

            } else if (row != 0 && col != 0) {
                if (preRow < row && preCol > col) {
                    preRow = row;
                    preCol = col;
                    row++;
                    col--;
                } else {
                    preRow = row;
                    preCol = col;
                    row--;
                    col++;
                }
                answer++;
            }
        }
    }
}