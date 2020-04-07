class Solution {
    public int[] solution(int[] heights) {
        int[] answer = new int[heights.length];

        for(int i=heights.length-1; i>=0; i--){
            int n = heights[i];
            int idx = 0;
            for(int j=i-1; j>=0; j--){
                if(n<heights[j]){
                    idx = j+1;
                    break;
                }
            }
            answer[i]=idx;
        }
        return answer;
    }
}