class Solution {
    public double solution(int[] arr) {
        double sum = 0;
        double avg;
        int num = arr.length;
        
        for(int value : arr)
            sum += value;
        avg = sum / num;
        
        return avg;
    }
  }