import java.util.Arrays;

class Solution {
    int solution(int[][] land) {
        int answer = 0;
        int length = land.length;
        int[][] dp = new int[length][4];
            
        for(int a=0; a<4; a++)
            dp[0][a] = land[0][a];
        
        for(int i=1; i<length; i++){
            for(int j=0; j<4; j++){
                dp[i][j] = land[i][j];
                if(j==0)
                    dp[i][j] += Math.max(Math.max(dp[i-1][j+1],dp[i-1][j+2]),dp[i-1][j+3]);
                else if(j==1)
                    dp[i][j] += Math.max(Math.max(dp[i-1][j-1],dp[i-1][j+1]),dp[i-1][j+2]);
                else if(j==2)
                    dp[i][j] += Math.max(Math.max(dp[i-1][j-2],dp[i-1][j-1]),dp[i-1][j+1]);
                else
                    dp[i][j] += Math.max(Math.max(dp[i-1][j-3],dp[i-1][j-2]),dp[i-1][j-1]);
            }
        }
        
        Arrays.sort(dp[length-1]);
        answer = dp[length-1][3];


        return answer;
    }
}