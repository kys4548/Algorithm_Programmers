import java.util.Arrays;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        int[] clothes = new int[n];
        Arrays.fill(clothes,1);
        
        for(int lst :lost)
            clothes[lst-1]--;
        for(int sev : reserve)
            clothes[sev-1]++;
        
        for(int i=0; i<clothes.length-1; i++){
            if(clothes[i]==2 && clothes[i+1]==0){
                clothes[i]--;
                clothes[i+1]++;
            }else if(clothes[i]==0 && clothes[i+1]==2){
                clothes[i]++;
                clothes[i+1]--;
            }
        }
        
        for(int cloth : clothes)
            if(cloth >0)
                answer++;
        
        return answer;
    }
}