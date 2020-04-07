import java.util.Arrays;
import java.util.Collections;

class Solution {
  public long solution(long n) {
      long answer = 0;
      
      String str = Long.toString(n);
      String[] s = str.split("");
      
      Arrays.sort(s,Collections.reverseOrder());
      
     for(int i=0; i<s.length; i++){
         answer += Integer.parseInt(s[i]);
         answer *= 10;
     }
      answer /=10;
      
      return answer;
  }
}