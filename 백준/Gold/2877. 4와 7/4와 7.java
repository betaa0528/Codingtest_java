import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int cnt = 1;
        int sum = 0;
        while (true) {
            sum += Math.pow(2, cnt++);
            if (sum >= n) {
                break;
            }
        }

        int len = cnt - 1;
        int idx = (int) Math.pow(2, len) - (sum - n);
        StringBuilder tmp = new StringBuilder();
        String bit = Integer.toBinaryString(idx-1);
        while (tmp.length() + bit.length() < len) {
            tmp.append('0');
        }
        tmp.append(bit);

        StringBuilder answer = new StringBuilder();
        for(int j=0; j<tmp.length(); j++) {
            if(tmp.charAt(j) == '0') {
                answer.append('4');
            } else {
                answer.append('7');
            }
        }
        System.out.println(answer);
    }
}
