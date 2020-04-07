import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[][] solution(int n, int[][] build_frame) {
        boolean[][] piller = new boolean[n+3][n+3];
        boolean[][] bo = new boolean[n+3][n+3];
        int length = build_frame.length;
        
        for(int i=0; i<length; i++) {
            int[] arr = build_frame[i];
            int a = arr[0] +1;
            int b = arr[1] +1;
            
            //기둥
            if(arr[2] == 0) {
                //삭제
                if(arr[3] == 0) {
                    if(pillerRemoveCheck(a, b, piller, bo) == true) {
                        piller[a][b] = false;
                    }
                }
                //설치
                else {
                    if(b == 1 || piller[a][b-1] == true || bo[a-1][b] == true || bo[a][b] == true ) {
                        piller[a][b] = true;
                    }
                }
            }
            //보
            else {
                //삭제
                if(arr[3] == 0) {
                    if(boRemoveCheck(a, b, piller, bo) == true) {
                        bo[a][b] = false;
                    }
                }
                //설치
                else {
                    if(piller[a][b-1] == true || piller[a+1][b-1] == true || (bo[a-1][b] == true && bo[a+1][b] == true) ) {
                        bo[a][b] = true;
                    }
                }
            }
        }
        
        
        List<int[]> list = createList(piller, bo, n);
        int len = list.size();
        int[][] answer = new int[len][3];
        
        for(int i=0; i<len; i++) {
            answer[i] = list.get(i);
        }
        
        return answer;
    }
    public boolean boRemoveCheck(int a, int b, boolean[][] piller, boolean[][] bo) {
        boolean result = true;
        
        if(piller[a][b] == true && piller[a][b-1] == false && bo[a-1][b] == false) {
            return false;
        }
        
        if(piller[a+1][b] == true && piller[a+1][b-1] == false && bo[a+1][b] == false) {
            return false;
        }
        
        if(bo[a-1][b] == true && piller[a-1][b-1] == false && piller[a][b-1] == false) {
            return false;
        }
        if(bo[a+1][b] == true && piller[a+1][b-1] == false && piller[a+2][b-1] == false) {
            return false;
        }
        
        return result;
    }
    
    public boolean pillerRemoveCheck(int a, int b, boolean[][] piller, boolean[][] bo) {
        boolean result = true;
        if(piller[a][b+1] == true && bo[a-1][b+1] == false && bo[a][b+1] == false) {
            return false;
        }
        if(bo[a-1][b+1] == true) {
            if(piller[a-1][b] == false && !(bo[a-2][b+1] ==true && bo[a][b+1] == true) ) {
                return false;
            }
        }
        if(bo[a][b+1] == true) {
            if(piller[a+1][b] == false && !(bo[a-1][b+1] == true && bo[a+1][b+1] == true) ) {
                return false;
            }
        }
        
        return result;
    }
    
    public List<int[]> createList(boolean[][] piller, boolean[][] bo, int n) {
        List<int[]> list =  new ArrayList<int[]>();
        
        for(int i=1; i<n+2; i++) {
            for(int j=1; j<n+2; j++) {
                if(piller[i][j] == true) {
                    int[] temp = new int[3];
                    temp[0] = i-1;
                    temp[1] = j-1;
                    temp[2] = 0;
                    list.add(temp);
                }
                if(bo[i][j] == true) {
                    int[] temp = new int[3];
                    temp[0] = i-1;
                    temp[1] = j-1;
                    temp[2] = 1;
                    list.add(temp);
                }
            }
        }
        return list;
    }
}