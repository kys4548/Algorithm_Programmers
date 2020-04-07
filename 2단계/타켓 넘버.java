/*import java.util.LinkedList;

class Solution {  //너비 우선 탐색 
    public int solution(int[] numbers, int target) {
        int answer = 0;
        final int length = numbers.length;
        final LinkedList<Integer> ll = new LinkedList<Integer>();
        
        ll.add(numbers[0]);
        ll.add(-numbers[0]);
        for(int i=1; i<length-1; i++){
            for(int j=0; j<Math.pow(2,i); j++){
                int value = ll.remove(0);
                ll.add(value+numbers[i]);
                ll.add(value-numbers[i]);
            }
        }
        int number = numbers[length-1];
        for(int num : ll){
            if(num+number ==target)
                answer++;
            if(num- number == target)
                answer++;
        }
        return answer;
    }
}
*/







class Solution { //깊이 우선 탐색
    public int solution(int[] numbers, int target) {
        int answer =0;
        answer = dfs(numbers,0,0,target);
        return answer;
    }
    
    public int dfs(int[] numbers, int sum, int num, int target){
        if(num ==numbers.length){
            int n=0;
            if(sum == target)
                n++;
            return n;
                
        }
        
        return dfs(numbers,sum+numbers[num],num+1,target) + dfs(numbers,sum-numbers[num],num+1,target);
    }
}