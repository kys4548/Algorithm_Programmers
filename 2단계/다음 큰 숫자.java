class Solution {
    public int solution(int n) {
        int answer = 0;
        StringBuilder sb = new StringBuilder();
        while(n > 1){
            sb.append(n%2);
            n /=2;
        }
        sb.append("1");
        
        String str = sb.reverse().toString();
        sb.setLength(0);
        int idx1 = str.indexOf("0"); //1로만 이루어진 경우 예외
        int idx2 = str.lastIndexOf("01"); //  1111100000 이런경 예외
        int zero;
        int one;
        if(idx1 == -1) //1로만 이루어졌거나  11110000 경우
            sb.append(str.charAt(0)).append("0").append(str.substring(1));
        else if(idx2 == -1){
            one = 0;
            zero = 0;
            for(int e=1; e<str.length(); e++){
                if(str.charAt(e)=='0')
                    zero++;
                else
                    one++;
            }
            sb.append(str.charAt(0)).append("0");
            for(int o=0; o<zero; o++)
                sb.append("0");
            for(int p=0; p<one; p++)
                sb.append("1");
        }
        else{
            one = 0;
            zero = 0;
            for(int k=idx2+2; k<str.length(); k++){
                if(str.charAt(k)=='0')
                    zero++;
                else
                    one++;
            }
            sb.append(str.substring(0,idx2)).append("10");
            for(int q=0; q<zero; q++)
                sb.append("0");
            for(int w=0; w<one; w++)
                sb.append("1");
        }
        str = sb.toString();
        System.out.println(str);
        for(int i=0; i<str.length(); i++){
            answer *= 2;
            if(str.charAt(i)=='1')
                answer += 1;
        }
        
        
        
        return answer;
    }
  }