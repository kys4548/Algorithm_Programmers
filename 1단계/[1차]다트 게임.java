class Solution {
  public int solution(String dartResult) {
      dartResult = dartResult.replace("10","A");
      int[] arr = new int[3];
      int num=0;
      int index = -1;
      for(int i=0; i<dartResult.length(); i++){
          char c = dartResult.charAt(i);
          if(c >='0' && c<= '9'){
              index++;
              num = c -'0';
          }else if(c == 'A'){
              index++;
              num = 10;
          }else if(c == 'S'){
              arr[index] = num;
          }else if(c== 'D'){
              arr[index] = (int)Math.pow(num,2);
          }else if(c == 'T'){
              arr[index] = (int)Math.pow(num,3);
          }else if(c == '*'){
              if(index >0)
                  arr[index-1] *=2;
              arr[index] *=2;
          }else{
              arr[index] *= -1;
          }
      }
      int answer = 0;
      for(int i=0; i<3; i++){
          answer += arr[i];
      }
      return answer;
  }
}