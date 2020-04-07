import java.util.Arrays;
//다익스트라 알고리즘으로 해결하면 되겠군
class Solution {
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        final int INF = 999999999;
        int[][] maps = createMaps(N, road, INF);
        int[] d = createD(N, INF);
        boolean[] visit = new boolean[N];
        
        dijkstra(N, visit, d, maps, INF);
        
        for(int distance : d) {
            if(distance <= K) {
                answer ++;
            }
        }
        
        
        return answer;
    }
    public void dijkstra(int N, boolean[] visit, int[] d, int[][] maps, int INF) {
        
        int v = 0;
        d[0] = 0;
        visit[0] = true;
        
        for(int i=1; i<N; i++) {    
            for(int j=0; j<N; j++) {
                if(visit[j] == false && d[j] > d[v] + maps[v][j]) {
                    d[j] = d[v] + maps[v][j];
                }
            }
            
            int min = INF;
            for(int j=0; j<N; j++) {
                if(visit[j] == false &&  min > d[j]) {
                    min = d[j];
                    v = j;
                }
            }
            
            visit[v] = true;
        }
    }
    
    public int[] createD(int N, int INF) {
        int[] d = new int[N];
        Arrays.fill(d, INF);
        
        return d;
    }
    
    public int[][] createMaps(int N, int[][] road, int INF) {
        int[][] maps = new int[N][N];
        for(int i=0; i<N; i++) {
            Arrays.fill(maps[i], INF);
            maps[i][i] = 0;
        }
        
        for(int[] edge : road) {
            int v1 = edge[0] -1;
            int v2 = edge[1] -1;
            int distance = edge[2];
            
            if(maps[v1][v2] > distance) {
                maps[v1][v2] = distance;
                maps[v2][v1] = distance;
            }
        }
        return maps;
    }
}