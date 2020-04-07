class Solution {
    public boolean solution(int x) {
        boolean answer = true;
        final String[] strArr = String.valueOf(x).split("");
        int sum = 0;
        for(String str : strArr){
            sum += Integer.parseInt(str);
        }
        if(x % sum != 0)
            answer = false;
        return answer;
    }
  }