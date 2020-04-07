import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.Comparator;
class Solution {
    public int[] solution(String s) {
        Set<String> set = new HashSet<String>();
        String[] arr = s.replace("{{","").replace("}}","").replace("},{"," ").split(" ");
        int[] answer = new int[arr.length];
        
        String[][] result = new String[arr.length][];
        
        for(int i=0; i<arr.length; i++) {
            result[i] = arr[i].split(",");
        }
        Arrays.sort(result, new Comparator<String[]>() {
           
            @Override
            public int compare(String[] temp1, String[] temp2) {
                return temp1.length - temp2.length;
            }
        });
        
        for(int i=0; i<result.length; i++) {
            for(int j=0; j<result[i].length; j++) {
                if(!set.contains(result[i][j])) {
                    set.add(result[i][j]);
                    answer[i] = Integer.parseInt(result[i][j]);
                    break;
                }
            }
        }
        return answer;
    }
}