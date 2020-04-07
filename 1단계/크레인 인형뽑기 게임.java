import java.util.ArrayList;
import java.util.List;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        int length = board.length;
        List<Integer> list = new ArrayList<Integer>();
        
        int[] height = new int[length];
        
        for(int j=0; j<length; j++) {
            for(int i=0; i<length; i++) {
                if(board[i][j] != 0) {
                    height[j] = i;
                    break;
                }
            }
        }
        
        for(int i=0; i<moves.length; i++) {
            int pick = moves[i] - 1;
            if(height[pick] >= length) {
                continue;
            }
            
            
            list.add(board[height[pick]][pick]);
            board[height[pick]][pick] = 0;
            
            
            while(list.size() >=2 && list.get(list.size()-1) == list.get(list.size()-2)) {
                list.remove(list.size()-1);
                list.remove(list.size()-1);
                answer += 2;
            }
            
            height[pick]++;
        }
        
        return answer;
    }
}