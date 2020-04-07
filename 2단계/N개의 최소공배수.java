import java.util.ArrayList;

class Solution {
  public int solution(int[] arr) {
      int[] sosu = {2,3,5,7,11,13,17,19,23,29,31,37,41,43,47,53,59,61,67,71,73,79,83,89,97};
      int answer = 1;
      int count;
      
      ArrayList<Integer> al = new ArrayList<Integer>();
      
      for(int num :arr)
          if(num !=0)
            al.add(num);
      
      for(int i=0; i<sosu.length; i++){
          count =0;
          for(int j=0; j<al.size(); j++){
              int n = al.remove(j);
              
              if(n==1){
                  j--;
                  continue;
              }
              else if((n % sosu[i]) ==0){
                  al.add(j,n/sosu[i]);
                  count++;
              }else{
                  al.add(j,n);
              }
          }
          if(count >=1){
                  answer *= sosu[i];
                  i--;
          }
      }
      return answer;
  }
}