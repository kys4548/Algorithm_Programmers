import java.util.Arrays;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        
        int length = commands.length; //반복횟수
        int[] answer = new int[length];
        
        for(int i=0; i<length; i++){
            int first = commands[i][0] -1;
            int length2  = commands[i][1] - first;
            //새로 생긴 배열의 길이
            int idx = commands[i][2];
            int[] arr = new int[length2];
            
            for(int j=0; j<length2; j++){
                arr[j] = array[first++];
            }
            Arrays.sort(arr);
            answer[i] = arr[idx -1];
            
        }
        return answer;
    }
}