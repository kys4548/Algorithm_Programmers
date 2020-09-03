import java.util.*;
import java.util.stream.Collectors;

class Main {
    public static void main(String[] args) {
        String[] gems = {"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"};
        System.out.println(new Solution().solution(gems));
    }
}

class Solution {
    public int[] solution(String[] gems) {
        int[] answer = new int[2];
        Set<String> gemKinds = Arrays.stream(gems).collect(Collectors.toSet());
        Set<String> currentKinds = new HashSet<>();
        Map<String, Integer> map = new HashMap<>();
        List<int[]> answerList = new ArrayList<>();

        int startIndex = 0;
        for(int i=0; i<gems.length; i++) {
            map.put(gems[i], map.getOrDefault(gems[i], 0) + 1);
            currentKinds.add(gems[i]);

            if(currentKinds.size() == gemKinds.size()) {
                while (map.get(gems[startIndex]) > 1) {
                    map.put(gems[startIndex], map.get(gems[startIndex])  -1);
                    startIndex++;
                }
                answerList.add(new int[]{i - startIndex, startIndex+1, i+1});
                map.put(gems[startIndex], 0);
                currentKinds.remove(gems[startIndex]);
                startIndex++;
            }
        }

//        map.clear();
//        currentKinds.clear();
//        int endIndex = gems.length-1;
//        for(int i=gems.length-1; i>=0; i--) {
//            map.put(gems[i], map.getOrDefault(gems[i], 0) + 1);
//            currentKinds.add(gems[i]);
//
//            if(currentKinds.size() == gemKinds.size()) {
//                while (map.get(gems[endIndex]) > 1) {
//                    map.put(gems[endIndex], map.get(gems[endIndex])  -1);
//                    endIndex--;
//                }
//                answerList.add(new int[]{endIndex - i, i+1, endIndex+1});
//                map.put(gems[endIndex], 0);
//                currentKinds.remove(gems[endIndex]);
//                endIndex--;
//            }
//        };

        answerList.sort((arr1, arr2) -> {
            if(arr1[0] == arr2[0]) {
                return arr1[1] - arr2[1];
            }
            return arr1[0] - arr2[0];
        });

        answer[0] = answerList.get(0)[1];
        answer[1] = answerList.get(0)[2];

        return answer;
    }
}