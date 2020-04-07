class Solution {
    public int[] solution(long begin, long end) {
        int n = (int)(end - begin +1);
        int[] answer = new int[n];
  
        for(int i=0; i<n; i++) {
            int blockNum = (int)begin+i;
            if(blockNum == 1) {
                continue;
            }
            answer[i] = maxDivisor(blockNum);
  
        }
        return answer;
    }
      public int maxDivisor(int num) {
          int max = (int)Math.sqrt(num);
          for(int i=2; i<=max; i++) {
              if(num % i == 0 && num / i <= 10000000) {
                  return num / i;
              }
          }
          return 1;
      }
  }