class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];
        
        while(s.length() > 1) {
            int beforeLength = s.length();
            s = s.replace("0", "");
            answer[1] += beforeLength - s.length();
            
            int num = s.length();
            s = step2(num);
            answer[0]++;
        }
        return answer;
    }

    private String step2(int num) {
        StringBuilder sb = new StringBuilder();
        while(num > 1) {
            sb.append(num % 2);
            num /= 2;
        }
        sb.append(num);
        
        return sb.reverse().toString();
    }
}