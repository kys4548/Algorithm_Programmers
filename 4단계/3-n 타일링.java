class Solution {
    public int solution(int n) {
        int answer = 0;
        n /= 2;
        long[] dp = new long[n];
        dp[0] = 3;
        dp[1] = 11;
        
        for(int i=2; i<n; i++) {
            if(dp[i-1] < dp[i-2]) {
                dp[i-1] += 1000000007;
            }
            dp[i] = (4 * dp[i-1] - dp[i-2] ) %1000000007;
            if(dp[i-1] >=1000000007){
                dp[i-1] -= 1000000007;
            }
        }
        
        answer = (int)dp[n-1];
        
        return answer;
    }
  }