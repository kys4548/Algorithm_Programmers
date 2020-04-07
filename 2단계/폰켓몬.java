import java.util.HashSet;
import java.util.Set;
import java.util.Arrays;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        int maxNum = nums.length /2;
        Set<Integer> set = new HashSet<Integer>();
        
        for(int bno : nums) {
            set.add(bno);
        }
        answer = Math.min(set.size(),maxNum);
        
        return answer;
    }
}