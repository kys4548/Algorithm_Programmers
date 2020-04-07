import java.util.ArrayList;

class Solution {
    public int[] solution(int[] answers) {
        int[] arr1 = {1,2,3,4,5};
        int[] arr2 = {2,1,2,3,2,4,2,5};
        int[] arr3 = {3,3,1,1,2,2,4,4,5,5};
        int[] scores = new int[3];
        int answersLength = answers.length;
        
        for(int i=0; i<answersLength; i++){
            if(answers[i] == arr1[i% 5])
                scores[0]++;
            if(answers[i] == arr2[i% 8])
                scores[1]++;
            if(answers[i] == arr3[i% 10])
                scores[2]++;
        }
        
        int maxScore = scores[0];
        int scoresLength = scores.length;
        for(int i=1; i<scoresLength; i++){
            if(maxScore < scores[i])
                maxScore = scores[i];
        }
        
        ArrayList<Integer> al = new ArrayList<Integer>();
        for( int i=0; i<scoresLength; i++)
            if(scores[i] ==maxScore)
                al.add(i+1);
        
        
        int alSize = al.size();
        int[] answer = new int[alSize];
        
        for(int i =0; i<alSize; i++)
            answer[i] = al.get(i);
        
        return answer;
    }
}