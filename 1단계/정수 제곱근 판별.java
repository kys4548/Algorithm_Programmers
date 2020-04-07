class Solution {
    public long solution(long n) {
        long answer = -1;
        
        double result = Math.sqrt(n);
        
        if(result % 1 == 0)
            answer = (long)((result+1) * (result+1));
        
        return answer;
    }
  }