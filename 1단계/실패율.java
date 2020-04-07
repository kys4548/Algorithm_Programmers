import java.util.PriorityQueue;

class Solution {
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        double[] failRate = new double[N];
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        int length = stages.length;
        
        for(int stage : stages)
            pq.add(stage);
        
        for(int i=0; i<N; i++){
            int count =0;
            while(!pq.isEmpty()){
                if(pq.peek() <= i+1){
                    pq.poll();
                    count++;
                }
                else{
                    break;
                }
            }
            if(pq.size()+count==0){
                failRate[i] =0;
            }
            else{
                failRate[i] = count / (double)(pq.size()+count);
            }
        }
        
        for(int j=0; j<failRate.length; j++){
            double max = failRate[0];
            int index = 0;
            for(int k=1; k<failRate.length; k++){
                if(max < failRate[k]){
                    max = failRate[k];
                    index = k;
                }
            }
            failRate[index] = -1;
            answer[j] = index+1;
        }
        
        
        return answer;
    }
}