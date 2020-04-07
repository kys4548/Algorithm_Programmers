import java.util.*;

public class Solution {
	public int[] solution(int []arr) {
        int count = 1;
        
        for(int i=0; i<arr.length - 1; i++){
            if(arr[i] != arr[i+1]){
                arr[count]=arr[i+1];
                count++;
            }
        }
        return Arrays.copyOfRange(arr, 0, count);
	}
}