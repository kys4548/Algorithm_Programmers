class Solution {
    public int solution(int[] food_times, long k) {
        int answer = 0;
        int length = food_times.length;
        int leftOvers = length;
        
        while(k >= leftOvers) {
            if(leftOvers == 0) {
                break;
            }
            
            long num = k / (long)leftOvers;
            k %= (long)leftOvers;
            
            int count = 0;
            
            for(int i=0; i<length; i++) {
                if(food_times[i] <= 0) {
                    continue;
                }
                
                food_times[i] -= num;                
                if(food_times[i] <= 0) {
                    count++;
                    k -= food_times[i];
                } 
            }
            leftOvers -= count;
        }
        
        if(leftOvers == 0) {
            return -1;
        }
        
        // System.out.println("정전까지 남은 시간 : "+k);
        // printFood(food_times);
        
        for(int i=0; i<length; i++) {
            if(food_times[i] > 0) {
                k--;
                if(k < 0) {
                    answer = i+1;
                    break;
                }
            }
        }
        
        return answer;
    }
    
    public void printFood(int[] food_times) {
        for(int i=0; i<food_times.length; i++) {
            System.out.printf("%4d ", food_times[i]);
        }
        System.out.println();
        System.out.println();
        
    }
}