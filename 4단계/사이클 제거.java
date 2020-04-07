class Solution {
    public int solution(int n, int[][] edges) {
        int answer = 0;
        int[] edgeNum = new int[n+1];
        for(int i=0; i<edges.length; i++) {
            edgeNum[edges[i][0]]++;
            edgeNum[edges[i][1]]++;
        }
        
        for(int i=1; i<=n; i++) {
            if(edges.length - edgeNum[i] >= n-1) {
                continue;
            }
            for(int j=1; j<=n; j++) {
                int temp = edgeNum[i] - edgeNum[j];
            }
        }
        return answer;
    }
}