//인접한 두 풍선 중에서 번호가 더 작은 풍선을 터트리는 행위는 최대 1번만 할 수 있습니다
//행위를 하지 않으면 항상 가장 작은게 남는다.

//최종적으로 가장 작은숫자와 구하고 싶은 숫자만 남는다.

import java.util.Arrays;

class Solution {
    public int solution(int[] a) {
        int answer = 0;
        int[] leftMin = new int[a.length];
        int[] rightMin = new int[a.length];

        int min = Integer.MAX_VALUE;

        for (int i = 0; i < a.length; i++) {
            min = Math.min(min, a[i]);
            leftMin[i] = min;
        }

        min = Integer.MAX_VALUE;
        for(int i=a.length-1; i>=0; i--) {
            min = Math.min(min, a[i]);
            rightMin[i] = min;
        }

        for(int i=0; i<a.length; i++) {
            if(leftMin[i] < a[i] && rightMin[i] < a[i]) {
                continue;
            }
            answer++;
        }
        return answer;
    }
}