import java.util.PriorityQueue;
import java.util.LinkedList;
import java.util.Collections;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
        LinkedList<Integer> ll = new LinkedList<Integer>();
        
        for(int num : priorities){
            pq.add(num);
            ll.add(num);
        }
        while(!pq.isEmpty()){
            int max = pq.poll();
            while(max != ll.get(0)){
                ll.add(ll.remove(0));
                location--;
                if(location <0)
                    location = ll.size() - 1;
            }
            ll.remove(0);
            answer++;
            location--;
            if(location <0)
                break;
        }
        return answer;
    }
}