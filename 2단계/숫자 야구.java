import java.util.ArrayList;
import java.util.LinkedList;

class Solution {
    public int solution(int[][] baseball) {
        final char[] arr= {'1','2','3','4','5','6','7','8','9'};
        final int length = arr.length;
        final ArrayList<Character> al = new ArrayList<Character>();
        final LinkedList<String> q = new LinkedList<String>();
        StringBuilder sb = new StringBuilder();
        int answer = 0;
        
        for(char c : arr)
            al.add(c);
        
        for(int i=0; i<length; i++){
            char c1 = al.remove(i);
            for(int j=0; j<length-1; j++){
                char c2 =al.remove(j);
                for(int k=0; k<length-2; k++){
                    char c3 = al.remove(k);
                    q.add(sb.append(c1).append(c2).append(c3).toString());
                    al.add(k,c3);
                    sb.setLength(0);
                }
                al.add(j,c2);
            }
            al.add(i,c1);
        }
        
        while(!q.isEmpty()){
            String s1 = q.remove(0);
            
            for(int i=0; i<baseball.length; i++){
                String s2 = Integer.toString(baseball[i][0]);
                int strike = baseball[i][1];
                int ball = baseball[i][2];
                
                for(int j=0; j<3; j++){
                    for(int k=0; k<3; k++){
                        if(j==k && s1.charAt(j)==s2.charAt(k)){
                            strike--;
                        }else if(s1.charAt(j)==s2.charAt(k)){
                            ball--;
                        }
                    }
                }
                if(strike != 0 || ball != 0)
                    break;
                if(i==baseball.length-1)
                    answer++;
            }
        }
        
        
        return answer;
    }
}