import java.io.*;
import java.util.*;

public class Main {
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int L = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        String[] words = new String[C];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < C; i++) {
            words[i] = st.nextToken();
        }
        Arrays.sort(words);
        permutation(new String[L], words, 0, 0, L, C);
        bw.flush();
        bw.close();

    }

    public static void permutation(String[] word, String[] alphabet, int cnt, int start, int L, int C) throws IOException {
        if (cnt == L) {
            if (isChecked(word)) {
                for (String w : word) {
                    bw.append(w);
                }
                bw.append("\n");
            }
            return;
        }

        for (int i = start; i < alphabet.length; i++) {
            word[cnt] = alphabet[i];
            permutation(word, alphabet, cnt + 1, i + 1, L, C);
        }
    }

    private static boolean isChecked(String[] word) {
        int cnt = 0;
        for (String w : word) {
            if (w.equals("a") || w.equals("e") || w.equals("i") || w.equals("o") || w.equals("u")) {
                cnt++;
            }
        }
        return cnt != 0 && word.length - cnt >= 2;
    }
}
