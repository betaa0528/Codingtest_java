import java.util.*;
import java.io.*;
public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int len = Integer.parseInt(br.readLine());
        int[] arr = new int[len];
        int sum = 0;
        int avg = 0;
        int center = 0;
        int range = 0;
        int many = 0;
        Stack<Integer> stack = new Stack<>();
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < len; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            hm.put(arr[i], hm.getOrDefault(arr[i], 0) + 1);
            sum += arr[i];
        }
        for (int cnt : hm.keySet()) {
            if (hm.get(cnt) > many) {
                many = hm.get(cnt);
                stack.clear();
                stack.push(cnt);
            } else if (hm.get(cnt) == many) {
                stack.push(cnt);
            }
        }
        Arrays.sort(arr);
        if (stack.size() == 1) {
            many = stack.pop();
        } else {
            int[] manyArr = new int[stack.size()];
            int length = manyArr.length-1;
            while(!stack.isEmpty()) {
                manyArr[length--] = stack.pop();
            }
            Arrays.sort(manyArr);
            many = manyArr[1];
        }
        avg = (int) Math.round((double) sum / len);
        center = arr[len / 2];
        range = arr[len - 1] - arr[0];
        System.out.println(avg);
        System.out.println(center);
        System.out.println(many);
        System.out.println(range);
    }
}