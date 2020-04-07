class Solution {
    public int solution(int n, int[] cores) {
        int answer = 0;
        int length = cores.length;
        if(n <= length) {
            return n;
        }
        n -= length;
        
        //n번째를 시작하는 시간 구하기에서
        //n번째를 끝내는 시간으로 문제 변경
        //이분탐색 시작
        
        int max = n * 10000;
        int min = 1;
        while(min <= max) {
            int mid = (min + max) / 2;
            int count = 0;
            
            for(int i=0; i<length; i++) {
                count += mid / cores[i];
            }
            if( count >= n) {
                max = mid-1;
            }
            else {
                min = mid+1;
            }
        }
        
        for(int i=0; i<length; i++) {
            n -= max / cores[i];
        }
        
        for(int i=0; i<length; i++) {
            if((max+1) % cores[i] == 0) {
                n--;
            }
            if(n == 0) {
                answer = i+1;
                break;
            }
        }
        
        return answer;
    }
  }