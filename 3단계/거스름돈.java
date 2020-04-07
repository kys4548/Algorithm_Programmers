class Solution {
    public int solution(int n, int[] money) {
        int answer = 0;
        int length = money.length;
        int[] method = new int[n+1];
        
        for(int num = 0; num <=n; num++) {
            if(num % money[0] == 0) {
                method[num]++;
            }
        }
        for(int i=1; i<length; i++) {
            int[] temp = new int[n+1];
            for(int j=0; j<=n; j++) {
                
                int result = 0;
                for(int k= j; k>0; k-=money[i]) {
                    result += method[k];
                    
                }
                if(j % money[i] == 0) {
                    result++;
                }
                temp[j] = result;
            }
            method = temp;
        }
        answer = method[n];
        return answer;
    }
      public void print(int[] method, int n) {
          for(int i=0; i<=n; i++) {
              System.out.print(method[i] + " " );
          }
          System.out.println();
      }
  }