import java.util.HashMap;

class Solution {
  public String solution(String[] seoul) {
      HashMap<String, Integer> hm = new HashMap<String, Integer>();
    
      for(int i=0; i<seoul.length; i++)
          hm.put(seoul[i],new Integer(i));
      
      int idx = hm.get("Kim");
      String answer = "김서방은 "+idx+"에 있다";
      return answer;
  }
}