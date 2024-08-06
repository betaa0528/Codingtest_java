import java.util.*;
class Solution {
    public static int[][] coordinate = {
        {-1, 0}, {-2, 0}, {0, -1}, {0, -2},
        {1, 0}, {2, 0}, {0, 1}, {0, 2},
        {-1, 1}, {-1, -1,}, {1, -1}, {1, 1}
    };
    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];
        Arrays.fill(answer, 1);
        int index = 0;
        for(String[] place : places) {
            List<int[]> list = findPerson(place);
            for(int[] person: list) {
                if(!manhattan(place, person)) {
                    answer[index] = 0;
                    break;
                }
            }
            index++;
        }
        return answer;
    }
    
    public static boolean manhattan(String[] place, int[] person) {
        for(int i = 0; i<12; i++) {
            int nx = person[0] + coordinate[i][0];
            int ny = person[1] + coordinate[i][1];
            if(nx < 0 || ny < 0 || nx >= place.length || ny >= place[0].length() ) {
                continue;
            }
            
            if(i > 7) {
                if(place[nx].charAt(person[1]) == 'X' && place[person[0]].charAt(ny) == 'X') {
                    continue;
                }
            }
            
            if(place[nx].charAt(ny) == 'P') {
                System.out.println(person[0] + ", " + person[1] +
                                  "\t" + nx + ", " + ny);
                return false;
            }
            
            if(coordinate[i][0] == 0 && Math.abs(coordinate[i][1]) == 1  || coordinate[i][1] == 0 && Math.abs(coordinate[i][0]) == 1) {
                if(place[nx].charAt(ny) == 'X') {
                    i += 1;
                }
            }
        }
        return true;
    }
    
    public static List<int[]> findPerson(String[] place) {
        List<int[]> list = new ArrayList<>();
        for(int i=0; i<place.length; i++) {
            for(int j=0; j<place[0].length(); j++) {
                if(place[i].charAt(j) == 'P') {
                    list.add(new int[]{i, j});
                }
            }
        }
        return list;
    }
}