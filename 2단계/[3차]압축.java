import java.util.HashMap;
import java.util.ArrayList;
class Solution {
  public int[] solution(String msg) {
      String arr[] = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
      ArrayList<Integer> al = new ArrayList<Integer>();
      int num = 27;
      HashMap hm = new HashMap<String, Integer>();
      for(int i=0; i<26; i++){
          hm.put(arr[i],i+1);
      }
      
      int length = 0;
      while(length <msg.length()){
          String s = String.valueOf(msg.charAt(length));
          int index = 0;
          if(hm.containsKey(s)){
              while(hm.containsKey(s)){
                  index= (int)hm.get(s);
                  length++;
                  if(length >= msg.length())
                      break;
                  s += String.valueOf(msg.charAt(length));
              }
              al.add(index);
              hm.put(s,num++);
          }
      }
      int[] answer = new int[al.size()];
      for(int i=0; i<al.size(); i++){
              answer[i] = al.get(i);
          }
      
      return answer;
  }
}