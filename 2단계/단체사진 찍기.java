class Solution {
    int count =0;
  public int solution(int n, String[] data) {
      int answer = 0;    
      char[] list = {'A','C','F','J','M','N','R','T'};
      int length = list.length;
      char[] output = new char[length];
      boolean[] visited = new boolean[length];
      
      answer = permutation(list, output, visited, length, 0, n, data);
      return answer;
  }
    public int permutation(char[] list, char[] output, boolean[] visited, int length, int cursor, int n, String[] data) {
        //base case
        if(cursor >= length) {
            String str = String.valueOf(output);
            for(int i=0; i<n; i++) {
                char c1 = data[i].charAt(0);
                char c2 = data[i].charAt(2);
                char operation = data[i].charAt(3);
                int diff = data[i].charAt(4) -'0';
                int distance = Math.abs(str.indexOf(c1) - str.indexOf(c2)) -1;
                
                if(operation == '=') {
                    if(distance != diff) {
                        return 0;
                    }
                }
                else if(operation == '>') {
                    if(distance <= diff) {
                        return 0;
                    }
                }
                else {
                    if(distance >= diff) {
                        return 0;
                    }
                }
            }
            return 1;
        }
        
        int result = 0;
        
        //재귀
        for(int i=0; i<length; i++) {
            if(visited[i] != true) {
                visited[i] = true;
                output[cursor] = list[i];
                result += permutation(list, output, visited, length, cursor+1, n, data);
                visited[i] = false;
            }
        }
        
        return result;
    }
}