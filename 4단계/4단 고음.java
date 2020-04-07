class Solution {
    public int solution(int n) {
        int answer = 0;
        answer = solve(0, 0, n);
        return answer;
    }
      public int solve(int star, int sum, int n) {
          if(sum >=40)
              return 0;
          if(n <0)
              return 0;
          if(n == 1) {
              if(star*2 == sum)
                  return 1;
              return 0;
          }
          
          if(star <sum/2 && n%3 == 0)
              return solve(star+1, sum, n/3) + solve(star, sum+1, n-1);
          return solve(star, sum+1, n-1);
      }
  }