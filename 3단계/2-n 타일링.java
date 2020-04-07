// 피보나치수열 규칙이 있네

class Solution {
    public int solution(int n) {
        int answer = 0;
        if(n==1)
            return 1;
        
        int[] arr = new int[n];
        arr[0] = 1;
        arr[1] = 2;
        
        for(int i=2; i<n; i++){
            arr[i] = (arr[i-1] + arr[i-2])%1000000007;
        }
        answer = arr[n-1];
        return answer;
    }
  }