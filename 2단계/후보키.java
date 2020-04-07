import java.util.Set;
import java.util.HashSet;
import java.util.ArrayList;
import java.util.List;

class Solution {
    public int solution(String[][] relation) {
        int answer = 0;
        int row = relation.length;
        int column = relation[0].length;
        List<Integer> list = new ArrayList<Integer>();
        
        for(int i=1; i<(1<<column); i++) {
            Set<String> set = new HashSet<String>();
            
            for(int j=0; j<row; j++) {
                StringBuilder sb = new StringBuilder();
                
                for(int k=0; k<column; k++) {
                    if( (i & (1<<k) ) > 0) {
                        sb.append(relation[j][k]);
                    }
                }
                set.add(sb.toString());
            }
            if(set.size() == row && check(list,i)) {
                list.add(i);
            }
        }
        answer = list.size();
        return answer;
    }
    
    public boolean check(List<Integer> list, int i) {
        int length = list.size();
        
        for(int l=0; l<length; l++) {
            int n = list.get(l);
            if( (n & i) == n) {
                return false;
            }
        }
        return true;
    }
}