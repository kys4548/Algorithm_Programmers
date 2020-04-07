import java.util.HashMap;
import java.util.Iterator;

class Solution {
    public int solution(String[][] clothes) {
        int length = clothes.length;
        HashMap<String, Integer> hm = new HashMap<String, Integer>();

        
        for(int i=0; i<length; i++){
            String s = clothes[i][1];
            hm.put(s,hm.getOrDefault(s,0)+1);
        }
        int answer = 1;
        
        for(String s : hm.keySet())
            answer *= hm.get(s)+1;
        return answer-1;
    }
}