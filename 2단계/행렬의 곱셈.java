class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int length1 = arr1.length;
        int length2 = arr2[0].length;
        int length3 = arr1[0].length;
        
        int[][] answer = new int [length1][length2];
        
        for(int i=0; i<length1; i++){
            for(int j=0; j<length2; j++){
                for(int k=0; k<length3; k++){
                    answer[i][j] += arr1[i][k] * arr2[k][j];
                }
            }
        }
        return answer;
    }
}