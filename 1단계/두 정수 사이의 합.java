import java.util.Arrays;

class Solution {
  public int[] solution(int[] arr, int divisor) {
      int count = 0;
      for(int i=0; i<arr.length; i++){
          if(arr[i] % divisor == 0){
              arr[count++] = arr[i]; 
          }
      }
      if(count == 0){
          int[] temp = {-1};
          return temp;
      }
      else{
          int[] temp = Arrays.copyOfRange(arr, 0, count);
          Arrays.sort(temp);
          return temp;
      } 
  }
}