import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

class Solution {
    
  public int[] solution(int m, int n, int s, int[][] time_map) {
      int[] answer = new int[2];
      long[][] dp = createDP(m, n);
      answer[0] = talkTime(m, n, s, time_map, dp, 0);
      answer[1] = (int)dp[m-1][n-1];
      
      return answer;
  }
    
    public void printDP(int m, int n, long[][] dp) {
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                System.out.printf("%4d ", dp[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }
    
    public int talkTime(int m, int n, int s, int[][] time_map, long[][] dp, int depth) {
        // System.out.println(depth);
        // printDP(m, n, dp);
        
        
        // Base Case
        if(dp[m-1][n-1] != -1 && dp[m-1][n-1] <=s) {
            return depth;
        }
        
        
        //pretreatment and memoization
        List<long[]> list = new ArrayList<long[]>();
        
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(dp[i][j] != -1 && dp[i][j] <=s) {
                    long[] arr = new long[3];
                    arr[0] = i;
                    arr[1] = j;
                    arr[2] = dp[i][j];
                    list.add(arr);
                }   
            }
        }
        int length = list.size();
        
        for(int k=0; k<length; k++) {
            long[] arr = list.get(k);
            int i = (int)arr[0];
            int j = (int)arr[1];
            long time = arr[2];

                    
                    //위쪽 길이 존재하고 테이블이 아닐 때
                    if(i-1>=0 && time_map[i-1][j] != -1 && time + time_map[i-1][j] <=s) {
                        if(dp[i-1][j] == -1) {
                            dp[i-1][j] = time + time_map[i-1][j];
                        }
                        else {
                            dp[i-1][j] = Math.min(dp[i-1][j], time + time_map[i-1][j]);
                        }
                    }
                    
                    //오른쪽 길이 존재하고 테이블이 아닐 때
                    if(j+1<n && time_map[i][j+1] != -1 && time + time_map[i][j+1] <=s) {
                        if(dp[i][j+1] == -1) {
                            dp[i][j+1] = time + time_map[i][j+1];
                        }
                        else {
                            dp[i][j+1] = Math.min(dp[i][j+1], time + time_map[i][j+1]);
                        }
                    }
                    
                    //아래쪽 길이 존재하고 테이블이 아닐 때
                    if(i+1<m && time_map[i+1][j] != -1 && time + time_map[i+1][j] <=s) {
                        if(dp[i+1][j] == -1) {
                            dp[i+1][j] = time + time_map[i+1][j];
                        }
                        else {
                            dp[i+1][j] = Math.min(dp[i+1][j], time + time_map[i+1][j]);
                        }
                    }
                    
                    //왼쪽 길이 존재하고 테이블이 아닐 때
                    if(j-1>=0 && time_map[i][j-1] != -1 && time + time_map[i][j-1] <=s) {
                        if(dp[i][j-1] == -1) {
                            dp[i][j-1] = time + time_map[i][j-1];
                        }
                        else {
                            dp[i][j-1] = Math.min(dp[i][j-1], time + time_map[i][j-1]);
                        }
                    }
        }
        
        
        
        //recursion
        return talkTime(m, n, s, time_map, dp, depth+1);
    }
    
    public long[][] createDP(int m, int n) {
        long[][] dp = new long[m][n];
        
        for(int i=0; i<m; i++) {
            Arrays.fill(dp[i], -1);
        }
        dp[0][0] = 0;
        
        return dp;
    }
}


//     public void pathCost(int m, int n, int[][] dp, int[][] dp2) {
//         //Base Case
//         if(dp2[0][0] != -1) {
//             return;
//         }
        
//         //pretreatment and memoization
//         List<int[]> list = new ArrayList<int[]>();
        
//         for(int i=0; i<m; i++) {
//             for(int j=0; j<n; j++) {
//                 if(dp2[i][j] != -1) {
//                     int[] arr = new int[2];
//                     arr[0] = i;
//                     arr[1] = j;
//                     list.add(arr);
//                 }   
//             }
//         }
//         int length = list.size();
        
//         for(int k=0; k<length; k++) {
//             int[] arr = list.get(k);
//             int i = arr[0];
//             int j = arr[1];
            
//             //위
//             if(i-1>=0 && dp2[i-1][j] == -1 && dp[i-1][j] !=-1 && dp[i-1][j] <= dp[i][j]) {
//                 dp2[i-1][j] = dp2[i][j] + 1;
//             }
//             //오른쪽
//             if(j+1<n && dp2[i][j+1] == -1 && dp[i][j+1] !=-1 && dp[i][j+1] <= dp[i][j]) {
//                 dp2[i][j+1] = dp2[i][j] + 1;
//             }
//             //아래
//             if(i+1<m && dp2[i+1][j] == -1 && dp[i+1][j] !=-1 && dp[i+1][j] <= dp[i][j]) {
//                 dp2[i+1][j] = dp2[i][j] + 1;
//             }
//             //왼쪽
//             if(j-1>=0 && dp2[i][j-1] == -1 && dp[i][j-1] !=-1 && dp[i][j-1] <= dp[i][j]) {
//                 dp2[i][j-1] = dp2[i][j] + 1;
//             }
//         }
        
//         //Recursion
//         pathCost(m, n, dp, dp2);
//     }