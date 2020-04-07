class Solution {
    public boolean solution(String s) {
        boolean answer = true;
        
        char[] charArr = s.toCharArray();
        int length = charArr.length;
        
        if(length != 4 && length != 6){
            answer = false;
        }
        for(char a : charArr){
            if(a < '0' || a > '9'){
                answer = false;
                break;
            }
        }
        return answer;
    }
  }