import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

class Solution {
  public String solution(int n, int t, int m, String[] timetable) {
      String answer = "";
      Arrays.sort(timetable);
      List<String> list = new ArrayList<String>();
      int hour = 9;
      int min = 0;
      int index = 0;
      
      
      for(int i=0; i<n; i++) {
          StringBuilder sb = new StringBuilder();
          if(min >=60) {
              min -= 60;
              hour++;
          }
          if(hour <10) {
              sb.append("0");
          }
          sb.append(hour).append(":");
          
          if(min <10) {
              sb.append("0");
          }
          sb.append(min);
          String depart = sb.toString();
          
          for(int j= index; j< timetable.length; j++) {
              if(depart.compareTo(timetable[j]) >= 0) {
                  list.add(timetable[j]);
                  index++;
              }
              else {
                  break;
              }
          }
          if(i < n-1) {
              for(int j=0; j<m; j++) {
                  if(list.isEmpty()) {
                      break;
                  }
                  list.remove(0);
              }
          }
          else {
              if(list.size() <m) {
                  answer = depart;
              }
              else {
                  sb.setLength(0);
                  String[] arr = list.get(m-1).split(":");
                  hour = Integer.parseInt(arr[0]);
                  min = Integer.parseInt(arr[1]) -1;
                  
                  if(min <0) {
                      min += 60;
                      hour--;
                  }
                  
                  if(hour <10) {
                      sb.append("0");
                  }
                  sb.append(hour).append(":");
                  
                  if(min < 10) {
                      sb.append("0");
                  }
                  sb.append(min);
                  answer = sb.toString();
              }
          }
          
          min +=t;
          
      }
      return answer;
  }
}