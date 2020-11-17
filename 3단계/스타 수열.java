import java.util.*;

class Main {
    public static void main(String[] args) {
        final Solution solution = new Solution();
        int[] a = {0,3,3,0,7,2,0,2,2,0};
        solution.solution(a);
    }
}

class Solution {
    public int solution(int[] a) {
        int answer = 0;
        List<Number> list = new ArrayList<>();
        Map<Integer, Number> map = new HashMap<>();

        for(int i=0; i<a.length; i++) {
            if(!map.containsKey(a[i])) {
                Number number = new Number(a[i]);
                map.put(a[i], number);
                list.add(number);
            }
            map.get(a[i]).count++;
        }
        Collections.sort(list);

        for(int i=0; i<list.size(); i++) {
            Number number = list.get(i);
            int count = number.count;
            if(answer >= count) {
                break;
            }
            boolean[] isUsed = new boolean[a.length];
            for(int j=0; j<a.length; j++) {
                if(a[j] != number.num) {
                    continue;
                }
                if(j>0 && a[j-1] != number.num && !isUsed[j-1]) {
                    isUsed[j-1] = true;
                    continue;
                }
                if(j<a.length-1 && a[j+1] != number.num && !isUsed[j+1]) {
                    isUsed[j+1] = true;
                    continue;
                }
                number.count--;
            }
            answer = Math.max(answer, number.count);
        }

        return answer * 2;
    }
}

class Number implements Comparable<Number> {
    int num;
    int count;

    public Number(int num) {
        this.num = num;
    }

    @Override
    public int compareTo(Number number) {
        return number.count - this.count;
    }
}