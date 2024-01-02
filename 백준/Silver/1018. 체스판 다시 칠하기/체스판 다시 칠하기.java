import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] matrix = br.readLine().split(" ");
        int row = Integer.parseInt(matrix[0]);
        int col = Integer.parseInt(matrix[1]);
        String[] chess = new String[row];
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < row; i++) {
            chess[i] = br.readLine();
        }
        for(int j=0; j<row-7; j++) {
            String[] chess8x8 = new String[8];
            for(int k=0; k<col-7; k++) {
                for(int l=0; l<8; l++) {
                    chess8x8[l] = chess[j+l].substring(k, k+8);
                }
                int result = chessColor(chess8x8);
                min = Math.min(result, min);
            }
        }

        System.out.println(min) ;
    }

    public static int chessColor(String[] chess) {
        int tmp1 = 0;
        int tmp2 = 0;
        String black = "BWBWBWBW";
        String white = "WBWBWBWB";
        char[] blackArr = black.toCharArray();
        char[] whiteArr = white.toCharArray();

        for (int i = 0; i < 8; i++) {
            char[] charArray = chess[i].toCharArray();
            tmp1 += blackCompare(charArray, blackArr, whiteArr, 0, i);
            tmp2 += whiteCompare(charArray, blackArr, whiteArr, 0, i);
        }
        return Math.min(tmp1, tmp2);
    }

    public static int blackCompare(char[] charArr, char[] blackArr, char[] whiteArr, int tmp, int n) {
        for (int i = 0; i < 8; i++) {
            if (n % 2 == 0) {
                if(charArr[i] != whiteArr[i]) tmp++;
            } else {
                if(charArr[i] != blackArr[i]) tmp++;
            }
        }
        return tmp;
    }

    public static int whiteCompare(char[] charArr, char[] blackArr, char[] whiteArr, int tmp, int n) {
        for (int i = 0; i < 8; i++) {
            if (n % 2 == 0) {
                if(charArr[i] != blackArr[i]) tmp++;
            } else {
                if(charArr[i] != whiteArr[i]) tmp++;
            }
        }
        return tmp;
    }
}