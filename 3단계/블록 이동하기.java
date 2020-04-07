import java.util.Arrays;

class Solution {
    public int solution(int[][] board) {
        int answer = 0;
        int n = board.length;
        int length= n+2;
        int[][] maps = createMaps(length, board);
        int[][][] minPath = createMinPath(length);
        
        moveRobot(1, 1, 1, 2, maps, minPath, n, 0, 0);
        
        answer = Math.min(minPath[0][n][n-1], minPath[1][n-1][n]);
        
        return answer;
    }
    
    public void moveRobot(int a1, int b1, int a2, int b2, int[][] maps, int[][][] minPath, int n, int shape, int depth) {
        if(maps[a1][b1] == 1 || maps[a2][b2] == 1 || minPath[shape][a1][b1] <= depth) {
            return;
        }
        minPath[shape][a1][b1] = depth;
        
        moveRobot(a1, b1+1, a2, b2+1, maps, minPath, n, shape, depth+1);
        moveRobot(a1+1, b1, a2+1, b2, maps, minPath, n, shape, depth+1);
        moveRobot(a1-1, b1, a2-1, b2, maps, minPath, n, shape, depth+1);
        moveRobot(a1, b1-1, a2, b2-1, maps, minPath, n, shape, depth+1);
        
        if(shape == 0) {
            if(maps[a1+1][b1] == 0) {
                moveRobot(a2, b2, a1+1, b1+1, maps, minPath, n, shape+1, depth+1);
            }
            if(maps[a1+1][b1+1] == 0) {
                moveRobot(a1, b1, a2+1, b2-1, maps, minPath, n, shape+1, depth+1);
            }
            if(maps[a1-1][b1] == 0) {
                moveRobot(a1-1, b1+1, a2, b2, maps, minPath, n, shape+1, depth+1);
            }
            if(maps[a1-1][b1+1] == 0) {
                moveRobot(a2-1, b2-1, a1, b1, maps, minPath, n, shape+1, depth+1);
            }
        }
        else {
            if(maps[a1][b1+1] == 0) {
                moveRobot(a2, b2, a1+1, b1+1, maps, minPath, n, shape-1, depth+1);
            }
            if(maps[a1+1][b1+1] == 0) {
                moveRobot(a1, b1, a2-1, b2+1, maps, minPath, n, shape-1, depth+1);
            }
            if(maps[a1][b1-1] == 0) {
                moveRobot(a1+1, b1-1, a2, b2, maps, minPath, n, shape-1, depth+1);
            }
            if(maps[a1+1][b1-1] == 0) {
                moveRobot(a2-1, b2-1, a1, b1, maps, minPath, n, shape-1, depth+1);
            }
        }
    }
    
    public int[][][] createMinPath(int length) {
        int[][][] minPath = new int[2][length-1][length-1];
        for(int i=0; i<2; i++) {
            for(int j=0; j<length-1; j++) {
                Arrays.fill(minPath[i][j], 999999);
            }
        }
        return minPath;
    }
    
    public int[][] createMaps(int length, int[][] board) {
        int[][] maps = new int[length][length];
        
        Arrays.fill(maps[0], 1);
        for(int i=1; i<length-1; i++) {
            maps[i][0] = 1;
            maps[i][length-1] = 1;
        }
        Arrays.fill(maps[length-1], 1);
        
        for(int i=1; i<length-1; i++) {
            for(int j=1; j<length-1; j++) {
                maps[i][j] = board[i-1][j-1];
            }
        }
        
        return maps;
    }
}