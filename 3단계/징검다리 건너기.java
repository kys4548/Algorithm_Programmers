class Solution {
    public int solution(int[] stones, int k) {
        int answer = 0;
        int[] dp = new int[stones.length];
        int index = 0;
        int max = stones[k-1];
        dp[k-1] = stones[k-1];
        for(int i=k-2; i>=0; i--) {
            if(max < stones[i]) {
                dp[i] = stones[i] - max;
                max = stones[i];
            }
        }
        for(int i=0; i<k; i++) {
            if(dp[i] != 0) {
                break;
            }
            index++;
        }
        
        for(int i=k; i<stones.length; i++) {
            if(index < i-k) {
                index = i-k;
            }
            for(int j=i-1; j>=index; j--) {
                if(stones[i] <= dp[j]) {
                    dp[i] += stones[i];
                    dp[j] -= stones[i];
                    break;
                } else {
                    stones[i] -= dp[j];
                    dp[i] += dp[j];
                    dp[j] = 0;
                }
            }
            for(int j=index; j<dp.length; j++) {
                if(dp[j] != 0){
                    break;
                }
                index++;
            }
        }
        
        for(int i=stones.length-k; i<stones.length; i++) {
            answer += dp[i];
        }
        
        return answer;
    }
}