import java.util.ArrayList;

class Solution {
  public int solution(int n) {
      int answer = 0;
      ArrayList<Integer> al =new ArrayList<Integer>();
      al.add(0);
      al.add(1);
      
      for(int i=0; i<n-1; i++){
          
          al.add(al.get(i)%1234567 +al.get(i+1)%1234567);
      }
      answer = (int)al.get(n) %1234567;
      return answer;
  }
}