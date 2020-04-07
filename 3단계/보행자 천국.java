class Solution {
    int MOD = 20170805;
    public int solution(int m, int n, int[][] cityMap) {
        int answer = 0;
        int[][] leftMemo = new int[m][n];
        int[][] topMemo = new int[m][n];
        int div = 20170805;
        
        for(int i=1; i<n; i++) {
            if(cityMap[0][i] != 1) {
                leftMemo[0][i] = 1;
            }
            else {
                break;
            }
                
        }
        
        for(int i=1; i<m; i++) {
            if(cityMap[i][0] != 1) {
                topMemo[i][0] = 1;
            }
            else {
                break;
            }
        }
        
        for(int i=1; i<m; i++) {
            for(int j=1; j<n; j++) {
                
                //위에서 오는 것
                switch(cityMap[i-1][j]) {
                    case 0:
                        topMemo[i][j] = (topMemo[i-1][j] + leftMemo[i-1][j]);
                        break;
                    case 1:
                        break;
                    case 2:
                        topMemo[i][j] = topMemo[i-1][j];
                }
                //왼쪽에서 오는 것
                switch(cityMap[i][j-1]) {
                    case 0:
                        leftMemo[i][j] = topMemo[i][j-1] + leftMemo[i][j-1];
                        break;
                    case 1:
                        break;
                    case 2:
                        leftMemo[i][j] = leftMemo[i][j-1];
                }
                if(topMemo[i][j] > div) {
                    topMemo[i][j] %= div;
                }
                if(leftMemo[i][j] > div) {
                    leftMemo[i][j] %= div;
                }
            }
        }
        answer = (topMemo[m-1][n-1] + leftMemo[m-1][n-1]) % div; 
        return answer;
    }
  }