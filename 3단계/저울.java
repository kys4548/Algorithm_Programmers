import java.util.*;

class Solution {
    public int solution(int[] weight) {
        int answer = 0;
        Arrays.sort(weight);
        for(int i=0;i<weight.length;i++){
            int tmp=weight[i];
            if(answer+1<tmp){
                return answer+1;
            }else{
                answer+=tmp;
            }
        }
        return answer+1;
    }
}