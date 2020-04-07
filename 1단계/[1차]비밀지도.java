class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        
        for(int i=0; i<n; i++){
            String s = Integer.toBinaryString(arr1[i] | arr2[i]);
            while(s.length() < n)
                s = "0"+s;
            StringBuilder sb = new StringBuilder();
            for(int j=0; j<n; j++){
                if(s.charAt(j)=='0')
                    sb.append(" ");
                else
                    sb.append("#");
            }
            answer[i] = sb.toString();
        }
        return answer;
    }
  }