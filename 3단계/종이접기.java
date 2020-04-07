class Solution {
    public int[] solution(int n) {
        int max = (int)Math.pow(2,n)-1;
        int[] answer = new int[max];
        
        for(int i=0; i<n; i++){
            int count = 0;
            int a = (int)Math.pow(2,i)-1;
            int k = (int)Math.pow(2,n-1-i);
            int r = (int)Math.pow(2,i+1);
            for(int j=0; j<k; j++){
                answer[a] = count;
                if(count==0)
                    count++;
                else
                    count--;
                a +=r;
            }
        }
        for( int g : answer)
            System.out.print(g+" ");
        return answer;
    }
  }