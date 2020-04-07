import java.util.HashSet;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        HashSet<Character> hs = new HashSet<Character>();
        int len1 = skill_trees.length;
        char[] arr = skill.toCharArray();
        for(char c : arr)
            hs.add(c);
        
        for(int i=0; i<len1; i++){
            StringBuilder sb = new StringBuilder();
            String str = skill_trees[i];
            int len3 = str.length();
            
            for(int j=0; j<len3; j++){
                char c = str.charAt(j);
                if(hs.contains(c))
                    sb.append(c);
            }
            String s  = sb.toString();
            int len4 = s.length();
            answer++;
            for(int j=0; j<len4; j++){
                if(s.charAt(j) != skill.charAt(j)){
                    answer--;
                    break;
                }
            }
        }
        
        return answer;
    }
}