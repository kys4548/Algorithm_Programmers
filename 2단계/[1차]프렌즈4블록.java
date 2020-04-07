import java.util.ArrayList;

class Solution {
  public int solution(int m, int n, String[] board) {
      int answer = 0;
      char[][] arr = new char[m][n];
      ArrayList<String> al = new ArrayList<String>();
      
      for(int i=0; i<m; i++){
          String s = board[i];
          for(int j=0; j<n; j++){
              arr[i][j] = s.charAt(j);
          }
      }
      
      int count = -1;
      
      while(count != 0){
          count = 0;
          for(int i=0; i<m-1; i++){
              for(int j=0; j<n-1; j++){
                  char c1 = arr[i][j];
                  if(c1=='1')
                      continue;
                  char c2 = arr[i][j+1];
                  char c3 = arr[i+1][j];
                  char c4 = arr[i+1][j+1];
                  
                  if(c1==c2 && c2==c3 && c3==c4){
                      al.add(i+" "+j);
                  }
              }
          }
          count = al.size();
          while(!al.isEmpty()){
              String s1 = al.remove(0);
              String[] s2 = s1.split(" ");
              int a = Integer.parseInt(s2[0]);
              int b = Integer.parseInt(s2[1]);
              if(arr[a][b]!='0'){
                  arr[a][b] = '0';
                  answer++;
              }
              if(arr[a][b+1]!='0'){
                  arr[a][b+1] = '0';
                  answer++;
              }
              if(arr[a+1][b]!='0'){
                  arr[a+1][b] = '0';
                  answer++;
              }
              if(arr[a+1][b+1]!='0'){
                  arr[a+1][b+1] = '0';
                  answer++;
              }
          }
          for(int i=m-1; i>0; i--){
              for(int j=n-1; j>=0; j--){
                  if(arr[i][j]=='0'){
                      while(arr[i][j]=='0'){
                          for(int k=i; k>0; k--){
                          arr[k][j] = arr[k-1][j];
                          }
                          arr[0][j] ='1';
                      }
                  }
              }
          }
      }
      return answer;
  }
}