import java.util.ArrayList;

class Solution {
    public int solution(String s) {
        
        int answer = 10000000;
        ArrayList<String> al = new ArrayList<String>();
        int length = s.length();
        if(length==1)
            return 1;
        int length_2 = length/2;
        
        for(int i=0; i<length_2; i++){
            int num = 0;
            int count = i+1;
            while(count < length){
                al.add(s.substring(count-i-1,count));
                count += i+1;
            }
            
            al.add(s.substring(count-i-1,length));
            
            String ss = al.get(0);
            int cc =1;
            for(int j=1; j<al.size(); j++){
                if(ss.equals(al.get(j))){// 같다면
                    cc++;
                }else{// 다르다면
                    num += i+1;
                    if(cc != 1){
                        while(cc >=10){
                            cc /= 10;
                            num++;
                        }
                        num++;
                    }
                    cc = 1;
                }
                ss = al.get(j);
            }
            if(cc != 1){
                num += al.get(al.size()-1).length();
                while(cc >=10){
                            cc /= 10;
                            num++;
                        }
                        num++;
            }
            else{
                num +=al.get(al.size()-1).length();
            }
            if(num < answer)
                answer = num;
            al.clear();
        }
        return answer;
    }
}