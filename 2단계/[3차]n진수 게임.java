class Solution {
    public String solution(int n, int t, int m, int p) {
        String answer = "";
        int length = (t-1) * m + p; // 구하여야 하는 총 자리수
        String s = nNotationChange(n,length);
        s = s.toUpperCase();
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<t; i++){
            sb.append(s.charAt(p-1+i*m));
        }
        answer = sb.toString();
        return answer;
    }
      public String nNotationChange(int n,int length){
          StringBuilder sb = new StringBuilder();
          int num = 0;
          while(sb.length() < length){
              int temp = num;
              StringBuilder subSb = new StringBuilder();
              while(temp >= n){
                  subSb.append(Integer.toHexString(temp%n));
                  temp /=n;
              }
              subSb.append(Integer.toHexString(temp));
              num++;
              sb.append(subSb.reverse());
          }
          return sb.toString();
      }
  }