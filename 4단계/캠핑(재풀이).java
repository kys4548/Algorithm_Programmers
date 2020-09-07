import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class Solution {
    public int solution(int n, int[][] data) {
        int answer = 0;

        //좌표압축을 통한 범위 축소 (2^32, 2^32) -> (5000, 5000)
        List<Integer> xList = new ArrayList<>();
        List<Integer> yList = new ArrayList<>();
        for(int i=0; i<n; i++) {
            xList.add(data[i][0]);
            yList.add(data[i][1]);
        }

        List<Integer> sortedXList = xList.stream().distinct().sorted().collect(Collectors.toList());
        List<Integer> sortedYList = yList.stream().distinct().sorted().collect(Collectors.toList());

        for(int i=0; i<n; i++) {
            data[i][0] = sortedXList.indexOf(data[i][0]);
            data[i][1] = sortedYList.indexOf(data[i][1]);
        }

        //압축된 좌표를 board에 입력
        boolean[][] wedgeBoard = new boolean[5000][5000];

        for(int i=0; i<data.length; i++) {
            wedgeBoard[data[i][0]][data[i][1]] = true;
        }


        // (0, 0) 부터 (x, y) 까지 내부 영역에 포함된 쐐기 갯수를 구한다.
        // 2부터 시작한 이유는 0, 1 까지는 내부영역에 쐐기가 포람되지 않는다.
        int[][] containsWedgeCount = new int[5000][5000];
        for(int i=2; i<5000; i++) {
            for(int j=2; j<5000; j++) {
                containsWedgeCount[i][j] = containsWedgeCount[i-1][j] + containsWedgeCount[i][j-1]
                                            - containsWedgeCount[i-1][j-1] + (wedgeBoard[i - 1][j - 1] ? 1 : 0);
            }
        }

        //두 점의 x좌표가 같거나 y좌표가 같으면 텐트를 설치할 수 없다.
        //두 점의 x좌표 차이나 y좌표 차이가 1이라면 무조건 설치가능이므로 answer++;
        // 두 점으로 만드는 영역내에 쐐기가 존재하지 않는다면 answer++;
        for(int i=0; i<n; i++) {
            for(int j=i+1; j<n; j++) {
                if(data[i][0] == data[j][0] || data[i][1] == data[j][1]) {
                    continue;
                }
                int startX = Math.min(data[i][0], data[j][0]);
                int endX = Math.max(data[i][0], data[j][0]);
                int startY = Math.min(data[i][1], data[j][1]);
                int endY = Math.max(data[i][1], data[j][1]);

                if(endX - startX == 1 || endY - startY == 1) {
                    answer++;
                    continue;
                }

                //영역내의 쐐기수를 찾을 때 (startX, startY) 와 (endX, endY)를 이용해 값을 구하면 예외가 발생할 수 있으므로
                // (startX+1, startY+1) 과 (endX, endY) 를 이용하여 찾는다.
                if (containsWedgeCount[endX][endY] - containsWedgeCount[startX+1][endY]
                        - containsWedgeCount[endX][startY+1] + containsWedgeCount[startX+1][startY+1] == 0) {
                    answer++;
                }
            }
        }

        return answer;
    }
}