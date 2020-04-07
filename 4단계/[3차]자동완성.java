import java.util.Arrays;

class Solution {
  public int solution(String[] words) {
      int answer = 0;
      int length = words.length;
      Arrays.sort(words);
      
      answer += addChar(words[0],words[1]);
      
      for(int i=1; i<length-1; i++) {
          answer += Math.max( addChar(words[i], words[i-1]), addChar(words[i], words[i+1]) );
      }
      answer += addChar(words[length-1], words[length-2]);
      
      return answer;
  }
    public int addChar( String str1, String str2) {
        int length = str1.length();
        StringBuilder sb = new StringBuilder();
        
        for(int i=0; i<length; i++) {
            sb.append(str1.charAt(i));
            String str = sb.toString();
            if(!str2.startsWith(str)) {
                break;
            }
        }
        return sb.length();
    }
}