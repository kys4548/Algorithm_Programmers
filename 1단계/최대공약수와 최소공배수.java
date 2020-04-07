import java.util.Arrays;

class Solution {
  public int[] solution(int n, int m) {
      int[] answer = {n, m};
      Arrays.sort(answer);
      
      while(true){
          if(answer[1] % answer[0] ==0)
              break;
          answer[1] %= answer[0];
          Arrays.sort(answer);
      }
      answer[1] = m * n / answer[0];
      return answer;
  }
}

//큰수를 작은수로 나눴을때 나머지가 0이되면 작은수가 최대공약수