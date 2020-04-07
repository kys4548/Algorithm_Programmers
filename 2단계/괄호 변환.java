class Solution {
    public String solution(String p) {
        if(p.equals(""))
            return p;
        String answer = "";
        int index = 0;
        int cnt = 0;
        int len = p.length();
        
        for(int i=0; i<len; i++){
            char c = p.charAt(i);
            if(c =='(')
                cnt++;
            if(c ==')')
                cnt--;
            if(cnt==0){
                index = i;
                break;
            }
        }
        String u = p.substring(0,index+1);
        String v = p.substring(index+1,len);
        System.out.println(u+" "+v);
        int cnt2 = 0;
        for(int i=0; i<index+1; i++){
            char c = u.charAt(i);
            if(c =='(')
                cnt2++;
            if(c ==')')
                cnt2--;
            if(cnt2<0){
                break;
            }
        }
        if(cnt2==0)
            return u+solution(v);
        
        StringBuilder sb = new StringBuilder();
        sb.append('(').append(solution(v)).append(')');
        u = u.substring(1,index);
        for(int i=0; i<u.length(); i++){
            char c = u.charAt(i);
            if(c =='(')
                sb.append(')');
            if(c == ')')
                sb.append('(');
        }
        answer = sb.toString();
        return answer;
    }
}