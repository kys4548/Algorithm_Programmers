import java.util.HashMap;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        
        HashMap<String, Integer> hm = new HashMap<String, Integer>();
        for(String s : completion)
            hm.put(s, hm.getOrDefault(s,0) +1);
        
        for(String s : participant){
            if(hm.getOrDefault(s,0)==0){
                answer = s;
                break;
            }
            hm.put(s,hm.get(s)-1);
        }
        return answer;
    }
}