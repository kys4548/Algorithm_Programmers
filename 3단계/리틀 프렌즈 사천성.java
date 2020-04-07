import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;
import java.util.PriorityQueue;

class Solution {
  public String solution(int m, int n, String[] board) {
      String answer = "IMPOSSIBLE";
      Map<Character, List<int[]>> map = new HashMap<Character, List<int[]>>();
      Set<Character> set = new HashSet<Character>();
      char[][] charBoard = new char[m][n];
      
      for(int i=0; i<m; i++) {
          charBoard[i] = board[i].toCharArray();
          for(int j=0; j<n; j++) {
              if(charBoard[i][j] >= 'A' && charBoard[i][j] <= 'Z') {
                  int[] tempPoint = new int[2];
                  tempPoint[0] = i;
                  tempPoint[1] = j;
                  if(!set.contains(charBoard[i][j])) {
                      List<int[]> tempList = new ArrayList<int[]>();
                      tempList.add(tempPoint);
                      map.put(charBoard[i][j],tempList);
                      set.add(charBoard[i][j]);
                  }
                  else {
                      map.get(charBoard[i][j]).add(tempPoint);
                  }
              }
          }
      }
      
      int characterNum = set.size();
      StringBuilder sb = new StringBuilder();
      PriorityQueue<Character> pq = new PriorityQueue<Character>();
      pq.add('a');
      
      do {
          pq.poll();
          Iterator i = set.iterator();
          Set<Character> tempSet = new HashSet<Character>();
          
          while(i.hasNext()) {
              char c = (char)i.next();
              List tempList = map.get(c);
              if(solve(tempList, charBoard) == true) {
                  tempSet.add(c);
                  pq.add(c);
              }
          }
          if(pq.isEmpty()) {
              break;
          }
          
          char connect = (char)pq.peek();
          sb.append(connect);
          List<int[]> connectList = map.get(connect);
          charBoard[connectList.get(0)[0]][connectList.get(0)[1]] = '.';
          charBoard[connectList.get(1)[0]][connectList.get(1)[1]] = '.';
          
          Iterator ii = tempSet.iterator();
          while(ii.hasNext()) {
              set.remove(ii.next());
          }
      } while(!pq.isEmpty());
      
      if(sb.length() == characterNum) {
          answer = sb.toString();
      }
      return answer;
  }
    
    public boolean solve(List<int[]> list, char[][] charBoard) {
        int startY = list.get(0)[0];
        int startX = list.get(0)[1];
        int endY = list.get(1)[0];
        int endX = list.get(1)[1];
        
        if(startX == endX) {
            if(startY > endY) {
                int temp = startY;
                startY = endY;
                endY = temp;
            }
            return checkYline(startX, startY+1, endY, charBoard);
        }
        else if(startY == endY) {
            if(startX > endX) {
                int temp = startX;
                startX = endX;
                endX = temp;
            }
            return checkXline(startY, startX+1, endX, charBoard);
        }
        else {
            if(startX > endX) {
                if(startY > endY) {
                    if( (checkXline(startY, endX, startX, charBoard) && checkYline(endX, endY+1, startY, charBoard)) || 
                        (checkYline(startX, endY, startY, charBoard) && checkXline(endY, endX+1, startX, charBoard)) ) {
                        return true;
                    }
                }
                else {
                    if( (checkXline(startY, endX, startX, charBoard) && checkYline(endX, startY+1, endY, charBoard)) ||
                        (checkYline(startX, startY+1, endY+1, charBoard) && checkXline(endY, endX+1, startX, charBoard)) ) {
                        return true;
                    }
                }
            }
            else {
                if(startY > endY) {
                    if( (checkXline(endY, startX, endX, charBoard) && checkYline(startX, endY+1, startY, charBoard)) ||
                        (checkYline(endX, endY+1, startY+1, charBoard) && checkXline(startY, startX+1, endX, charBoard)) ) {
                        return true;
                    }
                }
                else {
                    if( (checkXline(endY, startX, endX, charBoard) && checkYline(startX, startY+1, endY, charBoard)) || 
                        (checkYline(endX, startY, endY, charBoard) && checkXline(startY, startX+1, endX, charBoard)) ) {
                        return true;
                    }
                }
            }
        }
        
        return false;
    }
    public boolean checkXline(int fixY, int start, int end, char[][] charBoard) {
        for(int i=start; i<end; i++) {
            if(charBoard[fixY][i] !='.') {
                return false;
            }
        }
        return true;
    }
    
    public boolean checkYline(int fixX, int start, int end, char[][] charBoard) {
        for(int i=start; i<end; i++) {
            if(charBoard[i][fixX] !='.') {
                return false;
            }
        }
        return true;
    }
}