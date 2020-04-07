import java.util.*;

class Solution {
	public int solution(int[][] maps) {
		int answer = 0;
        int n = maps.length;
        int m = maps[0].length;
        int[][] visit = new int[n][m]; // [0,0]에서의 최소 거리
        int[][] toWhere = {{1,0}, {0,1}, {-1,0}, {0,-1}}; //오른, 아래, 왼, 위
        List<int[]> list = new LinkedList<int[]>();
        boolean find = false;
        
        int[] arr = {0,0};
        visit[arr[0]][arr[1]] = 1;
        list.add(arr);
        
        while(!list.isEmpty()) {
            if(find == true)
                break;
            
            int[] temp = list.remove(0);
            
            for(int i=0; i<4; i++) {
                int x = temp[0] + toWhere[i][0];
                int y = temp[1] + toWhere[i][1];
                if(x <0 || y <0 || x>= n || y >=m || visit[x][y] >0 || maps[x][y] ==0) {
                    continue;
                }
                visit[x][y] = visit[temp[0]][temp[1]] + 1;
                int[] t = {x, y};
                list.add(t);
                if(x == n-1 && y == m-1) {
                    find = true;
                }
                
            }
        }
        answer = visit[n-1][m-1] > 0 ? visit[n-1][m-1] : -1;
		return answer;
	}
}