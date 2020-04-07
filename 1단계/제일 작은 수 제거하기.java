import java.util.ArrayList;
import java.util.Arrays;
class Solution {
  public int[] solution(int[] arr) {
      if(arr.length == 1){
          arr[0] = -1;
          return arr;
      }
      
      int min = arr[0];
      int idx = 0;
      for(int i=1; i<arr.length; i++){
          if(arr[i] < min){
              min = arr[i];
              idx = i;
          }
      }
      ArrayList<Integer> al = new ArrayList<Integer>();
      
      for(int i=0; i<arr.length; i++){
          al.add(arr[i]);
      }
      al.remove(idx);
      
      for(int i=0; i<al.size(); i++){
          arr[i]=al.get(i);
      }
      int[] arr1 = Arrays.copyOfRange(arr,0,arr.length-1);
      return arr1;
  }
}