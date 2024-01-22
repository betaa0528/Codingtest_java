import java.io.*;
import java.util.*;
public class Main{
    public static int[] tmp;
    public static int count = 0;
    public static int K;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        K = sc.nextInt();
        tmp = new int[A];
        int[] arr = new int[A];
        for (int i = 0; i < A; i++) {
            arr[i] = sc.nextInt();
        }
        mergeSort(arr, 0, A - 1);
        if (count < K) {
            System.out.println(-1);
        }
    }

    public static void mergeSort(int[] arr, int start, int end) {
        if (start >= end) return;
        int mid = (start + end) / 2;
        mergeSort(arr, start, mid);
        mergeSort(arr, mid + 1, end);
        merge(arr, start, mid, end);
    }

    public static void merge(int[] arr, int start, int mid, int end) {
        int i = start;
        int j = mid + 1;
        int t = 0;
        while (i <= mid && j <= end) {
            if (arr[i] <= arr[j]) {
                tmp[t++] = arr[i++];
            } else {
                tmp[t++] = arr[j++];
            }
        }
        while (i <= mid) {
            tmp[t++] = arr[i++];
        }
        while (j <= end) {
            tmp[t++] = arr[j++];
        }
        i = start;
        t = 0;
        while (i <= end) {
            arr[i++] = tmp[t++];
            count++;
            if (count == K) {
                System.out.println(arr[i - 1]);
                return;
            }
        }
    }
}