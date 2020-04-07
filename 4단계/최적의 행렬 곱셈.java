class Solution {
    public int solution(int[][] matrix_sizes) {
        int answer = 0;
        int length = matrix_sizes.length;
        int[][] dp = new int[length][length];
        
        for(int i=0; i<length-1; i++) {
            dp[i][i+1] = matrix_sizes[i][0] * matrix_sizes[i][1] * matrix_sizes[i+1][1];
        }
        
        for(int i=2; i<length; i++) {
            for(int j=i; j<length; j++) {
                int minimum = 2000000000;
                for(int k=j-i; k<j; k++) {
                    minimum = Math.min(minimum,  dp[j-i][k] + dp[k+1][j] + matrix_sizes[j-i][0] * matrix_sizes[k][1] * matrix_sizes[j][1] );
                }
                dp[j-i][j] = minimum;
            }
        }
        //print(length, dp);
        answer = dp[0][length-1];
        return answer;
    }
      
      public void print(int length, int[][] dp) {
          for(int i=0; i<length; i++) {
              for(int j=0; j<length; j++) {
                  System.out.printf("%5d ", dp[i][j]);
              }
              System.out.println();
          }
      }
  }