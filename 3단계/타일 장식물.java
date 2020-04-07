class Solution {
    public long solution(int N) {
        if(N==1)
            return 4;
        
        long answer = 0;
        long[] arr = new long[N+1];
        arr[0] =1;
        arr[1] =1;
        for(int i=2; i<=N; i++){
            arr[i] = arr[i-1] + arr[i-2];
        }
        answer = arr[N] *2 + arr[N-1] *2;
        return answer;
    }
}