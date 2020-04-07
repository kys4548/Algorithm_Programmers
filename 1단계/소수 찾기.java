import java.util.Arrays;

class Solution {
  public int solution(int n) {
      boolean[] list = new boolean[n+1];
      Arrays.fill(list,true);
      list[0] = false;
      list[1] = false;
      
      for(int i=2; i<=Math.sqrt(n); i++){
          if(list[i]==false)
              continue;
          for(int j = i+i; j <= n; j = j+i)
              list[j] = false;
      }
      int answer = 0;
      
      for(int i = 0 ; i< n+1; i++){
          if(list[i]==true)
              answer++;
      }
      return answer;
  }
}