import java.util.*;
class Solution {
    public String solution(String new_id) {
        new_id = new_id.toLowerCase();
        StringBuilder sb = new StringBuilder();
        String esp = "~!@#$%^&*()=+[{]}:?,<>/";
        char[] charArray = esp.toCharArray();
        Set<String> set = new HashSet<>();
        Deque<String> stack = new ArrayDeque<>();
        for (char c : charArray) {
            set.add(String.valueOf(c));
        }
        // 특수문자 제거
        for (int i = 0; i < new_id.length(); i++) {
            if (!set.contains(String.valueOf(new_id.charAt(i)))) {
                sb.append(new_id.charAt(i));
            }
        }
        new_id = sb.toString();
        // ... 여러개 한개로 통합
        while (new_id.contains("..")) {
            new_id = new_id.replace("..", ".");
        }
        // 처음과 마지막 . 제거
        if (!new_id.isEmpty()) {
            if (new_id.charAt(0) == '.') {
                new_id = new_id.substring(1);
            }

            if (!new_id.isEmpty() && (new_id.charAt(new_id.length() - 1) == '.')) {
                new_id = new_id.substring(0, new_id.length() - 1);
            }
        }
        // 빈 문자열이면 new_id = a 대입
        if (new_id.isEmpty()) {
            new_id = "a";
        }
        //  16자 이상이면, new_id의 첫 15개의 문자를 제외한 나머지 문자들을 모두 제거합니다.
//        만약 제거 후 마침표(.)가 new_id의 끝에 위치한다면 끝에 위치한 마침표(.) 문자를 제거합니다.
        if (new_id.length() >= 16) {
            new_id = new_id.substring(0, 15);
            if (new_id.charAt(14) == '.') {
                new_id = new_id.substring(0, 14);
            }
        }

//        new_id의 길이가 2자 이하라면, new_id의 마지막 문자를 new_id의 길이가 3이 될 때까지 반복해서 끝에 붙입니다.
        StringBuilder sb2 = new StringBuilder(new_id);
        while (sb2.length() <= 2) {
            sb2.append(new_id.charAt(new_id.length() - 1));
        }
        return sb2.toString();
    }
}