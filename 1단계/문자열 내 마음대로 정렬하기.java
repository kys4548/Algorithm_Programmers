import java.util.Arrays;
import java.util.Comparator;

class Solution {
  public String[] solution(String[] strings, int n) {
      
      Arrays.sort(strings, new Comparator<String>(){
          @Override
          public int compare(String left, String right){
              if(left.charAt(n)==right.charAt(n)){
                  return left.compareTo(right);
              }else{
                  return left.charAt(n) - right.charAt(n);
              }
          }
      });
      
      return strings;
  }
}