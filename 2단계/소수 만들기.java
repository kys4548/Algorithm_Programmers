import java.util.ArrayList;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        final ArrayList<Integer> al = new ArrayList<Integer>();
        final ArrayList<Integer> al2 = new ArrayList<Integer>();
        final int length = nums.length;
        
        for(int num : nums)
            al.add(num);
        
        for(int i=0; i<al.size()-2; i++){
            int n1 =al.remove(i);
            for(int j=i; j<al.size()-1; j++){
                int n2 =al.remove(j);
                for(int k=j; k<al.size(); k++){
                    int n3 = al.remove(k);
                    al2.add(n1+n2+n3);
                    al.add(k,n3);
                }
                al.add(j,n2);
            }
            al.add(i,n1);
        }
        
        
        for(int n : al2){
            if(sosu(n))
                answer++;
        }

        
        return answer;
    }
    
    public boolean sosu(int n){
        for(int i=2; i<=Math.sqrt(n); i++){
            if(n % i==0){
                return false;
            }
        }
        return true;
    }
}T