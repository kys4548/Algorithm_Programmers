import java.util.Arrays;

class Solution {
  public int[] solution(int n, int s) {
      if(n > s) {
          int[] fail = { -1};
          return fail;
      }
      
      int[] answer = new int[n];
      
      int devide = s / n;
      int remain = s % n;
      
      for(int i=0; i<n; i++) {
          answer[i] = devide + ( remain-- > 0 ? 1 : 0);
      }
      Arrays.sort(answer);
      return answer;
  }
}