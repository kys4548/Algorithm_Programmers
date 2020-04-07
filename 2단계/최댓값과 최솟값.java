import java.util.ArrayList;
import java.util.Collections;

class Solution {
  public String solution(String s) {
      String[] str = s.split(" ");
      ArrayList<Integer> al = new ArrayList<Integer>();
      
      for(String s1 : str){
          al.add(Integer.parseInt(s1));
      }
      int min = Collections.min(al);
      int max = Collections.max(al);
      
      String answer = min+" "+max;
      return answer;
  }
}