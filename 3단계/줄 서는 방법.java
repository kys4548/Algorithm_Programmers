import java.util.Set;
class Solution {
  public int[] solution(int n, long k) {
      int[] answer = new int[n];
      boolean[] used = new boolean[n];
      long div = 1;
      int index = 1;
      
      for(int i=2; i<n; i++) {
          div *= i;
      }
      
      for(int i=0; i<n-1; i++) {
          index = (int)((k-1) / div) +1;
          int count = 0;
          for(int j=0; j<n; j++) {
              if( used[j] == false) {
                  count++;
              }
              else {
                  continue;
              }
              if(count == index) {
                  used[j] = true;
                  answer[i] = j+1;
                  break;
              }
          }
          
          k %= div;
          if(k==0) {
              k = div;
          }
          div /= (n-1 -i);
      }
      for(int i=0; i<n; i++) {
          if(used[i] == false){
              answer[n-1] = i+1;
              break;
          }
      }
      return answer;
  }
}