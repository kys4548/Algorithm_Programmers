public class Solution {
	public long solution(int[][] land, int P, int Q) {
		long answer = 0;
        int n = land.length;
        
        int max = 1000000000;
        int min = 0;
        while(min < max) {
            int mid = (min + max) / 2;
            
            if(solve(mid, n, land, P, Q) > solve(mid+1, n, land, P, Q)) {
                min = mid +1;
            }
            else {
                max = mid;
            }
        }
        answer = solve(max, n, land, P, Q);
		return answer;
	}
    
    public long solve(int height, int n, int[][] land, int P, int Q) {
        long up = 0;
        long down = 0;
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(land[i][j] > height) {
                    up += land[i][j] -height;
                }
                else {
                    down += height -land[i][j];
                }
            }
        }
        return up * Q + down * P;
    }
}