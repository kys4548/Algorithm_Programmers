import java.util.TreeSet;
import java.util.Set;
import java.util.Iterator;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public String[] solution(String[][] tickets) {
        Set<String> set = new TreeSet<String>();
        String[] answer = new String[tickets.length+1];
        int[] order = new int[tickets.length+1];
        Map<String, Integer> map = new HashMap<String, Integer>();
        Map<Integer, String> map2 = new HashMap<Integer, String>();
        for(String[] ticket : tickets) {
            set.add(ticket[0]);
            set.add(ticket[1]);
        }
        
        Iterator i = set.iterator();
        int index = 0;
        while(i.hasNext()) {
            String str = (String)i.next(); 
            map.put(str, index);
            map2.put(index, str);
            index++;
        }
        
        int[][] arr = new int[index][index];
        for(String[] ticket : tickets) {
            arr[map.get(ticket[0])][map.get(ticket[1])]++;
        }
        int first = map.get("ICN");
        order[0] = first;
        
        findPath(order, first, arr, index, 1, tickets.length+1);
        
        for(int j=0; j<order.length; j++) {
            answer[j] = map2.get(order[j]);
        }
        return answer;
    }
    public boolean findPath(int[] order, int start, int[][] arr, int index, int depth, int max) {
        if(depth >= max) {
            return true;
        }

        boolean find = false;
        //print(arr , index);
        
        for(int i=0; i<index; i++) {
            if(arr[start][i] != 0) {
                order[depth] = i;
                arr[start][i]--;
                
                if( findPath(order, i, arr, index, depth+1, max) == true) {
                    find = true;
                    break;
                } 
                arr[start][i]++;
            }
        }
        
        return find;
    }
    public void print(boolean[][] arr, int index){
        for(int i=0; i<index; i++) {
            for(int j=0; j<index; j++) {
                System.out.printf("%6b ", arr[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }
}