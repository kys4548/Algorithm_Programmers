class Solution {
    public int solution(int n) {
        int answer = 0;
        
        answer = solve(0, 0, 2*n);
        return answer;
    }
    
    public int solve(int sum, int depth, int n) {
        if(sum < 0) {
            return 0;
        }
        
        if(depth==n) {
            if(sum==0) {
                return 1;
            }
            else {
                return 0;
            }
            
        }
        
        
        return solve(sum+1, depth+1, n) + solve(sum-1, depth+1, n);
    }
}