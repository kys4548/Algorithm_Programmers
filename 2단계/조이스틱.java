class Solution {
    public int solution(String name) {
        int answer = 0;
        int length = name.length();
        int[] arr = new int[length];
        
        for(int i=0; i<length; i++)
            arr[i] = Math.min(name.charAt(i)-'A','Z'-name.charAt(i)+1);
        int current = 0;
        int left = 0;
        int right = length-1;
        answer += arr[0];
        arr[0] = 0;
        
        while(left < right){
            for(int i=left; i<length; i++){
                if(arr[i] != 0){
                    left =i;
                    break;
                }
            }
            if(left ==0)
                return answer;
            for(int i=right; i>=0; i--){
                if(arr[i] != 0){
                    right =i;
                    break;
                }
            }
            int left_distance = 0;
            int right_distance = 0;
            
            if(left > current)
                left_distance = left - current;
            else
                left_distance = length - current + left;
            if(right > current)
                right_distance = length - right + current;
            else
                right_distance = current - right;
            
            if(right_distance > left_distance){
                current = left;
                answer += left_distance;
                answer +=arr[current];
                arr[current] = 0;
            }else if(right_distance < left_distance){
                current = right;
                answer += right_distance;
                answer +=arr[current];
                arr[current] =0;
            }else{
                int left_len = 0;
                int right_len = 0;
                for(int i=left; i<length; i++){
                    if(arr[i] !=0)
                        left_len++;
                    else
                        break;
                }
                for(int i=right; i>0; i--){
                    if(arr[i] !=0)
                        right_len++;
                    else
                        break;
                }
                if(left_len <= right_len){
                    current = left;
                    answer += left_distance;
                    answer +=arr[current];
                    arr[current] = 0;
                }else{
                    current = right;
                    answer += right_distance;
                    answer +=arr[current];
                    arr[current] =0;
                }
            }
        }
        return answer;
    }
}