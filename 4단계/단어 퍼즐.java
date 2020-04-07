import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Solution {
    public int solution(String[] strs, String t) {
        int answer = 0;
        int length = t.length();
        int[] memo = new int[length+1];
        Set<String> set = new HashSet<String>(Arrays.asList(strs));
        
        solve(strs, t, length, memo, set, length-1);
        answer = memo[0];
        if(answer > length)
            answer =-1;
        return answer;
    }
    
    public void solve(String[] strs, String t, int length, int[] memo, Set<String> set, int cursor) {
        //base case
        if(cursor < 0)
            return;
        
        int maxLength = Math.min(length, cursor+5);
        StringBuilder sb = new StringBuilder(t.substring(cursor, maxLength));
        
        int buflength = sb.length();
        int min = length+1;
        
        for(int i=buflength-1; i>=0; i--) {
            if(set.contains(sb.toString()) && memo[cursor+i+1]+1 < min) {
                min = memo[cursor+i +1] +1;
            }
            sb.deleteCharAt(i);
        }
        memo[cursor] = min;
        
        
        //재귀
        solve(strs, t, length, memo, set, cursor -1);
    }
}