import java.util.*;
class Solution {
    public String[] solution(String[] record) {
        HashMap<String, String> idNickname = new HashMap<>();
        HashMap<Integer, String> order = new HashMap<>();
        int cnt = 0;
        for (String rcd : record) {
            String[] split = rcd.split(" ");
            if (split[0].equals("Change") || split[0].equals("Enter")) {
                idNickname.put(split[1], split[2]);
            }

            if (split[0].equals("Enter") || split[0].equals("Leave")) {
                StringBuilder sb = new StringBuilder();
                sb.append(split[0]);
                sb.append(" ");
                sb.append(split[1]);
                order.put(cnt++, sb.toString());
            }
        }

        String[] answer = new String[order.size()];

        for (int i = 0; i < order.size(); i++) {
            String[] result = order.get(i).split(" ");
            StringBuilder stringBuilder = new StringBuilder();
            if (result[0].equals("Enter")) {
                stringBuilder.append(idNickname.get(result[1]));
                stringBuilder.append("님이 들어왔습니다.");
            }
            if (result[0].equals("Leave")) {
                stringBuilder.append(idNickname.get(result[1]));
                stringBuilder.append("님이 나갔습니다.");
            }
            answer[i] = stringBuilder.toString();
        }
        return answer;
    }
}