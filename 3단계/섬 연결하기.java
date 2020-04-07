import java.util.ArrayList;
import java.util.HashSet;
import java.util.Collections;
import java.util.Comparator;

class Solution {
    public int solution(int n, int[][] costs) {
        int answer = 0;
        ArrayList<int[]> list = new ArrayList<int[]>();
        HashSet<Integer> set = new HashSet<Integer>();
        
        //임의의 한점에서 시작
        set.add(costs[0][0]);
        while(set.size() < n){
            for(int i=0; i<costs.length; i++){
                if((set.contains(costs[i][0]) && !set.contains(costs[i][1])) || (!set.contains(costs[i][0]) && set.contains(costs[i][1]))){

                    list.add(costs[i]);
                }   
            }
            Collections.sort(list,new Comparator<int[]>(){
                @Override
                public int compare(int[] a, int[] b){
                    return a[2] - b[2];
                }
            });
            int[] temp = list.remove(0);
            
            set.add(set.contains(temp[0]) == true ? temp[1] : temp[0]);
            answer += temp[2];
            list.clear();
        }
        return answer;
    }
}