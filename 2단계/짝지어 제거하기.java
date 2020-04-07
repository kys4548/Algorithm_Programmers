import java.util.ArrayList;

class Solution
{
    public int solution(String s)
    {
        int answer = 1;
        ArrayList<Character> al = new ArrayList<>();
        
        for(Character c : s.toCharArray()) {
            if(al.isEmpty()) {
                al.add(c);
            }
            else {
                if(al.get(al.size()-1) == c) {
                    al.remove(al.size()-1);
                }
                else {
                    al.add(c);
                }
            }
        }
        if(!al.isEmpty())
            answer = 0;

        return answer;
    }
}