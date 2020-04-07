// 문제가 개편 되었습니다. 이로 인해 함수 구성이 변경되어, 과거의 코드는 동작하지 않을 수 있습니다.
// 새로운 함수 구성을 적용하려면 [코드 초기화] 버튼을 누르세요. 단, [코드 초기화] 버튼을 누르면 작성 중인 코드는 사라집니다.
class Solution {
    public int solution(int[] left, int[] right) {
        int answer = 0;
        int n = left.length;
        int[][] dp = new int[n+1][n+1];
        
        for(int i=0; i<n; i++) {
            if(left[0] > right[i] ) {
                dp[0][i+1] = dp[0][i] + right[i];  
            }
        }
        
        for(int i=1; i<=n; i++) {
            for(int j=1; j<=n; j++) {
                dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j]);
                if(left[i-1] > right[j-1]) {
                    dp[i][j] = Math.max(dp[i][j], dp[i][j-1] + right[j-1]);
                }
            }
        }
        
        answer = dp[n][n];
        
        return answer;
    }
}