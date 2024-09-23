import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String word1 = sc.nextLine();
        String word2 = sc.nextLine();
        int[][] dp = new int[word1.length()+1][word2.length()+1];

        for(int i=0; i<=word1.length(); i++) {
            for(int j=0; j<=word2.length(); j++) {
                if(i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else if(word1.charAt(i-1) == word2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }

        System.out.println(dp[word1.length()][word2.length()]);
    }
}
