import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Comparator;

class Solution {
    public int solution(int[][] routes) {
        int answer = 0;
        int exit = -50000;
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>(){
           @Override
            public int compare(int[] a, int[] b){
                return a[1] - b[1];
            }
        });
        for(int[] route : routes){
            Arrays.sort(route);
        }
        
        for(int[] route: routes){
            pq.add(route);
        }
        
        exit = pq.poll()[1];
        
        while(!pq.isEmpty()){
            int[] temp = pq.poll();
            if(exit >= temp[0])
                continue;
            else{
                exit = temp[1];
                answer++;
            }
        }
        
        return answer+1;
    }
}