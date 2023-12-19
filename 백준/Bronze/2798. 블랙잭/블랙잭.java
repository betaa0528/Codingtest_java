import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] condition = bf.readLine().split(" ");
        String[] arr = bf.readLine().split(" ");
        System.out.println(solution(condition, arr));
    }


    private static int solution(String[] condition, String[] arr) {
        final int blackJack = Integer.parseInt(condition[1]);
        int[] numArr = new int[Integer.parseInt(condition[0])];
        for (int i = 0; i < numArr.length; i++) {
            numArr[i] = Integer.parseInt(arr[i]);
        }
        Arrays.sort(numArr);
        int sum = 0;
        int max = 0;
        for (int i = 0; i < numArr.length - 2; i++) {
            for (int j = i + 1; j < numArr.length - 1; j++) {
                for (int k = j + 1; k < numArr.length; k++) {
                    sum = numArr[i] + numArr[j] + numArr[k];
                    if (sum == blackJack) return sum;
                    if (sum < blackJack && sum > max) max = sum;
                    sum = 0;
                }
            }
        }
        return max;
    }
}