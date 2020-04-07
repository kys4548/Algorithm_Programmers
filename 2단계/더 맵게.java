import java.util.PriorityQueue;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        
        for(int scov : scoville)
            pq.add(scov);
        if(pq.peek()>=K)
            return 0;
        
        while(pq.peek() <K){
            if(pq.size() <2)
                break;
            int sco = pq.poll() + pq.poll()*2;
            answer++;
            pq.add(sco);
        }
        if(pq.peek() <K)
            return -1;
        return answer;
    }
}