import java.util.Arrays;

class Solution {
    public int solution(int n) {
        int answer = 0;
        int[] memo = new int[n];
        Arrays.fill(memo, -1);
        
        for(int i=0; i<n; i++) {
            answer += solve(0, n, memo, i);
        }
        return answer;
    }
    
    public int solve(int depth, int n, int[] memo, int cursor) {
        //base case
        if(depth >= n-1) {
            if(possible(depth, memo, cursor) == true) {
                return 1;
            }
            else {
                return 0;
            }
        }
        int result = 0;
        
        for(int i=0; i<n; i++) {
            if(possible(depth, memo, cursor) == true) {
                memo[depth] = cursor;
                result += solve(depth+1, n, memo, i);
                memo[depth] = -1;
            }
            else {
                return 0;
            }
        }
        return result;
    }
    
    public boolean possible(int depth, int[] memo, int cursor) {
        boolean result = true;
        
        for(int i=0; i<depth; i++) {
            if( (memo[i] == cursor) || (depth-i == Math.abs(memo[i] - cursor))) {
                result = false;
                break;
            }
        }
        return result;
    }
}