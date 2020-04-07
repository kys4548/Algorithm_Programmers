import java.util.HashMap;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = {0,0};
        HashMap<String, Integer> hm = new HashMap<String, Integer>();
        char c = words[0].charAt(words[0].length()-1);
        int index =0;
        hm.put(words[0],1);
        
        for(int i=1; i<words.length; i++){
            hm.put(words[i],hm.getOrDefault(words[i],0)+1);
            if(hm.get(words[i])!=1){
                index =i;
                break;
            }
            if(c== words[i].charAt(0)){
                c = words[i].charAt(words[i].length()-1);
            }else{
                index=i;
                break;
            }
        }
        if(index!=0){
        answer[0] = index % n +1;
        answer[1] = index /n +1;
        }

        return answer;
    }
}