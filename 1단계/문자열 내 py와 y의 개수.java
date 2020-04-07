class Solution {
    boolean solution(String s1) {
        boolean answer = true;
        String s = s1.toLowerCase();
        int countP = 0;
        int countY = 0;
        
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            
            if(c == 'p')
                countP++;
            else if(c== 'y')
                countY++;
        }
        
        if( countP != countY)
            answer = false;
        return answer;
    }
}