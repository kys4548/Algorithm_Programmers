class Solution {
    public boolean solution(int[][] key, int[][] lock) {
        boolean answer = true;
        
        int M = key.length;
        int N = lock.length;
        int lockLength = N + 2*M - 2;
        int[][] lockValue = new int[lockLength][lockLength];
        
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                lockValue[M+i-1][M+j-1] = lock[i][j];
            }
        }    
        int[][][] keys = new int[4][M][M];
        keys[0] = key;
        
        for(int i=1; i<4; i++) {
            int[][] currentKey = keys[i-1];
            int[][] rotationKey = new int[M][M];
            
            for(int row=0; row<M; row++) {
                for(int col=0; col<M; col++) {
                    rotationKey[row][col] = currentKey[M -1 - col][row];
                }
            }
            keys[i] = rotationKey;
        }
        
        //System.out.println("Lock");
        //printShape(lockValue, lockLength);
        //for(int i=0; i<4; i++) {
        //    System.out.println("Key"+(i+1));
        //    printShape(keys[i],M);
        //}
        
        answer = findKey(keys, M, N, lockValue, lockLength);
        
        return answer;
    }
    
    public boolean findKey(int[][][] keys, int M, int N, int[][] lockValue, int lockLength) {
        boolean result = false;
        int length = lockLength - M;
        int count =0;
        
        for(int k=0; k<4; k++) {
            int[][] currentKey = keys[k];
            
            for(int row=0; row<=length; row++) {
                for(int col=0; col<=length; col++) {
                    
                    for(int subRow=row; subRow<row+M; subRow++) {
                        for(int subCol=col; subCol<col+M; subCol++) {
                            if(subRow >= M-1 && subRow <M+N && subCol >=M-1 && subCol <M+N) {
                                lockValue[subRow][subCol] += currentKey[subRow-row][subCol-col];
                            }
                        }
                    }
                    
                    if(checkKey(lockValue, M, N) == true) {
                        return true;
                    }
                    
                    for(int subRow=row; subRow<row+M; subRow++) {
                        for(int subCol=col; subCol<col+M; subCol++) {
                            if(subRow >= M-1 && subRow <M+N && subCol >=M-1 && subCol <M+N) {
                                lockValue[subRow][subCol] -= currentKey[subRow-row][subCol-col];
                            }
                        }
                    }
                }
            }
        }
        return result;
    }
    
    public boolean checkKey(int[][] lockValue, int M, int N) {
        boolean result =true;
        for(int row = M-1; row< M+N-1; row++) {
            for(int col=M-1; col <M+N-1; col++) {
                if(lockValue[row][col] != 1) {
                    return false;
                }
            }
        }
        //printShape(lockValue, N + 2*M - 2);
        
        return result;
    } 
    
    public void printShape(int[][] shape, int length) {
         for(int i=0; i<length; i++) {
            for(int j=0; j<length; j++) {
                System.out.print(shape[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}