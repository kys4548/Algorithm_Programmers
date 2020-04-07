import java.util.Arrays;
import java.util.Collections;

class Solution {
    public int solution(int[] A, int[] B) {
        int answer = 0;
        Arrays.sort(A);
        Arrays.sort(B);
        int length = A.length;
        int index = length-1;
        
        for(int i=length-1; i>=0; i--) {
            int num = B[i];
            for(int j=index; j>=0; j--) {
                if(num > A[j]) {
                    index = j-1;
                    answer++;
                    break;
                }
            }
        }
        
        return answer;
    }
}