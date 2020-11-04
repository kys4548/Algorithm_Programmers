class Solution {
    public int[] solution(int[][] arr) {
        int[] answer = new int[2];
        int n = arr.length;
        dfs(arr, answer, 0,0, n);
        return answer;
    }

    private void dfs(int[][] arr, int[] answer, int a, int b, int n) {
        //base case
        if(n == 1) {
            answer[arr[a][b]]++;
            return;
        }

        //전처리
        boolean isZip = true;
        int value = arr[a][b];

        for(int i=a; i<a+n; i++) {
            for(int j=b; j<b+n; j++) {
                if(value != arr[i][j]) {
                    isZip = false;
                    break;
                }
            }
            if(!isZip) {
                break;
            }
        }

        if(isZip) {
            answer[value]++;
            return;
        }


        //재귀
        dfs(arr, answer, a, b, n/2);
        dfs(arr, answer, a + n/2, b, n/2);
        dfs(arr ,answer, a, b + n/2, n/2);
        dfs(arr, answer, a + n/2, b + n/2, n/2);
    }

}