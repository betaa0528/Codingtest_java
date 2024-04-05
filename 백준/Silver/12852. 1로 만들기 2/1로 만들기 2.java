import java.io.*;
import java.util.*;

public class Main {
    static List<Integer> arr = new ArrayList<>();
    static HashMap<Integer, String> hashMap = new HashMap<>();

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        arr.add(0);
        arr.add(0);
        arr.add(1);
        arr.add(1);
        hashMap.put(1, "1");
        hashMap.put(2, "2 1");
        hashMap.put(3, "3 1");
        for (int i = 4; i < n + 1; i++) {
            min(i);
        }
        System.out.println(arr.get(n));
        System.out.println(hashMap.get(n));
    }

    static void min(int a) {
        if (a % 6 == 0){
            int tmp = arr.get(a/3) > arr.get(a/2) ? 0 : 1;
            if(tmp == 0) {
                arr.add(arr.get(a/2) + 1);
                hashMap.put(a, a + " " + hashMap.get(a/2));
            } else {
                arr.add(arr.get(a/3) + 1);
                hashMap.put(a, a + " " + hashMap.get(a/3));
            }
        } else if (a % 3 == 0) {
            int tmp = arr.get(a/3) > arr.get(a-1) ? 0 : 1;
            if(tmp == 0) {
                arr.add(arr.get(a-1) + 1);
                hashMap.put(a, a + " " + hashMap.get(a-1));
            } else {
                arr.add(arr.get(a/3) + 1);
                hashMap.put(a, a + " " + hashMap.get(a/3));
            }
        } else if (a % 2 == 0) {
            int tmp = arr.get(a/2) > arr.get(a-1) ? 0 : 1;
            if(tmp == 0) {
                arr.add(arr.get(a-1) + 1);
                hashMap.put(a, a + " " + hashMap.get(a-1));
            } else {
                arr.add(arr.get(a/2) + 1);
                hashMap.put(a, a + " " + hashMap.get(a/2));
            }
        } else {
            arr.add(arr.get(a-1) + 1);
            hashMap.put(a, a + " " + hashMap.get(a-1));
        }
    }
}