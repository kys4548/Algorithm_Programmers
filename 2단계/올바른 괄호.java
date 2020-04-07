class Solution {
    boolean solution(String s) {
        boolean answer = true;
        char[] charArr = s.toCharArray();
        int count = 0;
        
        for(char c : charArr){
            if(c == ')'){
                count--;
                if(count<0){
                    return false;
                }
            }else
                count++;
        }
        
        if(count !=0)
            answer =false;

        return answer;
    }
}