import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

//요청이 들어오면 소요시간이 적은것이 우선순위를 가진다.
class Solution {
    public int solution(int[][] jobs) {
        int answer = 0; 
        int second = 0; // 현재 시점
        int count = 0;
        int[] arr = new int[jobs.length]; // 각 작업의 요청부터 종료까지 걸린시간
        ArrayList<int[]> list = new ArrayList<int[]>(); // 현재 요청 받은 작업들
        ArrayList<int[]> job = new ArrayList<int[]>(); //작업들을 배열에서 리스트로 바꾼다.
        
        for(int[] temptemp : jobs){
            job.add(temptemp);
        }
        
        //요청 리스트 시간순 정렬
        Collections.sort(job, new Comparator<int[]>(){
           @Override
            public int compare(int[] a, int[] b){
                if(a[0] != b[0])
                    return a[0] - b[0];
                else{
                    return a[1] - b[1];
                }
            }
        });
        
        
        while(count < jobs.length){
            int[] temp;
        //현재 진행할 작업이 없는 경우
            if(list.isEmpty()){
                temp = job.remove(0);
                second = temp[0] + temp[1];
                arr[count++] = temp[1];
            
            }
        //현재 진행할 작업이 있는 경우
            else{
                temp = list.remove(0);
                arr[count++] = second - temp[0] + temp[1];
                second += temp[1];
            }
            
            while(!job.isEmpty()){
                    temp = job.get(0);
                    if(temp[0] > second)
                        break;
                    else{
                        list.add(temp);
                        job.remove(0);
                    }
                }
            
            Collections.sort(list, new Comparator<int[]>(){
               @Override
                public int compare(int[] a, int[] b){
                    return a[1] - b[1];
                }
            });
            
        }
        
        for(int n : arr)
            answer += n;
        answer /= jobs.length;
        
        
        return answer;
    }
}