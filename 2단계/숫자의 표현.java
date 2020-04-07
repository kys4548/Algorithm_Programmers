class Solution {
    public int solution(int n) {
        int answer = 0;
        int divide = 1;
        int num = 1;
        
        while(n > 0){
            if(n % divide ==0)
                answer++;
            n -= num;
            num++;
            divide++;
            
        }
        return answer; 
    }
  }