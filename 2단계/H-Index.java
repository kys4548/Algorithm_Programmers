import java.util.Arrays;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        Arrays.sort(citations);
        
        int h =0;
        int index = 0;
        while(h <= 10000){
            if(h> citations[index])
                while(index < citations.length && h > citations[index])
                    index++;
            if(h > citations.length - index)
                return h-1;
            h++;
            
        }
        return answer;
    }
}