class Solution {
    public String solution(String s) {
        String answer = "";
        int length = s.length();
        int idx = length / 2;
        answer += length %2 ==0 ? s.substring(idx-1, idx+1) : s.charAt(idx);
        return answer;
    }
  }