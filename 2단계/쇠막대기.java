class Solution {
    public int solution(String arrangement) {
        int answer = 0;
        arrangement = arrangement.replace("()","|");
        int len = arrangement.length();
        int count = 0;
        
        for(int i=0; i<len; i++){
            char c = arrangement.charAt(i);
            
            if(c == '('){
                count++;
            }else if(c == ')'){
                count--;
                answer++;
            }else{
                answer +=count;
            }
        }
        return answer;
    }
}