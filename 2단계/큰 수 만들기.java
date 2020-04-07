class Solution {
    public String solution(String number, int k) {
        String answer = "";
        int length = number.length() - k;
        StringBuilder sb = new StringBuilder();
        
        sb.append(number.substring(0,length));
        number = number.substring(length,number.length());
        int index =1;
        
        for(int i=0; i<k; i++){
            //문자 하나 추가.
            sb.append(number.charAt(i));
            
            char c1 = sb.charAt(index-1);
            char c2;
            for(int j=index; j<length+1; j++){
                c2 = sb.charAt(j);
                if(c1 < c2){
                    sb.deleteCharAt(j-1);
                    if(index != 1)
                        index--;
                    break;
                }else{
                    index++;
                    c1 = c2;
                }
            }
            if(sb.length() >length){
                sb.deleteCharAt(length);
                index--;
            }
        }
        answer = sb.toString();
        return answer;
    }
}