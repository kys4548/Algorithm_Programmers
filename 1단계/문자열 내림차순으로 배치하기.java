import java.util.Arrays;
import java.util.Comparator;

class Solution {
  public String solution(String s) {
      String answer = "";
      String[] str = s.split("");
      
      Arrays.sort(str,new Comparator<String>(){
         public int compare(String s1, String s2){
             return s2.compareTo(s1);
         } 
      });
      
      StringBuilder sb = new StringBuilder();
      for(int i=0; i<str.length; i++)
          sb.append(str[i]);
      answer = sb.toString();
      return answer;
  }
}