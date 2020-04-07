import java.util.HashSet;
import java.util.Iterator;

class Solution {
  public int solution(int n) {
      
      int answer = 0;
      HashSet<Integer> set = new HashSet<Integer>();
      
      for(int i=1; i <= Math.sqrt(n); i++){
          if(n % i ==0){
              set.add(i);
              set.add(n /i);
          }
      }
      Iterator i = set.iterator();
      while(i.hasNext()){
          answer += (int)i.next();
      }
      return answer;
  }
}