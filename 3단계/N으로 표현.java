import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.HashSet;

class Solution {
    public int solution(int N, int number) {
        int answer = -1;
        List<Integer>[] list = new List[8];
        String str = String.valueOf(N);
        Set<Integer> set = new  HashSet<Integer>();
        
        
        for(int i=0; i<8; i++) {
            list[i] = new ArrayList<Integer>();
            int temp = Integer.parseInt(str);
            
            if(!set.contains(temp)) {
                set.add(temp);
                list[i].add(temp);
            }
            
            for(int j=0; j<i; j++) {
                int length1 = list[j].size();
                int length2 = list[i-j-1].size();
                
                for(int k=0; k<length1; k++) {
                    int num1 = list[j].get(k);
                    for(int l=0; l<length2; l++) {
                        int num2 = list[i-j-1].get(l);
                        int[] tempArr = new int[4];
                        tempArr[0] = num1 + num2;
                        tempArr[1] = num1 - num2;
                        if(num2 != 0) {
                            tempArr[2] = num1 / num2;   
                        }
                        tempArr[3] = num1 * num2;
                        
                        for(int m=0; m<4; m++) {
                            if(set.contains(tempArr[m])) {
                                continue;
                            }
                            set.add(tempArr[m]);
                            list[i].add(tempArr[m]);
                        }
                    }
                }
                
            }
            
            if(set.contains(number)){
                return i+1;
            }
            str += N;
        }
        return answer;
    }
}