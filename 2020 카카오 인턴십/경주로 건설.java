import java.util.*;

class Solution {

    static int result = Integer.MAX_VALUE;

    public int solution(int[][] board) {
        int answer = 0;
        int n = board.length;
        int[][][] costs = new int[2][n][n];

        for(int i=0; i<n; i++) {
            Arrays.fill(costs[0][i], Integer.MAX_VALUE);
            Arrays.fill(costs[1][i], Integer.MAX_VALUE);
        }

        solve(board, costs, 0 ,0, 1, n, 100);
        solve(board, costs, 1,1, 0, n , 100);
        
        answer = result;

        return answer;
    }

    public void solve(int[][] board, int[][][] costs, int status, int a, int b, int n, int cost) {
        //base case
        if(a < 0 || a >= n || b < 0 || b >= n || board[a][b] == 1 || costs[status][a][b] < cost) {
            return;
        }
        if(a == n-1 && b == n-1) {
            if(result > cost) {
                result = cost;
            }
            return;
        }

        costs[status][a][b] = cost;

        if(status == 0) {
            solve(board, costs, status, a, b-1, n, cost + 100);
            solve(board, costs, status, a, b+1, n, cost + 100);
            solve(board, costs, status+1, a-1, b, n, cost + 600);
            solve(board, costs, status+1, a+1, b, n, cost + 600);
        } else {
            solve(board, costs, status, a+1, b, n, cost + 100);
            solve(board, costs, status, a-1, b, n, cost + 100);
            solve(board, costs, status-1, a, b+1, n, cost + 600);
            solve(board, costs, status-1, a, b-1, n, cost + 600);
        }
    }
}