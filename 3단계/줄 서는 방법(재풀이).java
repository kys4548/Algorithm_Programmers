import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Solution {
    public int[] solution(int n, long k) {
        int[] answer = new int[n];
        List<Integer> list = IntStream.range(1, n+1).boxed().collect(Collectors.toList());
        k--;
        long[] divide = new long[n];
        divide[1] = 1;

        for(int i=2; i<n; i++) {
            divide[i] = divide[i-1] *i;
        }

        for(int i=0; i<n-1; i++) {
            answer[i] = list.remove((int)(k / divide[n-i-1]));
            k %= divide[n-i-1];
        }
        answer[n-1] = list.remove(0);

        return answer;
    }
}