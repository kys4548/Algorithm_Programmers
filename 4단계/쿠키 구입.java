class Solution {
    public int solution(int[] cookie) {
        int answer = 0;
        int n = cookie.length;
        int[][] dp = new int[n][n];
        
        for(int i=0; i<n; i++) {
            dp[i][i] = cookie[i];
        }
        
        for(int i=0; i<n; i++) {
            for(int j=i+1; j<n; j++) {
                dp[i][j] = dp[i][j-1] + cookie[j]; 
            }
        }
        
        for(int i=0; i<n-1; i++) {
            for(int j=0; j<n-1; j++) {
                int first = dp[i][j];
                if(first < answer) {
                    continue;
                }
                int min = j+1;
                int max = n-1;
                
                while(min <= max) {
                    int mid = (min + max) / 2;
                    
                    if(first < dp[j+1][mid]) {
                        max = mid-1;
                    }
                    else if(first > dp[j+1][mid]){
                        min = mid+1;
                    }
                    else {
                        answer = Math.max(answer, first);
                        break;
                    }
                }
            }
        }
        return answer;
    }
}