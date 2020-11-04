import java.util.*;

class Main {
    public static void main(String[] args) {
        final Solution solution = new Solution();
        solution.solution(1);
    }
}


class Solution {
    public int[] solution(int n) {
        int[] answer = {};
        int[][] map = new int[n][n];

        int value = 1;
        int row = 0;
        int col = 0;

        while(row < n && map[row][col] == 0) {

            while(row < n && map[row][col] == 0) {
                map[row][col] = value;
                value++;
                row++;
            }
            row--;
            col++;

            while(col < n && map[row][col] == 0) {
                map[row][col] = value;
                value++;
                col++;
            }
            row--;
            col -=2;
            while(row > 0 && map[row][col] == 0) {
                map[row][col] = value;
                value++;
                row--;
                col--;
            }
            row += 2;
            col++;
        }


        List<Integer> list = new ArrayList<>();

        for(int i=0; i<n; i++) {
            for(int j=0; j<=i; j++) {
                list.add(map[i][j]);
            }
        }

        answer = new int[list.size()];
        for(int i=0; i<list.size(); i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }
}