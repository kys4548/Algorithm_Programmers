import java.util.Arrays;


class Main {

    public static void main(String[] args) {

        Solution solution = new Solution();
        int length = solution.getLength();
        solution.solve(solution.dp, length-1, length-1 , length, Direct.ANY, 0);
    }
}

class Solution {

    // int[][] board = {
    //     {0, 0, 0, 0, 0, 0, 0, 1},
    //     {0, 0, 0, 0, 0, 0, 0, 0},
    //     {0, 0, 0, 0, 0, 1, 0, 0},
    //     {0, 0, 0, 0, 1, 0, 0, 0},
    //     {0, 0, 0, 1, 0, 0, 0, 1},
    //     {0, 0, 1, 0, 0, 0, 1, 0},
    //     {0, 1, 0, 0, 0, 1, 0, 0},
    //     {1, 0, 0, 0, 0, 0, 0, 0}
    // };

    int[][] board = {
        {0, 0, 0, 0, 0, 0},
        {0, 1, 1, 1, 1, 0},
        {0, 0, 1, 0, 0, 0},
        {1, 0, 0, 1, 0, 1},
        {0, 1, 0, 0, 0, 1},
        {0, 0, 0, 0, 0, 0} 
    };

    int length;
    int[][] dp;

    public Solution() {
        length = board.length;
        dp = new int[length][length];
        
        for(int i=0; i<length; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
    }

    public int[][] getDp() {
        return dp;
    }

    public int getLength() {
        return length;
    }

    public void printDp() {
        for(int i=0; i<length; i++) {
            for(int j=0; j<length; j++) {
                System.out.printf("%10d ", dp[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }


    public void solve(int[][] dp, int row, int col, int length, Direct direct, int cost) {
        if(row < 0 || row >= length || col < 0 || col >= length || board[row][col] == 1) {
            return;
        }
        //dp[row][col] == Integer.MAX_VALUE ||
        if( dp[row][col] > cost) {
            dp[row][col] = cost;
        } else {
            return;
        }

        printDp();
        int upDownCost = 100;
        int leftRightCost = 100;
        
        if(direct == Direct.UPDOWN) {
            leftRightCost += 500;
        } else if(direct == Direct.LEFTRIGHT) {
            upDownCost += 500;
        }

        solve(dp, row - 1, col, length, Direct.UPDOWN, dp[row][col] + upDownCost);
        solve(dp, row, col - 1, length, Direct.LEFTRIGHT, dp[row][col] + leftRightCost);
        solve(dp, row, col + 1, length, Direct.LEFTRIGHT, dp[row][col] + leftRightCost);
        solve(dp, row + 1, col, length, Direct.UPDOWN, dp[row][col] + upDownCost);
    }
}

enum Direct {
    ANY, LEFTRIGHT, UPDOWN
}