import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

class Solution {
    final int INF = 999999999;
    int[][] area = null;


    public int solution(int[][] land, int height) {
        int answer = 0;
        int n = land.length;
        area = new int[n][n];

        //land -> area 각 칸의 색을 나타내도록 변환 후 갯수 반환
        int colorCount = findArea(land, height, n);

        // 인접한 vertex의 edgeList 생성
        List<Edge>[] list = createEdgeList(land, n, colorCount);

        //모든 점을 한번씩 지나는데 필요한 비용
        answer = createDistance(colorCount, list);

        return answer;
    }

    private int createDistance(int colorCount, List<Edge>[] list) {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        boolean[] visited = new boolean[colorCount];
        pq.add(new Edge(0 ,0 ,0));
        int result = 0;

        while(!pq.isEmpty()) {
            Edge edge = pq.poll();
            if(visited[edge.endVertex]) {
                continue;
            }
            result += edge.distance;
            visited[edge.endVertex] = true;
            for (Edge nextEdge : list[edge.endVertex]) {
                pq.add(nextEdge);
            }
        }

        return result;
    }

    private List<Edge>[] createEdgeList(int[][] land, int n, int colorCount) {
        List<Edge>[] edgeList = new ArrayList[colorCount];
        for(int i=0; i<colorCount; i++) {
            edgeList[i] = new ArrayList<>();
        }

        int v1 = -1;
        int v2 = -1;
        int distance = -1;
        for(int i=0; i<n-1; i++) {
            for(int j=0; j<n-1; j++) {
                v1 = area[i][j];
                v2 = area[i][j + 1];
                if(v1 != v2) {
                    distance = Math.abs(land[i][j] - land[i][j + 1]);
                    edgeList[v1].add(new Edge(v1, v2, distance));
                    edgeList[v2].add(new Edge(v2, v1, distance));
                }

                v2 = area[i + 1][j];
                if(v1 != v2) {
                    distance = Math.abs(land[i][j] - land[i + 1][j]);
                    edgeList[v1].add(new Edge(v1, v2, distance));
                    edgeList[v2].add(new Edge(v2, v1, distance));
                }
            }
        }

        for(int i=0; i<n-1; i++) {
            v1 = area[n - 1][i];
            v2 = area[n - 1][i + 1];
            if(v1 != v2) {
                distance = Math.abs(land[n - 1][i] - land[n - 1][i + 1]);
                edgeList[v1].add(new Edge(v1, v2, distance));
                edgeList[v2].add(new Edge(v2, v1, distance));
            }

            v1 = area[i][n - 1];
            v2 = area[i + 1][n - 1];
            if(v1 != v2) {
                distance = Math.abs(land[i][n - 1] - land[i + 1][n - 1]);
                edgeList[v1].add(new Edge(v1, v2, distance));
                edgeList[v2].add(new Edge(v2, v1, distance));
            }
        }
        return edgeList;
    }

    //영역을 나누고 영역의 갯수를 반환
    private int findArea(int[][] land, int height, int n) {
        boolean[][] visited = new boolean[n][n];

        int color = 0;
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(visited[i][j]) {
                    continue;
                }
                //재귀함수 호출
                solve(visited, land, i, j, n, height, land[i][j], color);
                color++;
            }
        }
        return color;
    }

    private void printArea(int[][] arr) {
        for(int i=0; i<arr.length; i++) {
            for(int j=0; j<arr[0].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    private void solve(boolean[][] visited, int[][] land, int a, int b, int n, int height, int value, int color) {
        if(a < 0 || a >= n || b < 0 || b >= n|| visited[a][b] || Math.abs(land[a][b] - value) > height) {
            return;
        }
        area[a][b] = color;
        visited[a][b] = true;

        solve(visited, land, a-1, b, n, height, land[a][b], color);
        solve(visited, land, a+1, b, n, height, land[a][b], color);
        solve(visited, land, a, b-1, n, height, land[a][b], color);
        solve(visited, land, a, b+1, n, height, land[a][b], color);

    }
}

class Edge implements Comparable<Edge> {
    int startVertex;
    int endVertex;
    int distance;

    public Edge(int startVertex, int endVertex, int distance) {
        this.startVertex = startVertex;
        this.endVertex = endVertex;
        this.distance = distance;
    }

    @Override
    public int compareTo(Edge edge) {
        return this.distance - edge.distance;
    }
}