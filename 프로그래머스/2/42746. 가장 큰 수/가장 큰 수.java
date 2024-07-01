import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        List<String> strs = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<numbers.length; i++) {
            strs.add(numbers[i] + "");
        }

        strs.sort((o1, o2) -> {
            return (o2 + o1).compareTo(o1 +o2);
        });
        if(strs.get(0).equals("0")) {
            return "0";
        }
        for(String str : strs) {
            sb.append(str);
        }
        return sb.toString();
    }
}