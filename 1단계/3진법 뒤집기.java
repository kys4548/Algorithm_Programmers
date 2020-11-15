class Solution {
    public int solution(int n) {
        int answer = 0;
        StringBuilder sb = new StringBuilder();
        while(n >= 3) {
            sb.append(n % 3);
            n /= 3;
        }
        sb.append(n);
        
        String s = sb.reverse().toString();
        for(int i=0; i<s.length(); i++) {
            answer += (s.charAt(i) - '0') * Math.pow(3, i);
        }
        return answer;
    }
}