import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Collections;

class Solution {
  public int solution(int n, int[][] data) {
      int answer = 0;
      
      ArrayList<Integer> xList = new ArrayList<Integer>();
      ArrayList<Integer> yList = new ArrayList<Integer>();
      for(int i=0; i<n; i++) {
          xList.add(data[i][0]);
          yList.add(data[i][1]);
      }
      
      ArrayList<Integer> uniqueXList = new ArrayList<Integer>(new HashSet<Integer>(xList));
      ArrayList<Integer> uniqueYList = new ArrayList<Integer>(new HashSet<Integer>(yList));
      
      Collections.sort(uniqueXList);
      Collections.sort(uniqueYList);
      
      for(int i=0; i<n; i++) {
          int x = uniqueXList.indexOf(data[i][0]);
          int y = uniqueYList.indexOf(data[i][1]);
          
          data[i][0] = x;
          data[i][1] = y;
      }
      
      boolean[][] isWedge = new boolean[5000][5000];
      for(int i=0; i<n; i++) {
          isWedge[data[i][0]][data[i][1]] = true;
      }
      int[][] maps = new int[5001][5001];
      
      for(int i=2; i<5000; i++) {
          for(int j=2; j<5000; j++) {
              maps[i][j] = maps[i-1][j] + maps[i][j-1] - maps[i-1][j-1] + (isWedge[i-1][j-1] == true ? 1: 0 );
          }
      }
      
      // for(int i=0; i<10; i++) {
      //     for(int j=0; j<10; j++) {
      //         System.out.printf("%4d ",maps[i][j]);
      //     }
      //     System.out.println();
      // }
      
      for(int i=0; i<n; i++) {
          for(int j=i+1; j<n; j++) {
              if(data[i][0] != data[j][0] && data[i][1] != data[j][1]) {
                  int startY = Math.min(data[i][0], data[j][0]);
                  int endY = Math.max(data[i][0], data[j][0]);
                  int startX = Math.min(data[i][1], data[j][1]);
                  int endX = Math.max(data[i][1], data[j][1]);
                  if(maps[endY][endX] - maps[endY][startX+1] - maps[startY+1][endX] + maps[startY+1][startX+1] == 0){
                      answer++;
                  }
              }
          }
      }
      
      return answer;
  }
}