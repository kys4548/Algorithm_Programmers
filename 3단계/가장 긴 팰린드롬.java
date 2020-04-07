class Solution
{
    public int solution(String s)
    {
        int answer = 0;
        int length = s.length();
        
        for(int i=0; i<length; i++) {
            answer = Math.max(answer, solve1(s, i, length));
            answer = Math.max(answer, solve2(s, i, length));
        }

        return answer;
    }
    public int solve1(String s, int index, int length) {
        int result = 1;
        int left = index-1;
        int right = index+1;
        
        for(int i=0; i<length/2; i++) {
            if(left <0 || right >= length) {
                break;
            }
            char c1 = s.charAt(left);
            char c2 = s.charAt(right);
            
            if(c1 != c2){
                break;
            }
            left--;
            right++;
            result +=2;
        }
        return result;
    }
    public int solve2(String s, int index, int length) {
        int result = 0;
        int left = index;
        int right = index+1;
        
        for(int i=0; i<length/2; i++) {
            if(left <0 || right >= length) {
                break;
            }
            char c1 = s.charAt(left);
            char c2 = s.charAt(right);
            
            if(c1 != c2){
                break;
            }
            left--;
            right++;
            result +=2;
        }
        
        
        return result;
    }
}