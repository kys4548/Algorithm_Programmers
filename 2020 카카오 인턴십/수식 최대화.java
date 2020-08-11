import java.util.*;

class Solution {
    public long solution(String expression) {
        long answer = 0;
        
        String subfix = toSubfix(expression, '*', '+', '-');
        answer = Math.max(answer , solve(subfix));
        subfix = toSubfix(expression, '*', '-', '+');
        answer = Math.max(answer , solve(subfix));
        subfix = toSubfix(expression, '+', '*', '-');
        answer = Math.max(answer , solve(subfix));
        subfix = toSubfix(expression, '+', '-', '*');
        answer = Math.max(answer , solve(subfix));
        subfix = toSubfix(expression, '-', '+', '*');
        answer = Math.max(answer , solve(subfix));
        subfix = toSubfix(expression, '-', '*', '+');
        answer = Math.max(answer , solve(subfix));
        return answer;
    }
    
    public static Long solve(String subfix) {
        List<String> list = new ArrayList<>(Arrays.asList(subfix.split(" ")));
        int idx = 0;
        
        while(list.size() != 1) {
            if(list.get(idx).equals("*")) {
                String result = String.valueOf(Long.parseLong(list.remove(idx-2)) * Long.parseLong(list.remove(idx-2)));
                list.remove(idx-2);
                list.add(idx-2, result);
                idx -= 2;
            } else if(list.get(idx).equals("+")) {
                String result = String.valueOf(Long.parseLong(list.remove(idx-2)) + Long.parseLong(list.remove(idx-2)));
                list.remove(idx-2);
                list.add(idx-2, result);
                idx -= 2;
            } else if(list.get(idx).equals("-")) {
                String result = String.valueOf(Long.parseLong(list.remove(idx-2)) - Long.parseLong(list.remove(idx-2)));
                list.remove(idx-2);
                list.add(idx-2, result);
                idx -= 2;
            }
            idx++;
        }
        return Math.abs(Long.parseLong(list.get(0)));
    }
    
    public static String toSubfix(String expression, char first, char second, char third) {
        StringBuilder sb = new StringBuilder();
        List<Character> stack = new ArrayList<>();
        int length = expression.length();
        
        for(int i=0; i<length; i++) {
            char c = expression.charAt(i);
            if(c >= '0' && c <= '9') {
                sb.append(c);
                continue;
            }
            sb.append(" ");
            
            if(c == first) {
                while(!stack.isEmpty() && stack.get(stack.size()-1) == first) {
                    sb.append(stack.remove(stack.size()-1)).append(" ");
                }
            }
            
            if (c == second) {
                while(!stack.isEmpty() && stack.get(stack.size() -1) != third) {
                    sb.append(stack.remove(stack.size()-1)).append(" ");
                }
            } else if(c == third) {
                while(!stack.isEmpty()) {
                    sb.append(stack.remove(stack.size()-1)).append(" ");
                }
            }
            stack.add(c);
        }
        while(!stack.isEmpty()) {
            sb.append(" ").append(stack.remove(stack.size()-1));
        }
        return sb.toString();
    }
}