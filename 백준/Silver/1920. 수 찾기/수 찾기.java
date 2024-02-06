import java.io.*;
import java.util.*;
public class Main{
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st1, st2;
        int N = Integer.parseInt(br.readLine());
        st1 = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(br.readLine());
        st2 = new StringTokenizer(br.readLine());
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st1.nextToken());
        }
        Arrays.sort(arr);

        for (int j = 0; j < M; j++) {
            bw.write(binarySearch(Integer.parseInt(st2.nextToken()), 0, N-1) + "\n");
        }
        bw.flush();
        bw.close();
    }
    private static int binarySearch(int n, int start, int end) {
        while(start <= end) {
            int mid = (start + end) / 2;
            if (arr[mid] == n) {
                return 1;
            } else if (arr[mid] < n) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return 0;
    }
}