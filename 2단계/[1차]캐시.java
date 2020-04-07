import java.util.ArrayList;

class Solution {
  public int solution(int cacheSize, String[] cities) {
      int answer = 0;
      int num = 0;
      int n = cacheSize;
      ArrayList<String> cacheMemory = new ArrayList<String>();
      if(cacheSize==0){
          return cities.length * 5;
      }
      
      for(int i=0; i<cities.length; i++)
          cities[i] = cities[i].toLowerCase();
      
      while(num < cities.length){
          if(cacheMemory.size() < cacheSize){
              if(cacheMemory.contains(cities[num])){
                  cacheMemory.remove(cacheMemory.indexOf(cities[num]));
                  cacheMemory.add(cities[num]);
                  answer += 1;
              }
              else{
                  cacheMemory.add(cities[num]);
                  answer +=5;
              }
          }
          else{ //캐시가 꽉찼을 때
              if(cacheMemory.contains(cities[num])){
                cacheMemory.remove(cacheMemory.indexOf(cities[num]));
                cacheMemory.add(cities[num]);
                answer +=1;
              }
              else{
                cacheMemory.remove(0);
                cacheMemory.add(cities[num]);
                answer +=5;
              }
         }
          num++;
      }
      return answer;
  }
}