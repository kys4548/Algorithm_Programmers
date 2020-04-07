class Solution {
    public String solution(int n) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        
        while(n >= 3){
            int num = n %3;
            n /= 3;
            if(num == 0){
                num = 4;
                n--;
            }
            sb.append(num);
        }
        if( n != 0)
            sb.append(n);
        answer = sb.reverse().toString();
        
        return answer;
    }
  }