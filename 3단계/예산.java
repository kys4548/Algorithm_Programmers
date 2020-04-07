import java.util.Arrays;

class Solution {
    public int solution(int[] budgets, int M) {
        int answer = 0;
        Arrays.sort(budgets);
        int start = 0;
        int end = budgets[budgets.length-1];
        
        while(start <=end) {
            int mid = ( start + end ) / 2;
            long requestBudgets = 0;
            
            for(int budget : budgets) {
                requestBudgets += ( budget >= mid ? mid : budget );
            }
            if(requestBudgets > M) {
                end = mid -1;
            }
            else {
                start = mid +1;
            }
        }
        answer = end;
        return answer;
    }
}