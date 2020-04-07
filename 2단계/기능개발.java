import java.util.ArrayList;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int last = progresses.length;
        int index = 0;
        ArrayList<Integer> al = new ArrayList<Integer>();
        
        while(index <last){
            if(progresses[index] < 100) {
                for(int i=index; i<last; i++){
                    progresses[i] += speeds[i];
                }
            }
            else {
                int num = 0;
                while(progresses[index] >= 100){
                    num++;
                    index++;
                    if(index == last)
                        break;
                }
                al.add(num);
            }
        }
        int[] answer = new int[al.size()];
        for(int i=0; i<answer.length; i++){
            answer[i] = al.remove(0);
        }
        
        return answer;
    }
}