import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class Solution {
  public String[] solution(String[] files) {
      String[] answer = new String[files.length];
      ArrayList<String> al = new ArrayList<String>();
      for(String s : files)
          al.add(s);
      Collections.sort(al,new Comparator<String>(){
         @Override
          public int compare(String s1, String s2){
              int endH1 = endHead(s1);
              int endH2 = endHead(s2);
              String subS1 = s1.substring(0,endH1).toUpperCase();
              String subS2 = s2.substring(0,endH2).toUpperCase();
              if(subS1.equals(subS2)){
                  int endN1 = endNumber(s1,endH1);
                  int endN2 = endNumber(s2,endH2);
                  String subS3 = s1.substring(endH1,endN1);
                  String subS4 = s2.substring(endH2,endN2);
                  int n1 = Integer.parseInt(subS3);
                  int n2 = Integer.parseInt(subS4);
                  return n1 - n2;
              }
              else
                return subS1.compareTo(subS2);
          }
      });
      for(int i=0; i<answer.length; i++){
          answer[i] = al.remove(0);
      }
      return answer;
  }
    public int endHead(String s){
        int temp = 0;
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if( '0' <= c && c <= '9'){
                temp = i;
                break;
            }
        }
        return temp;
    }
    public int endNumber(String s, int n){
        for(int i=n; i<s.length(); i++){
            char c = s.charAt(i);
            if( '0' > c || c > '9')
                return i;
        }
        return s.length();
    }
}