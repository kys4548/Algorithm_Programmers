class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        int[][] miro = new int[m][n];
        int[][] memo = new int[m][n];
        
        for(int i=0; i<puddles.length; i++){
            int a = puddles[i][0]-1;
            int b = puddles[i][1]-1;
            miro[a][b] = 1;
        }
        memo[0][0] =1;
        answer = solve(m-1,n-1,miro,memo);
        
        return answer;
    }
    public int solve(int a, int b, int[][] miro, int[][] memo){
        //BaseCase
        if(a <0 || b < 0 || miro[a][b] ==1)
            return 0;
        //Memoization
        if(memo[a][b] != 0) //값이 이미 메모되어져 있다면
            return memo[a][b];
        else{
            memo[a][b] = (solve(a-1, b, miro, memo) + solve(a, b-1, miro, memo))%1000000007;
            return memo[a][b];
        }
    }
}