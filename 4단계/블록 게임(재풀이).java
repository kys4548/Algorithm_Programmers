class Solution {

    public int solution(int[][] board) {
        int answer = 0;
        int n = board.length;
        for(int i=0; i<n-1; i++) {
            for(int j=0; j<n-1; j++) {
                findShape(board, i, j, n);
            }
        }

        int count = 0;
        do {
            count = 0;
            for(int i=0; i<n; i++) {
                for(int j=0; j<n; j++) {
                    if(board[i][j] < 0 && isRemove(board, i, j)) {
                        count++;
                    }
                }
            }
            answer += count;
        } while(count > 0);
        return answer;
    }

    private void printboard(int[][] board, int n) {
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    private boolean isRemove(int[][] board, int a, int b) {
        int shape = board[a][b];

        if(shape == -1) {
            for(int i=0; i<a+2; i++) {
                if(board[i][b-1] != 0) {
                    return false;
                }
            }
            board[a][b] = 0;
            board[a+1][b] = 0;
            board[a+2][b] = 0;
            board[a+2][b-1] = 0;
        } else if(shape == -2) {
            for(int i=0; i<a+2; i++) {
                if(board[i][b+1] != 0) {
                    return false;
                }
            }
            board[a][b] = 0;
            board[a+1][b] = 0;
            board[a+2][b] = 0;
            board[a+2][b+1] = 0;
        } else if(shape == -3) {
            for(int i=0; i<a+1; i++) {
                if (board[i][b + 1] != 0 || board[i][b + 2] != 0) {
                    return false;
                }
            }
            board[a][b] = 0;
            board[a+1][b] = 0;
            board[a+1][b+1] = 0;
            board[a+1][b+2] = 0;
        } else if(shape == -4) {
            for(int i=0; i<a+1; i++) {
                if (board[i][b - 1] != 0 || board[i][b + 1] != 0) {
                    return false;
                }
            }
            board[a][b] = 0;
            board[a+1][b-1] = 0;
            board[a+1][b] = 0;
            board[a+1][b+1] = 0;
        } else if(shape == -5) {
            for(int i=0; i<a+1; i++) {
                if (board[i][b - 2] != 0 || board[i][b - 1] != 0) {
                    return false;
                }
            }
            board[a][b] = 0;
            board[a+1][b-2] = 0;
            board[a+1][b-1] = 0;
            board[a+1][b] = 0;
        }
        return true;
    }

    private void findShape(int[][] board, int a, int b, int n) {
        if(a < n-2) {
            /**
             *  0 1
             *  0 1
             *  1 1
             */
            if(board[a][b+1] != 0 && board[a][b+1] == board[a+1][b+1]
                    && board[a][b+1] == board[a+2][b] && board[a][b+1] == board[a+2][b+1]) {
                board[a][b+1] = -1;
                return;
            }
            /**
             * 1 0
             * 1 0
             * 1 1
             */
            if(board[a][b] != 0 && board[a][b] == board[a+1][b]
                    && board[a][b] == board[a+2][b] && board[a][b] == board[a+2][b+1]) {
                board[a][b] = -2;
                return;
            }
        }
        if(b < n-2) {
            /**
             * 1 0 0
             * 1 1 1
             */
            if (board[a][b] != 0 && board[a][b] == board[a + 1][b]
                    && board[a][b] == board[a + 1][b + 1] && board[a][b] == board[a + 1][b + 2]) {
                board[a][b] = -3;
                return;
            }
            /**
             * 0 1 0
             * 1 1 1
             */
            if(board[a][b+1] != 0 && board[a][b+1] == board[a+1][b]
                    && board[a][b+1] == board[a+1][b+1] && board[a][b+1] == board[a+1][b+2]) {
                board[a][b+1] = -4;
                return;
            }
            /**
             * 0 0 1
             * 1 1 1
             */
            if(board[a][b+2] != 0 && board[a][b+2] == board[a+1][b]
                    && board[a][b+2] == board[a+1][b+1] && board[a][b+2] == board[a+1][b+2]) {
                board[a][b+2] = -5;
                return;
            }
        }
    }
}