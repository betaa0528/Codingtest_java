import java.util.*;
class Solution {
    public int[] solution(int n, String[] words) {
        HashSet<String> hs = new HashSet<>();
        for (int i = 0; i < words.length; i++) {
                        if(i > 0) {
                if (hs.contains(words[i]) || words[i].charAt(0) != words[i - 1].charAt(words[i - 1].length()-1)) {
                    return new int[]{i % n + 1, i / n + 1};
                }
            }

            if (!hs.contains(words[i])) {
                hs.add(words[i]);
                continue;
            }

            return new int[]{0, 0};
        }

        return new int[]{0, 0};
    }
}