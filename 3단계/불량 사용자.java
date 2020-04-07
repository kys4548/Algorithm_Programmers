import java.util.Set;
import java.util.HashSet;

class Solution {
    
    Set<Integer> set = new HashSet<Integer>();
    int answer = 0;
    
    public int solution(String[] user_id, String[] banned_id) {
        boolean[] pick = new boolean[user_id.length];
        
        solve(user_id, banned_id, 0, pick);
        return answer;
    }
    
    public void solve(String[] user_id, String[] banned_id, int cursor, boolean[] pick) {
        //base case
        if(cursor >= banned_id.length) {
            int result = 0;
            for(int i=0; i<pick.length; i++) {
                if(pick[i] == true) {
                    result += Math.pow(2,i);
                }
            }
            if(!set.contains(result)) {
                answer++;
                set.add(result);
            }
            return;
        }
        
        //Recursion
        for(int i=0; i<user_id.length; i++) {
            if(pick[i] == false && isMatch(user_id[i], banned_id[cursor])) {
                pick[i] = true;
                solve(user_id, banned_id, cursor+1, pick);
                pick[i] = false;
            }
        }
    }
    
    public boolean isMatch(String s1, String s2) {
        if(s1.length() != s2.length()) {
            return false;
        }
        for(int i=0; i<s1.length(); i++) {
            if(s2.charAt(i) == '*') {
                continue;
            }
            if(s1.charAt(i) != s2.charAt(i)) {
                return false;
            }
        }
        return true;
    }
}