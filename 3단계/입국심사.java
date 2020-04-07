class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        long maxExaminationTime = 1;
        for(int time : times) {
            if(maxExaminationTime < time) {
                maxExaminationTime = time;
            }
        }
        
        long max = maxExaminationTime * n;
        long min = 1;
        long middle;
        long passengers;
        
        do {
            middle = (max + min) /2;
            passengers = 0;
            for(int time : times) {
                passengers += middle / time;
            }
            if(passengers >= n) {
                max = middle;
            }
            else if(passengers < n) {
                min = middle;
            }
            //System.out.println(max + " " + middle + " " + min + " " + passengers);
        } while(max - min >1);
        answer = max;
        return answer;
    }
}