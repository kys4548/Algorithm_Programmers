import java.util.LinkedList;
import java.util.List;

class Solution {
  public int[][] solution(int n) {
      List<int[]> list = new LinkedList<int[]>();
      solve(1, 2, 3, n, list);
      int length = list.size();
      int[][] answer = new int[length][2];
      
      for(int i=0; i<length; i++) {
          int[] temp = list.get(i);
          answer[i][0] = temp[0];
          answer[i][1] = temp[1];
      }
      
      
      return answer;
  }
    public void solve(int start, int temp, int target, int n, List<int[]> list) {
        
        if(n==1) {
            int[] arr = {start, target};
            list.add(arr);
            return;
        }
        
        solve(start, target, temp, n-1, list);
        int[] arr = {start, target};
        list.add(arr);
        solve(temp, start, target, n-1, list);
    }
}