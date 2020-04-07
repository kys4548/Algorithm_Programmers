import java.util.Arrays;

class Solution {
    int min = 9;
    
    public int solution(int n, int[] weak, int[] dist) {
        int distLen = dist.length;
        int weakLen = weak.length;
        Arrays.sort(dist);
        int[] arr = new int[distLen];
        boolean[] visited = new boolean[distLen];
        arr[0] = dist[distLen-1];
        visited[distLen-1] = true;
        
        for(int i=0; i<weakLen; i++) {
            permutation(dist, arr, weak, visited, distLen, 1);
            changeWeak(weak, weakLen, n);
        }
        if(min == 9){
            min = -1;
        }
        
        return min;
    }
    
    public void changeWeak(int[] weak, int weakLen, int n) {
        int temp = weak[0];
        for(int i=1; i<weakLen; i++) {
            weak[i-1] = weak[i];
        }
        weak[weakLen-1] = temp + n;
    }
    
    public void permutation(int[] dist, int[] arr, int[] weak, boolean[] visited, int n, int depth) {
        if(depth == n) {
            inspectWall(arr, weak, n);
            return;
        }
        
        for(int i=n-2; i>=0; i--) {
            if(visited[i] != true) {
                visited[i] = true;
                arr[depth] = dist[i];
                permutation(dist, arr, weak, visited, n, depth+1);
                visited[i] = false;
            }
        }
    }
    
    public void inspectWall(int[] arr, int[] weak, int n) {
        int arrIndex = 0;
        int weakIndex = 0;
        int result = 0;
        
        int value = -1;
        while(arrIndex < arr.length && weakIndex < weak.length) {
            if(value < weak[weakIndex]) {
                value = weak[weakIndex] + arr[arrIndex];
                arrIndex++;
                result++;
            }
            else {
                weakIndex++;
            }
        }
        if(value >= weak[weak.length-1] && min > result) {
            min = result;
        }
        
    }
    
    // public void print(int n, int[] arr) {
    //     for(int i=0; i<n; i++) {
    //         System.out.print(arr[i]+ " ");
    //     }
    //     System.out.println();
    // }
}