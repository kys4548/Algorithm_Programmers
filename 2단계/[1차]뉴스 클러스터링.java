import java.util.ArrayList;

class Solution {
  public int solution(String str1, String str2) {
      int intersection = 0;
      int union =0;
      int answer = 0;
      
      str1 = str1.toLowerCase();
      str2 = str2.toLowerCase();
      ArrayList<String> al1 = new ArrayList<String>();
      ArrayList<String> al2 = new ArrayList<String>();
      
      for(int i=0; i<str1.length()-1; i++){
          char c1 = str1.charAt(i);
          char c2 = str1.charAt(i+1);
          if(Character.isLetter(c1) && Character.isLetter(c2)){
              StringBuilder sb = new StringBuilder();
              sb.append(c1).append(c2);
              al1.add(sb.toString());
          }
      }
      for(int i=0; i<str2.length()-1; i++){
          char c1 = str2.charAt(i);
          char c2 = str2.charAt(i+1);
          if(Character.isLetter(c1) && Character.isLetter(c2)){
              StringBuilder sb = new StringBuilder();
              sb.append(c1).append(c2);
              al2.add(sb.toString());
          }
      }
      while(!al1.isEmpty()){
          String s = al1.remove(0);
          union++;
          if(al2.contains(s)){
              int index = al2.indexOf(s);
              al2.remove(index);
              intersection++;
          }
      }
      union += al2.size();
      if(union==0){
          return 65536;
      }
      double d = (double)intersection/ union;
      answer = (int)(d*65536);
      return answer;
  }
}