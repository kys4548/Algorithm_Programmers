import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Solution {
    List<String> list = new ArrayList<>();
    char[] people = {'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};
    boolean[] visited = new boolean[8];

    public int solution(int n, String[] data) {
        int answer = 0;
        dfs("", 0, 8);

        Stream<String> stream = list.stream();

        for(int i=0; i<data.length; i++) {
            char p1 = data[i].charAt(0);
            char p2 = data[i].charAt(2);
            char operation = data[i].charAt(3);
            int distance = data[i].charAt(4) - '0' + 1;

            if(operation == '=') {
                stream = stream.filter(s -> {
                    return Math.abs(s.indexOf(p1) - s.indexOf(p2)) == distance;
                });
            } else if(operation == '>') {
                stream = stream.filter(s -> {
                    return Math.abs(s.indexOf(p1) - s.indexOf(p2)) > distance;
                });
            } else if(operation == '<') {
                stream = stream.filter(s -> {
                    return Math.abs(s.indexOf(p1) - s.indexOf(p2)) < distance;
                });
            }
        }
        answer = (int) stream.count();
        return answer;
    }

    private void dfs(String s, int count, int max) {
        if(count == max) {
            list.add(s);
            return;
        }
        for(int i=0; i<8; i++) {
            if(!visited[i]) {
                visited[i] = true;
                dfs(s + people[i], count+1, max);
                visited[i] = false;
            }
        }
    }
}