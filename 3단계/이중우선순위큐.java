import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        List<Integer> list = new ArrayList<Integer>();
        String deleteMax = "D 1";
        String deleteMin = "D -1";
        
        for(String s : operations) {
            if(s.equals(deleteMax)){
                if(!list.isEmpty()) {
                    list.remove(list.size()-1);
                }
            }
            else if(s.equals(deleteMin)){
                if(!list.isEmpty()) {
                    list.remove(0);
                }
            }
            else {
                list.add(Integer.parseInt(s.substring(2)));
                Collections.sort(list);
            }
        }
        if(list.isEmpty())
            return answer;
        answer[0] = list.get(list.size()-1);
        answer[1] = list.get(0);
        return answer;
    }
}