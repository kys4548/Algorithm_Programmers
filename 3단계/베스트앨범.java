import java.util.HashMap;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Collections;
import java.util.Comparator;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        HashMap<String, Integer> hm = new HashMap<String ,Integer>();
        HashSet<String> hs = new HashSet<String>();
        int length = genres.length;
        
        for(int i=0; i<length; i++){
            String s = genres[i];
            hs.add(s);
            int value = hm.getOrDefault(s,0);
            hm.put(s,value+plays[i]);
        }
        ArrayList<String> al = new ArrayList<String>(hs);
        Collections.sort(al,new Comparator<String>(){
            @Override
            public int compare(String s1, String s2){
                return hm.get(s2) - hm.get(s1);
            }
        });
        
        int len = al.size();
        ArrayList<Integer> al2 = new ArrayList<Integer>();
        for(int i=0; i<len; i++){
            int first = 0;
            int second = 0;
            int idx1 = -1;
            int idx2 = -1;
            String s = al.remove(0);
            for(int j=0; j<length; j++){
                if(s.equals(genres[j])){
                    if(plays[j]>first){
                        idx2 = idx1;
                        second = first;
                        idx1 = j;
                        first = plays[j];
                    }
                    else if(plays[j] <= first && plays[j] > second){
                        idx2 = j;
                        second =plays[j];
                    }
                }
            }
            al2.add(idx1);
            if(idx2 != -1)
                al2.add(idx2);
        }
        int[] answer = new int[al2.size()];
        for(int i=0; i<al2.size(); i++){
            answer[i] = al2.get(i);
        }
        return answer;
    }
}