import java.util.HashMap;
import java.util.ArrayList;
class Solution {
    public String[] solution(String[] record) {
        ArrayList<String> al = new ArrayList<String>();
        HashMap<String, String> hm = new HashMap<String, String>();
        
        for(String s : record){
            String[] arr = s.split(" ");
            if(arr[0].equals("Enter")){
                al.add(arr[1]+"-님이 들어왔습니다.");
                hm.put(arr[1],arr[2]);
            }
            else if(arr[0].equals("Leave")){
                al.add(arr[1]+"-님이 나갔습니다.");
            }
            else{ // Change
                hm.put(arr[1],arr[2]);
            }
        }
        
        String[] answer = new String[al.size()];
        for(int i=0; i<answer.length; i++){
            String s = al.remove(0);
            String[] str = s.split("-");
            answer[i] = hm.get(str[0])+str[1];
        }
        return answer;
    }
}