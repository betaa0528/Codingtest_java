import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
     public static int[] solution(int[] arr, String n1, String n2, String n3) {
        int start = Integer.parseInt(n1);
        int end = Integer.parseInt(n2);
        int num = Integer.parseInt(n3);
        for (int i = 0; i < end - start + 1; i++) {
            arr[start + i -1] = num;
        }

        return arr;
    }
    
     public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] range = bf.readLine().split(" ");
        int len = Integer.parseInt(range[0]);
        int[] arr = new int[len];
        for (int i = 0; i < Integer.parseInt(range[1]); i++) {
            String[] num = bf.readLine().split(" ");
            arr = solution(arr, num[0], num[1], num[2]);
        }

        for(int j=0 ; j<arr.length; j++) {
            if(j < arr.length - 1) System.out.print(arr[j] + " ");
            else System.out.print(String.valueOf(arr[j]));
        }
    }
}