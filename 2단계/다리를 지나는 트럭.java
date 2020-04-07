class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int index = 0;
        int len = truck_weights.length;
        int sum = 0;
        int[] bridge = new int[bridge_length];
        
        while(index < len){
            sum -= bridge[bridge_length-1];
            for(int i=bridge_length-2; i>=0; i--){
                bridge[i+1] = bridge[i];
            }
            bridge[0] = 0;
            if(sum+truck_weights[index] <= weight){
                bridge[0] = truck_weights[index];
                sum += truck_weights[index];
                index++;
            }
            answer++;
        }
        answer += bridge_length;
        return answer;
    }
}