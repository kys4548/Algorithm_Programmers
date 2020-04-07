import java.util.Arrays;

class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        solve(triangle,triangle.length-1);
        answer = triangle[0][0];
        return answer;
    }
    public void solve(int[][] triangle, int level){
        //BaseCase
        if(level==0)
            return;
        //메모이제이션
        for(int i=0; i<level; i++){
            triangle[level-1][i] = triangle[level-1][i] + Math.max(triangle[level][i],triangle[level][i+1]);
        }
        //전처리
        
        //재귀
        solve(triangle,level-1);
    }
}