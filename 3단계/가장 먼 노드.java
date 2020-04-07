import java.util.HashSet;
import java.util.ArrayList;
import java.util.Arrays;
class Solution {
    public int solution(int n, int[][] edge) {
        int answer = 0;
        boolean[][] arr = new boolean[n][n];
        int[] value = new int[n];
        int length = edge.length;
        HashSet<Integer> hs = new HashSet<Integer>();
        ArrayList<Integer> al = new ArrayList<Integer>();
        
        for(int i=0; i<length; i++){
            int a = edge[i][0] -1;
            int b = edge[i][1] -1;
            arr[a][b] = true;
            arr[b][a] = true;
        }
        
        al.add(0);
        hs.add(0);
        
        while(hs.size() < n){
            int v = al.remove(0);
            for(int i=0; i<n; i++){
                if(arr[v][i]==true && !hs.contains(i)){
                    al.add(i);
                    hs.add(i);
                    value[i] = value[v]+1;
                    
                }
            }
        }
        Arrays.sort(value);
        int max = value[n-1];
        for(int i=n-1; i>=0; i--){
            if(value[i]==max)
                answer++;
            else
                break;
        }
        return answer;
    }
}