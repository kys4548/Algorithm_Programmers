class Solution {
    public int solution(int sticker[]) {
        int answer = 0;
        int length = sticker.length;
        if(length == 1) {
            return sticker[0];
        }
        if(length == 2) {
            return Math.max(sticker[0], sticker[1]);
        }
        
        int[][] dp = new int[2][length];
        dp[0][0] = sticker[0];
        dp[0][1] = sticker[0];
        dp[1][0] = 0;
        dp[1][1] = sticker[1];
        
        for(int i=2; i<length; i++) {
            dp[0][i] = Math.max(dp[0][i-2] + sticker[i], dp[0][i-1]);
            dp[1][i] = Math.max(dp[1][i-2] + sticker[i], dp[1][i-1]);
            
        }
        
        answer = Math.max(dp[0][length-2], dp[1][length-1]);

        return answer;
    }
}