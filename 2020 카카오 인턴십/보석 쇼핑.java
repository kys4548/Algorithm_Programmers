import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        int[] answer = new int[2];
        Map<String, Integer> map = new HashMap<>();
        Set<String> set = new HashSet<>(Arrays.asList(gems));
        
        int start = 0;
        int end = 0;
        int diff = Integer.MAX_VALUE;

        for(int i=0; i<gems.length; i++) {
            map.put(gems[i], map.getOrDefault(gems[i], 0) + 1);
            end++;
            if(map.size() == set.size()) {
                for(int j=start; j<end; j++) {
                    start++;
                    if(map.get(gems[j]) == 1) {
                        map.remove(gems[j]);
                        break;
                    }
                    map.put(gems[j], map.get(gems[j]) -1);
                }
                int tempDiff = end - start;
                if(diff > tempDiff) {
                    answer[0] = start;
                    answer[1] = end;
                    diff = tempDiff;
                }
            }
        }
        return answer;
    }
}