import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String a = br.readLine();
            if(a == null) break;
            String b = br.readLine();
            StringBuilder sb = new StringBuilder();

            int[][] aArr = new int[26][1];
            int[][] bArr = new int[26][1];
            for (int i = 0; i < a.length(); i++) {
                aArr[a.charAt(i) - 'a'][0]++;
            }

            for (int i = 0; i < b.length(); i++) {
                bArr[b.charAt(i) - 'a'][0]++;
            }
            for(int i=0; i<26; i++) {
                if(aArr[i][0] > 0 && bArr[i][0] > 0) {
                    int min = Math.min(aArr[i][0], bArr[i][0]);
                    for(int j=0; j<min; j++) {
                        sb.append((char) ('a' + i));
                    }
                }
            }

            System.out.println(sb.toString());
        }
        
    }
}