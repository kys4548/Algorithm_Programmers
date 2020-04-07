import java.util.ArrayList;
import java.util.List;

class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        List<Integer> list = new ArrayList<Integer>();
        
        int index = 1;
        
        for(int station : stations) {
            int min = station - w;
            int max = station + w;
            
            if(min > index) {
                list.add(min - index);
            }
            index = max +1;
        }
        int max = stations[stations.length-1] + w;
        if(max < n) {
            list.add(n- max);
        }
        
        w = 2*w +1;
        for(int distance : list) {
            answer += distance / w;
            if(distance % w != 0){
                answer++;
            }
        }
        
        return answer;
    }
}