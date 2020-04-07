class Solution
{
    public int solution(int [][]board)
    {
        int answer = 0;
        int length1 = board.length;
        int length2 = board[0].length;
        int max=0;
        
        if(length1 <2 || length2 <2){
            for(int a=0; a<length1; a++)
                for(int b=0; b<length2; b++)
                    if(board[a][b]==1)
                        return 1;
        }
        
        for(int i = length1-2; i>=0; i--){
            for(int j= length2-2; j>=0; j--){
                if(board[i][j]==0)
                    continue;
                board[i][j] += Math.min(Math.min(board[i+1][j],board[i][j+1]),board[i+1][j+1]);
                if(board[i][j] >max)
                    max = board[i][j];
            }
        }
        answer = max * max;
        
        return answer;
    }
}