import java.util.*;
class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int sec = 0;
        int weightOnBridge = 0;
        LinkedList<Integer> weights = new LinkedList<>();
        for(int w : truck_weights) {
            weights.add(w);
        }
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0; i<bridge_length-1; i++){
            queue.add(0);
        }

        while(true) {
            if(!weights.isEmpty()){
                if ((queue.isEmpty() || queue.size() < bridge_length) && ((weightOnBridge + weights.peek()) <= weight)) {
                    weightOnBridge += weights.peek();
                    queue.add(weights.peek());
                    weights.poll();
                } else if(queue.size() < bridge_length){
                    queue.add(0);
                }
            }

            if(sec >= 1) {
                weightOnBridge -= queue.peek();
                queue.poll();
            }
            sec++;
            if(queue.isEmpty()) break;

        }
        return sec;
    }
}