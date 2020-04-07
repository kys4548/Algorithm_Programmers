import java.util.Set;
import java.util.HashSet;

class Solution {
    public int solution(int n, int[][] results) {
        int answer = 0;
        Set[][] winOrLose = new Set[n][2];
        
        for(int i=0; i<n; i++) {
            for(int j=0; j<2; j++) {
                winOrLose[i][j] = new HashSet<Integer>();
            }
        }
        
        for(int[] result : results) {
            int winner = result[0] -1;
            int loser  = result[1] -1;
            
            winOrLose[winner][1].add(loser);
            winOrLose[loser][0].add(winner);
        }
        for(int a=0; a<2; a++) {
        for(int i=0; i<n; i++) {
            for(int j=0; j<2; j++) {
                Set set = winOrLose[i][j];
                
                for(int k=0; k<n; k++) {
                    if(set.contains(k) == true) {
                        set.addAll(winOrLose[k][j]);
                    }
                }
            }
        }
        }
        
        for(int i=0; i<n; i++) {
            int front = winOrLose[i][0].size();
            int back = winOrLose[i][1].size();
            
            if(front+back == n-1) {
                answer++;
            }
        }
        return answer;
    }
}