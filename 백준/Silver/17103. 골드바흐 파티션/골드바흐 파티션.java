import java.util.*;
import java.io.*;
public class Main{
    static HashSet<Integer> hs = new HashSet<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        Scanner sc = new Scanner(System.in);
//        st = new StringTokenizer(br.readLine());
        int tc = Integer.parseInt(br.readLine());
        int cnt = 0;
        ArrayList<Integer> al = astra();
        while (tc-- > 0) {
            int a = Integer.parseInt(br.readLine());
            for (int i = 0; i < al.size(); i++) {
                if (al.get(i) > a / 2) break;
                int tmp = a - al.get(i);
                if(hs.contains(tmp)) cnt++;
            }
            bw.write(cnt + "\n");
            cnt = 0;
        }
        bw.flush();
        bw.close();
    }

    private static ArrayList<Integer> astra() {
        boolean[] chk = new boolean[1000001];
        ArrayList<Integer> al = new ArrayList<>();
        int idx = 2;
        for (int i = idx; i < chk.length; i++) {
            if (!chk[i]) {
                al.add(i);
                hs.add(i);
                for (int j = i + i; j < chk.length; j += i) {
                    chk[j] = true;
                }
            }
        }
        return al;
    }
}