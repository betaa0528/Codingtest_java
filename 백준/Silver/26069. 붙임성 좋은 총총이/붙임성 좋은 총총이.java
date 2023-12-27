import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int len = Integer.parseInt(br.readLine());
        HashMap<String, Integer> hm = new HashMap<>();
        hm.put("ChongChong", 1);
        while(len --> 0) {
            String[] arr= br.readLine().split(" ");
            hm.put(arr[0], hm.getOrDefault(arr[0], 0));
            hm.put(arr[1], hm.getOrDefault(arr[1], 0));
            if(hm.get(arr[0]) == 1 || hm.get(arr[1]) == 1) {
                hm.replace(arr[0], 1);
                hm.replace(arr[1], 1);
            }
        }
        int cnt = 0;
        Set<String> strings = hm.keySet();
        for(String s : strings) {
            if(hm.get(s) == 1) cnt++;
        }
        System.out.println(cnt);
    }
}