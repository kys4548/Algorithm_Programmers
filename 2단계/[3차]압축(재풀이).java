import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 1. 길이가 1인 모든 단어를 포함하도록 사전을 초기화한다.
 * 2. 사전에서 현재 입력과 일치하는 가장 긴 문자열 w를 찾는다.
 * 3. w에 해당하는 사전의 색인 번호를 출력하고, 입력에서 w를 제거한다.
 * 4. 입력에서 처리되지 않은 다음 글자가 남아있다면(c), w+c에 해당하는 단어를 사전에 등록한다.
 * 5. 단계 2로 돌아간다.
 *
 * 압축 알고리즘이 영문 대문자만 처리한다고 할 때, 사전은 다음과 같이 초기화된다.
 * 사전의 색인 번호는 정수값으로 주어지며, 1부터 시작한다고 하자.
 */

class Solution {
    Map<String, Integer> wordMap = new HashMap<>();
    int index = 1;
    boolean[] isFinish = null;
    List<Integer> list = new ArrayList<>();

    public int[] solution(String msg) {
        int[] answer = {};
        defaultSetting();
        isFinish = new boolean[msg.length()];

        for(int i=0; i<msg.length(); i++) {
            if (isFinish[i]) {
                continue;
            }
            dfs(msg, String.valueOf(msg.charAt(i)), i, msg.length());
        }

        answer = list.stream().mapToInt(i -> i).toArray();
        return answer;
    }

    private void dfs(String msg, String s, int i, int length) {
        isFinish[i] = true;
        if(i+1 < length) {
            if(wordMap.containsKey(s + msg.charAt(i+1))) {
                dfs(msg, s + msg.charAt(i+1), i+1, length);
            } else {
                list.add(wordMap.get(s));
                wordMap.put(s + msg.charAt(i+1), index++);
            }
        } else {
            list.add(wordMap.get(s));
        }
    }

    private void defaultSetting() {
        char word = 'A';
        for(int i=0; i<26; i++) {
            wordMap.put(String.valueOf(word), index++);
            word += 1;
        }
    }
}