class Solution {
    public int solution(int[][] board) {
        int answer = 0;
        int N = board.length;
        
        int removeCount = 0;
        do {
            removeCount = 0;
            for(int i=0; i<N-1; i++) {
                for(int j=0; j<N-1; j++) {
                    if(isBlockRemove(i, j, 2, 3, N, board) == true || isBlockRemove(i, j, 3, 2, N, board) == true) {
                        removeCount++;
                    }
                }
            }
            answer += removeCount;
        } while(removeCount != 0);
        return answer;
    }
    
    public boolean isBlockRemove(int row, int col, int h, int w, int N, int[][] board) {
        if(row+h > N || col+w > N) {
            return false;
        }
        int zeroCount = 0;
        int value = -1;
        for(int i=row; i<row+h; i++) {
            for(int j=col; j<col+w; j++) {
                if(board[i][j] == 0) {
                    if(isEmpty(i,j, board) == false) {
                        return false;
                    }
                    zeroCount++;
                    if(zeroCount >2) {
                        return false;
                    }
                }
                else {
                    if(value == -1) {
                        value = board[i][j];
                    }
                    else {
                        if(value != board[i][j]) {
                            return false;
                        }
                    }
                }
            }
        }
        
        for(int i=row; i<row+h; i++) {
            for(int j=col; j<col+w; j++) {
                board[i][j] = 0;
            }
        }
        return true;
    }
    
    public boolean isEmpty(int row, int col, int[][] board) {
        boolean result = true;
        
        for(int i=0; i<row; i++) {
            if( board[i][col] != 0) {
                result = false;
                break;
            }
        }
        
        return result;
    }
}