import java.util.ArrayList;

class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        ArrayList<Integer> list = new ArrayList<Integer>();
        
            
        for(int i=0; i<n; i++){
            if(computers[i][i] ==1){
                computers[i][i] = 0;
                answer++;
                
                for(int j=0; j<n; j++){
                    if(computers[i][j] == 1)
                        list.add(j);
                }
                
                while(!list.isEmpty()){
                    int a = list.remove(0);
                    
                    if(computers[a][a] ==0)
                        continue;
                    else{
                        computers[a][a] = 0;
                        for(int k=0; k<n; k++){
                            if(computers[a][k] ==1)
                                list.add(k);
                        }
                    }
                }
                
            }
        }
        return answer;
    }
}