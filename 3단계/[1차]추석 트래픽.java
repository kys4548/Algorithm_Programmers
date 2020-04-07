import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class Solution {
  public int solution(String[] lines) {
      double[] start = new double[lines.length];
      double[] end = new double[lines.length];
      int answer = 0;
      
      for(int i=0; i<lines.length; i++){
          String[] s1 = lines[i].split(" ");
          String[] s2 = s1[1].split(":");
          int h = Integer.parseInt(s2[0]);
          int m = Integer.parseInt(s2[1]);
          double s = Double.parseDouble(s2[2]);
          s1[2] = s1[2].substring(0,s1[2].length()-1);
          double time = Double.parseDouble(s1[2]);
          end[i] = 3600*h + 60*m + s;
          start[i] = end[i] - time;
      }
      
      for(int i=0; i<lines.length; i++){
          double t = end[i]+0.999;
          int temp = 0;
          for(int j=i+1; j<lines.length; j++){
              if(t > start[j])
                  temp++;
          }
          if(answer < temp)
              answer = temp;
      }
      return answer+1;
  }
}