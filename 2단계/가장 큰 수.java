import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        ArrayList<String> al = new ArrayList<String>();
        
        for(int n : numbers)
            al.add(Integer.toString(n));
        Collections.sort(al, new Comparator<String>(){
           @Override
            public int compare(String s1, String s2){
                int len1 = s1.length();
                int len2 = s2.length();
                char c1 = s1.charAt(0);
                while(s1.length()<4)
                    s1 += c1;
                char c2 = s2.charAt(0);
                while(s2.length()<4)
                    s2 += c2;
                if(s1.equals(s2)){
                    char c3 = s1.charAt(1);
                    if(c1 < c3)
                        return len1 -len2;
                    return len2 - len1;
                }
                    
                return s2.compareTo(s1);
            }
        });
        StringBuilder sb = new StringBuilder();
        while(!al.isEmpty()){
            sb.append(al.remove(0));
        }
        answer = sb.toString();
        if(answer.charAt(0)== '0')
            answer = "0";
        return answer;
    }
}