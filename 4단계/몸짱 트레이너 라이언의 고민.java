import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.List;
import java.util.ArrayList;

// 1. 동시에 최대 몇명까지 겹치는지 구한다.
// 2. 동시에 1명이 최대라면 0을 리턴, 그 이상이라면 알고리즘 고민

class Solution {
  public int solution(int n, int m, int[][] timetable) {
      int answer = 0;
      
      Arrays.sort(timetable, new Comparator<int[]>() {
          @Override
          public int compare(int[] arr1, int[] arr2){
              return arr1[0] - arr2[0];
          }
      });
      
      int max = maxSize(m,timetable);
      if(max ==1) {
            return 0;
      }
      answer = minDistance(n, max);
      return answer;
  }
    public int minDistance(int n, int max) {
        int result = 0;
        int[] maxNum = new int[2*n -2];
        maxNum[0] = n*n;
        maxNum[1] = (n*n+1)/2;
        
        //모든 간격에 대해
        for(int i=2; i<2*n-2; i++) {
            
            //첫번째열 가운데까지
            for(int j=0; j<(n+1)/2; j++) {
                int[] arr = new int[2];
                arr[1] = j;
                List<int[]> list = new ArrayList<int[]>();
                list.add(arr);
                
                //모든 점에 대하여
                for(int k=0; k<n; k++) {
                    for(int l=0; l<n; l++) {
                        int count =0;
                        for(int[] temp : list) {
                            if( Math.abs(temp[0]-k) + Math.abs(temp[1]-l) < i+1 ) {
                                break;
                            }else {
                                count++;
                            }
                        }
                        if(count == list.size()) {
                            int[] temp = new int[2];
                            temp[0] = k;
                            temp[1] = l;
                            list.add(temp);
                        }
                    }
                }
                maxNum[i] = Math.max(maxNum[i], list.size());
            }
        }
        
        for(int i=0; i<maxNum.length; i++) {
            if(maxNum[i] >= max) {
                result++;
            }
            else {
                break;
            }
        }
        
        return result;
    }
    
    public int maxSize(int m, int[][] timetable) {
        int max =1;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int i=0; i<m; i++) {
          while(!pq.isEmpty() && pq.peek() < timetable[i][0]) {
              pq.poll();
          }
          pq.add(timetable[i][1]);
          if(max < pq.size()) {
              max = pq.size();
          }
      }
        
        return max;
    }
}