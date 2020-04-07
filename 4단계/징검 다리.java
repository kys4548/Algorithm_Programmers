// 문제가 개편 되었습니다. 이로 인해 함수 구성이 변경되어, 과거의 코드는 동작하지 않을 수 있습니다.
// 새로운 함수 구성을 적용하려면 [코드 초기화] 버튼을 누르세요. 단, [코드 초기화] 버튼을 누르면 작성 중인 코드는 사라집니다.
import java.util.Arrays;

class Solution {
    public int solution(int distance, int[] rocks, int n) {
        int answer = 0;
        int length = rocks.length;
        if(length == n) {
            return distance;
        }
        Arrays.sort(rocks);
        int[] arr = new int[length+1];
        
        arr[0] = rocks[0];
        for(int i=1; i<length; i++) {
            arr[i] = rocks[i] - rocks[i-1];
        }
        arr[length] = distance - rocks[length-1];
        
        int max = distance / (length +1 -n);
        int min = 1;
        
        while(min <= max) {
            int mid = (min + max) /2;
            int count = 0;
            for(int i=0; i<=length; i++) {
                if(arr[i] < mid) {
                    int sum = arr[i];
                    count++;
                    i++;
                    while(i<= length && sum + arr[i] < mid) {
                        sum +=arr[i];
                        count++;
                        i++;
                    }
                }
            }
            if(count <= n) {
                min = mid+1;
            }
            else {
                max = mid-1;
            }
        }
        answer = max;
        return answer;
    }
}