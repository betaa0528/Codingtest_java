class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int now = health;
        int time = 0;
        int recover = 0;
        for(int[] attack : attacks) {
            if(now <= 0) {
                break;
            }
            if(attack[0] - time >= bandage[0]) {
                recover = ((attack[0] - time) * bandage[1]) + bandage[2] * ((attack[0] - time) / bandage[0]);
            } else {
                recover = bandage[1] * (attack[0] - time);
            }
            time = attack[0];
            now = now + recover >= health ? health : now + recover;
            now -= attack[1];
            // System.out.println("recover : " + recover + ", time :" + time + " , now : " + now);
            time++;
        }
        return now > 0 ? now : -1;
    }
}