import java.util.*;
import java.io.*;
class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Map<String, Integer> map = new HashMap<>();
        String[] arr = new String[n];
        int answer = 0;
        for(int i=0; i<n; i++) {
           map.put(br.readLine(), i);
        }
        for(int i=0; i<n; i++) {
            arr[i] = br.readLine();
        }
        
        for(int i=0; i<n; i++) {
            String car = arr[i];
            int idx = i+1;
            while(idx < n) {
                if(map.get(arr[i]) > map.get(arr[idx])) {
                    answer++;
                    break;
                }
                idx++;
            }
        }
        System.out.println(answer);
    }
}