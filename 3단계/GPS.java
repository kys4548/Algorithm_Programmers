import java.util.Arrays;

class Solution {
  public int solution(int n, int m, int[][] edge_list, int k, int[] gps_log) {
      int INF = 9999999;
      int answer = 0;
      boolean[][] connect = connectVertex(n, m, edge_list);
      int[][] dp = createDP(k, n, gps_log[0]-1,INF);
      
      // i시간에서의 위치
      for(int i=1; i<k; i++) {
          int vertex = gps_log[i]-1;
          
          // i-1 시간까지 가능한 경우 찾기
          for(int j=0; j<n; j++) {
              if(dp[i-1][j] < INF) {
                  
                  // 그 경우들에서 최소값 
                  for(int l=0; l<n; l++) {
                      if(connect[j][l] == true) {
                          int add = (l == vertex) ? 0 : 1;
                          
                          dp[i][l] = Math.min(dp[i][l], dp[i-1][j] + add);
                      }
                  }
              }
          }
      }
      // for(int i=0; i<k; i++) {
      //     for(int j=0; j<n; j++) {
      //         System.out.print(dp[i][j]+ " ");
      //     }
      //     System.out.println();
      // }
      
      answer = dp[k-1][gps_log[k-1]-1];
      if(answer == INF) {
          answer = -1;
      }
      
      return answer;
  }
    public int[][] createDP(int k, int n, int firstVertex, int INF) {
        int[][] dp = new int[k][n];
        
        for(int i=0; i<k; i++) {
            Arrays.fill(dp[i],INF);
        }
        dp[0][firstVertex] = 0;
        
        return dp;
        
    }
    public boolean[][] connectVertex(int n, int m, int[][] edge_list) {
        boolean[][] connect = new boolean[n][n];
        
        for(int i=0; i<n; i++) {
            connect[i][i] = true;
        }
        
        for(int i=0; i<m; i++) {
            int v1 = edge_list[i][0] -1;
            int v2 = edge_list[i][1] -1;
            
            connect[v1][v2] = true;
            connect[v2][v1] = true;
        }
        
        return connect;
    }
}