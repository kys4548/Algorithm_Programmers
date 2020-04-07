//최대 201개 

class Solution {
	public int solution(String arr[]) {
        int length = arr.length/2;
        boolean[] isPlus = new boolean[length];
        int[][] max = new int[length+1][length+1];
        int[][] min = new int[length+1][length+1];
		int answer = 1;
        
        for(int i=0; i<arr.length; i++) {
            
            // 숫자인경우
            if(i%2 == 0) {
                int num = Integer.parseInt(arr[i]);
                max[i/2][i/2] = num;
                min[i/2][i/2] = num;
                
                continue;
            }
            
            //연산자인 경우
            if(arr[i].equals("+")) {
                isPlus[i/2] = true;
            }
            
        }
        
        for(int i=1; i<length+1; i++) {
            for(int j=i; j<length+1; j++) {
                int maxValue = -1000000;
                int minValue =  1000000;
                
                for(int k=j-i; k<j; k++) {
                    int value;
                    if(isPlus[k] == true) {
                        value = max[j-i][k] + max[k+1][j];
                        maxValue = Math.max(maxValue,value);
                        
                        value = min[j-i][k] + min[k+1][j];
                        minValue = Math.min(minValue,value);
                    }
                    else {
                        value = max[j-i][k] - min[k+1][j];
                        maxValue = Math.max(maxValue,value);
                        
                        value = min[j-i][k] - max[k+1][j];
                        minValue = Math.min(minValue,value);
                    }
                }
                max[j-i][j] = maxValue;
                min[j-i][j] = minValue;
                
            }
        }
//         for(int i=0; i<length+1; i++) {
//             for(int j=0; j<length+1; j++) {
//                 System.out.print(max[i][j] + " ");
//             }
//             System.out.println(" ");
//         }
//         System.out.println("");
        
//         for(int i=0; i<length+1; i++) {
//             for(int j=0; j<length+1; j++) {
//                 System.out.print(min[i][j] + " ");
//             }
//             System.out.println(" ");
//         }
        
        answer = max[0][length];
		return answer;
	}
}