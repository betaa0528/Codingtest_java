class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] days = new int[progresses.length];
        StringBuilder sb = new StringBuilder();
        int[] max = {0, 0};
        for(int i=0; i<days.length; i++){
            days[i] = (100-progresses[i])/speeds[i] + progresses[i] == 100 ? (100-progresses[i])/speeds[i] : (100-progresses[i])/speeds[i]+1;
            if(i == 0 ){
                max[1] = days[i];
                max[0] = i;
            }
            if(days[i] > max[1] && i!=0) {
                sb.append(i-max[0]+",");
                max[1] = days[i];
                max[0] = i;
            }

        }
        sb.append(days.length-max[0]);
        int[] answer = new int[sb.toString().split(",").length];
        int index = 0;
        for(String s : sb.toString().split(",")){
            answer[index++] = Integer.parseInt(s);
        }
        return answer;
    }
}