class Solution {
    public String solution(String s) {
        String[] arr =s.split("");
        
        int count = 0;
        for(int i=0; i<arr.length; i++){
            if(arr[i].charAt(0)==' '){
                count = 0;
                continue;
            }
            if(count % 2 ==0){
                arr[i] = arr[i].toUpperCase();
            }
            else
                arr[i] = arr[i].toLowerCase();
            count++;
        }
        StringBuilder sb = new StringBuilder();
        for(String str : arr)
            sb.append(str);
        String answer = sb.toString();
        
        return answer;
    }
  }