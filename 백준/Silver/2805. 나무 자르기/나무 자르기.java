import java.io.*;
import java.util.*;
public class Main{
    static long M;
    static Long[] trees;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        long N = Integer.parseInt(st.nextToken());
        M = Long.parseLong(st.nextToken());

        trees = new Long[(int) N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            trees[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(trees, Comparator.reverseOrder());
        System.out.println(findHeight(0, trees[0]));
    }

    private static Long findHeight(long low, long high) {
        while(low <= high) {
            long mid = (low + high) / 2;
            if(plusTrees(mid) > M) {
                low = mid + 1;
            }else if(plusTrees(mid) == M) {
                return mid;
            } else {
                high = mid - 1;
            }
        }
        return high;
    }
    private static long plusTrees(long n) {
        long result = 0;
        for(long tree : trees) {
            if(tree <= n) break;
            result += tree - n;
        }
        return result;
    }
}