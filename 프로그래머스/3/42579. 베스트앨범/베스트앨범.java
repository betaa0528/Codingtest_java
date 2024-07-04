import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        List<Integer> list = new ArrayList<>();
        Map<String, Integer> totalGenres = new HashMap<>();
        for (int i = 0; i < genres.length; i++) {
            totalGenres.put(genres[i], totalGenres.getOrDefault(genres[i], 0) + plays[i]);
        }
        List<Map.Entry<String, Integer>> entryList = new LinkedList<>(totalGenres.entrySet());
        entryList.sort(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });

        List<PriorityQueue<Integer[]>> pqs = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : entryList) {
            PriorityQueue<Integer[]> pq = new PriorityQueue<>(new Comparator<Integer[]>() {
                @Override
                public int compare(Integer[] o1, Integer[] o2) {
                    return o2[1] - o1[1];
                }
            });
            for (int i = 0; i < genres.length; i++) {
                if (entry.getKey().equals(genres[i])) {
                    pq.add(new Integer[]{i, plays[i]});
                }
            }
            pqs.add(pq);

        }

        for (PriorityQueue<Integer[]> pq : pqs) {
            int cnt = 2;

            while (cnt-- > 0 && !pq.isEmpty()) {
                list.add(pq.poll()[0]);
            }
        }

        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }
}