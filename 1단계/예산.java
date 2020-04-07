import java.util.Arrays;

class Solution {
  public int solution(int[] d, int budget) {
      int sum =0;
      int answer = 0;
      
      Arrays.sort(d);
      for(Integer num : d){
          sum +=num;
          if(sum > budget)
              break;
          answer++;
      }
      return answer;
  }
}