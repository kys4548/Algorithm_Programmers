class Solution {
    public String solution(String s) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        
        s = s.toLowerCase();
        char c = s.charAt(0);
        if(c >='a' && c <='z'){
            c = (char)(c-32);
        }
        char front = c;
        char back;
        sb.append(front);
        
        for(int i=0; i<s.length()-1; i++){
            back = s.charAt(i+1);
            
            if(front == ' ' && back  >= 'a' && back <='z'){
                sb.append((char)(back-32));
            }else
                sb.append(back);
            front = back;
        }
        answer = sb.toString();
        return answer;
    }
  }