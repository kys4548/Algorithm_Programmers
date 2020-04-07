import java.util.HashSet;
import java.util.ArrayList;
import java.util.HashMap;

class Solution {
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        int length = words.length;
        boolean targetExist =false;
        HashSet<String> hs = new HashSet<String>();
        ArrayList<String> al = new ArrayList<String>();
        HashMap<String, Integer> hm = new HashMap<String ,Integer>();
        int sublen = begin.length();
        
        for(int i=0; i<length; i++){
            if(words[i].equals(target)){
                targetExist = true;
            }
        }
        
        //words에 target이 없을경우
        if(!targetExist)
            return answer;
        
        hs.add(begin);
        al.add(begin);
        hm.put(begin,0);
        
        while(!hs.contains(target)){
            String s1 = al.remove(0);
            for(int i=0; i<length; i++){
                if(!hs.contains(words[i])){
                    String s2 = words[i];
                    int count = 0;
                    for(int j=0; j<sublen; j++){
                        if(s1.charAt(j) != s2.charAt(j))
                            count++;
                    }
                    if(count==1){
                        hs.add(s2);
                        al.add(s2);
                        hm.put(s2,hm.get(s1)+1);
                        if(s2.equals(target)){
                            answer = hm.get(s2);
                        }
                    }
                }
            }
        }
        
        return answer;
    }
}