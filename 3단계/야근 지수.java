import java.util.Arrays;

class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        Arrays.sort(works);
        int maxIndex = works.length-1;
        
        while(n>0) {
            if(works[maxIndex] == works[maxIndex-1]) {
                while(maxIndex >0 && works[maxIndex] ==works[maxIndex-1]) {
                    maxIndex--;
                }
                if(maxIndex==0) {
                    break;
                }
            }
            
            int diff = works[maxIndex] - works[maxIndex-1];
            int length = works.length-maxIndex;
            if(n >= diff*length ) {
                n -= diff*length;
                for(int i=maxIndex; i<works.length; i++) {
                    works[i] -= diff;
                }
            }
            else {
                int devide = n / length;
                int remain = n % length;
                for(int i=maxIndex; i<works.length; i++) {
                    works[i] -= (devide + (remain-- > 0 ? 1 : 0) );
                }
                n=0;
            }
        }
        if(n >0) {
            int devide = n / works.length;
            int remain = n % works.length;
            for(int i=0; i<works.length; i++) {
                works[i] -= (devide + (remain-- > 0 ? 1 : 0) );
            }
        }
        
        if(works[0] < 0){
            return 0;
        }
        
        for(int work : works) {
            answer += (long)Math.pow(work,2);
        }
        
        return answer;
    }
}