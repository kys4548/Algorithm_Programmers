import java.util.PriorityQueue;
import java.util.Collections;

class Solution {
    public int solution(int stock, int[] dates, int[] supplies, int k) {
        int index =0;
        int answer = 0;
        int length = dates.length;
        final PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
        
        while(index <length){
            if(stock >= k)
                return answer;
            while(stock < dates[index]){
                stock += pq.poll();
                answer++;
                if(stock >= k)
                    return answer;
            }
            for(int i=index; i<length; i++){
                if(stock >= dates[i]){
                    pq.add(supplies[i]);
                    if(i==length-1)
                        index =length;
                }
                else{
                    index = i;
                    break;
                }
            }
            stock += pq.poll();
            answer++;
        }
        while(stock <k){
            stock +=pq.poll();
            answer++;
        } 
        return answer;
    }
}