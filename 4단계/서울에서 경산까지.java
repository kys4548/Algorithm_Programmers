class Solution {
    public int solution(int K, int[][] travel) {
        int answer = 0;
        int n = travel.length;
        int sum = 0;
        for(int i=0; i<n; i++) {
            travel[i][0] -= travel[i][2];
            travel[i][1] -= travel[i][3];
            K -= travel[i][2];
            sum += travel[i][3];
        }
        
        //이제 해당 문제는 배낭 문제 (0,1)
        //K : 가방크기, travel[0] : 보석무게, travel[1] : 보석가격
        int[][] dp = new int[n+1][K+1];
        
        for(int i=1; i<=n; i++) {
            for(int j=1; j<=K; j++) {
                if(j < travel[i-1][0]) {
                    dp[i][j] = dp[i-1][j];
                }
                else {
                    dp[i][j] = Math.max(dp[i-1][j - travel[i-1][0]] + travel[i-1][1], dp[i-1][j]);
                    
                }
            }
        }
        //여기까지
        answer = sum + dp[n][K];
        return answer;
    }
}