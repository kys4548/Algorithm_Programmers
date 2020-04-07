class Solution {
    public String solution(String s, int n) {
        char[] charArr = s.toCharArray();
        
        for(int i = 0; i < charArr.length; i++){
            if(charArr[i]==' ')
                continue;
            
            else if(Character.isUpperCase(charArr[i])){
                charArr[i] += n;
                if(Character.isUpperCase(charArr[i]))
                    continue;
                else
                    charArr[i] -= 26;
            }
            else{
                charArr[i] += n;
                if(Character.isLowerCase(charArr[i]))
                    continue;
                else
                    charArr[i] -= 26;
            }
        }
        
        String answer = new String(charArr);
        return answer;
    }
  }