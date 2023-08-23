class Solution {
    public int[] solution(String[] wallpaper) {
        int[] XY = {99, 99 , 0, 0};
        for(int i=0; i<wallpaper.length; i++) {
            if(wallpaper[i].contains("#")) {
                for (int j = 0; j < wallpaper[i].length(); j++) {
                    if(wallpaper[i].charAt(j) == '#'){
                        if(i < XY[0]){
                            XY[0] = i;
                        }

                        if(j < XY[1]) {
                            XY[1] = j;
                        }

                        if(i > XY[2]){
                            XY[2] = i;

                        }
                        if(j > XY[3]){
                            XY[3] = j;
                        }

                    }

                }
            }
        }
        int[] answer = {XY[0], XY[1], XY[2]+1, XY[3]+1};
        return answer;
    }
}