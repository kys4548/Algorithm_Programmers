class Solution {
    public int solution(String dirs) {
        int answer = 0;
        boolean[][][] maps = new boolean[11][11][2];
        int a = 5;
        int b = 5;
        int length = dirs.length();
        
        for(int i=0; i<length; i++) {
            char command = dirs.charAt(i);
            switch(command) {
                case 'U' :
                    if(a-1 < 0) {
                        break;
                    }
                    a--;
                    if(maps[a][b][0] == false) {
                        maps[a][b][0] = true;
                        answer++;
                    }
                    break;
                case 'R' :
                    if(b+1 >=11) {
                        break;
                    }
                    if(maps[a][b][1] == false) {
                        maps[a][b][1] = true;
                        answer++;
                    }
                    b++;
                    break;
                case 'D' :
                    if(a+1 >=11) {
                        break;
                    }
                    if( maps[a][b][0] == false) {
                        maps[a][b][0] = true;
                        answer++;
                    }
                    a++;
                    break;
                case 'L' :
                    if(b-1 < 0) {
                        break;
                    }
                    b--;
                    if(maps[a][b][1] == false) {
                        maps[a][b][1] = true;
                        answer++;
                    }
                    break;
            }
            
        }
        return answer;
    }
}