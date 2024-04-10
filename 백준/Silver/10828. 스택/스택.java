import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int tc = Integer.parseInt(br.readLine());
        int idx = 0;
        List<String> list = new ArrayList<>();
        while (tc-- > 0) {
            String cmd = br.readLine();
            if (cmd.contains("push")) {
                list.add(cmd.split(" ")[1]);
            }
            idx = list.size() - 1;
            switch (cmd) {
                case "pop":
                    if (list.isEmpty()) {
                        bw.write(-1 + "\n");
                    } else {
                        bw.write(list.get(idx) + "\n");
                        list.remove(idx);
                    }

                    break;
                case "size":
                    bw.write(list.size() + "\n");
                    break;
                case "empty":
                    if (list.isEmpty()) {
                        bw.write(1 + "\n");
                    } else {
                        bw.write(0 + "\n");
                    }
                    break;
                case "top":
                    if (list.isEmpty()) {
                        bw.write(-1 + "\n");
                    } else {
                        bw.write(list.get(idx) + "\n");
                    }
                    break;
            }
        }
        bw.flush();
        bw.close();
    }
}