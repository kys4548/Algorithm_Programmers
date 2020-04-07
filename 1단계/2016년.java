class Solution {
    public String solution(int a, int b) {

        int[] month = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        String[] day = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};
        int count = 5;

        for(int i=0; i<a - 1; i++){
            count += month[i];
        }
        count += b -1 ;
        count %= 7;
        return day[count];
    }
}