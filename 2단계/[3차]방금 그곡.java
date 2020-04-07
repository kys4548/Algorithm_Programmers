class Solution {
    public String solution(String m, String[] musicinfos) {
        String answer = "";
        int time =0;
        //m변환하기
        m = m.replace("C#","1");
        m = m.replace("D#","2");
        m = m.replace("F#","3");
        m = m.replace("G#","4");
        m = m.replace("A#","5");
        
        for(int i=0; i<musicinfos.length; i++){
            String[] arr = musicinfos[i].split(",");
            int tempTime = setTime(arr[0],arr[1]);
            //악보 변환하기
            arr[3] = arr[3].replace("C#","1");
            arr[3] = arr[3].replace("D#","2");
            arr[3] = arr[3].replace("F#","3");
            arr[3] = arr[3].replace("G#","4");
            arr[3] = arr[3].replace("A#","5");
            
            StringBuilder sb = new StringBuilder();
            while(sb.length() < tempTime)
                sb.append(arr[3]);
            String s = sb.toString().substring(0,tempTime);
            System.out.println(s);
            if(s.contains(m) && tempTime > time){
                answer = arr[2];
                time = tempTime;
            }
          
        }
        if(answer.equals(""))
            answer ="(None)";
        return answer;
    }
      //시간 정수형태로 구하기
      public int setTime(String s1, String s2){
          String[] start = s1.split(":");
          String[] end = s2.split(":");
          
          int[] time1 = new int[2];
          int[] time2 = new int[2];
          
          for(int i=0; i<2; i++){
              time1[i] = Integer.parseInt(start[i]);
              time2[i] = Integer.parseInt(end[i]);
          }
          
          return (time2[0] -time1[0]) * 60 + time2[1] - time1[1];
      }
  }