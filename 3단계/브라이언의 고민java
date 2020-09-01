import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solution("HaEaLaLaObWORLDb");
    }
}

class Solution {
    Map<Character, Integer> map = new HashMap<>();
    Set<Character> set = new HashSet<>();

    public String solution(String sentence) {
        String answer = "";
        char c1 = ' ';
        char c2 = ' ';
        for(int i=0; i<sentence.length(); i++) {
            c1 = sentence.charAt(i);
            if(c1 >='a' && c1 <='z') {
                map.put(c1, map.getOrDefault(c1, 0) + 1);
            }
        }

        StringBuilder sb = new StringBuilder();
        int index = 0;
        while(index < sentence.length()) {
            c1 = sentence.charAt(index);

            //c1이 마지막 문자일 경우
            if(index == sentence.length()-1) {
                if(c1 >= 'A' && c1 <= 'Z') {
                    sb.append(c1);
                    break;
                } else {
                    return "invalid";
                }
            }

            index++;
            c2 = sentence.charAt(index);

            //c2가 마지막 문자일 경우
            if(index == sentence.length()-1) {
                if(c1 >= 'A' && c1 <= 'Z' && c2 >= 'A' && c2 <= 'Z') {
                    sb.append(c1+ " " + c2);
                    break;
                } else {
                    return "invalid";
                }
            }

            if(c1 >='A' && c1 <= 'Z') {
                if(c2 >= 'A' && c2 <= 'Z') {
                    sb.append(c1+ " ");
                    continue;
                } else {
                    if(set.contains(c2)) {
                        return "invalid";
                    }
                    if(map.get(c2) == 2) {
                        sb.append(c1+ " ");
                        continue;
                    } else {
                        int lastIndex = sentence.lastIndexOf(c2)+1;
                        if(lastIndex == sentence.length() || !setRule1(sentence.substring(index-1,lastIndex+1), sb, c2)) {
                            return "invalid";
                        }
                        set.add(c2);
                        index = lastIndex;
                    }
                }
            } else {
                if(set.contains(c1) || map.get(c1) != 2 || c2 >= 'a' && c2 <= 'z') {
                    return "invalid";
                }
                set.add(c1);
                int lastIndex = sentence.lastIndexOf(c1);
                if(!setRule2(sentence.substring(index, lastIndex), sb)) {
                    return "invalid";
                }
                index = lastIndex;
            }
            index++;
        }
        answer = sb.toString().trim();
        return answer;
    }

    private boolean setRule2(String s, StringBuilder sb) {
        if(s.length() == 1) {
            sb.append(s+ " ");
            return true;
        }
        boolean isSuccess = true;
        char c = s.charAt(1);
        if(c >= 'A' && c <= 'Z') {
            for(int i=0; i<s.length(); i++) {
                c = s.charAt(i);
                if(c >= 'A' && c <= 'Z') {
                    sb.append(c);
                } else {
                    return false;
                }
            }
            sb.append(" ");
        } else {
            isSuccess = setRule1(s, sb, c);
            if(isSuccess) {
                set.add(c);
            }
        }
        return isSuccess;
    }

    private boolean setRule1(String s, StringBuilder sb, char c) {
        char c1 = ' ';
        for(int i=0; i<s.length(); i++) {
            c1 = s.charAt(i);
            if(i % 2 == 0) {
                if(c1 >= 'A' && c1 <= 'Z') {
                    sb.append(c1);
                } else {
                    return false;
                }
            } else {
                if(c1 != c) {
                    return false;
                }
            }
        }
        sb.append(" ");
        return true;
    }
}