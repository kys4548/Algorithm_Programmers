class Solution {
    public int solution(int[] money) {
        int answer = 0;
        int length = money.length;
        if(length == 3) {
            return Math.max(Math.max(money[0], money[1]), money[2]);
        }
        int[][] section = new int[3][2];
        section[0][0] = 1;
        section[0][1] = length-3;
        section[1][0] = 2;
        section[1][1] = length-2;
        section[2][0] = 3;
        section[2][1] = length-1;
        int[] value = new int[3];
        value[0] = money[length-1];
        value[1] = money[0];
        value[2] = money[1];

        for(int i=0; i<3; i++) {
            answer = Math.max(answer, solve(section[i][0], section[i][1], length, money) + value[i]);
        }
        return answer;
    }
    public int solve(int start, int end, int length, int[] money) {
        if(end - start == 0) {
            return money[start];
        }
        if(end - start == 1) {
            return Math.max(money[start], money[end]);
        }
        if(end - start == 2) {
            return Math.max(Math.max(money[start], money[start+1]), money[end]);
        }
        int[] dp = new int[length];
        dp[start] = money[start];
        dp[start+1] = Math.max(money[start], money[start+1]);

        for(int i=start+2; i<= end; i++) {
            dp[i] = Math.max(dp[i-2] + money[i], dp[i-1]);
        }
        return dp[end];
    }
}