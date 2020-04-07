import java.util.HashMap;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        HashMap<String, Integer> hm = new HashMap<String, Integer>();


        for(String s : phone_book){
            for(int i=1 ; i<=s.length(); i++){
                String s1 = s.substring(0,i);

                hm.put(s1,hm.getOrDefault(s1,0)+1);
            }
        }

        for(String s : phone_book)
            if(hm.get(s)>1)
                answer = false;

        return answer;
    }
}