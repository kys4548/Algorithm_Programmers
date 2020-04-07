import java.util.HashSet;
import java.util.Iterator;

class Solution {
    public int solution(String numbers) {
        int answer = 0;
        HashSet<Integer> hs = new HashSet<Integer>();
        for(int i=0; i<numbers.length(); i++)
            solve(""+numbers.charAt(i),numbers.substring(0,i)+numbers.substring(i+1,numbers.length()),hs);   
        
        Iterator i = hs.iterator();
        
        while(i.hasNext()){
            int n = (int)i.next();
            if(n ==0 || n==1)
                continue;
            if(sosu(n))
                answer++;
        }
        
        return answer;
    }
    public boolean sosu(int n){
        for(int i=2; i<= Math.sqrt(n); i++){
            if(n % i ==0)
                return false;
        }
        return true;
    }
    public void solve(String s, String numbers, HashSet<Integer> hs){
        hs.add(Integer.parseInt(s));
        for(int i=0; i<numbers.length(); i++)
            solve(s+numbers.charAt(i),numbers.substring(0,i)+numbers.substring(i+1,numbers.length()),hs);   
        if(numbers.equals(""))
            return;
    }
}