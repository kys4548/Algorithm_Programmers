// 문제가 개편 되었습니다. 이로 인해 함수 구성이 변경되어, 과거의 코드는 동작하지 않을 수 있습니다.
// 새로운 함수 구성을 적용하려면 [코드 초기화] 버튼을 누르세요. 단, [코드 초기화] 버튼을 누르면 작성 중인 코드는 사라집니다.
class Solution {
    public int[] solution(int brown, int red) {
        int[] answer = new int[2];
        int area = brown + red;
        
        int a,b;
        
        for(int i=1; i<= Math.sqrt(area); i++){
            if(area % i ==0){
                b = i;
                a = area / i;
                if((a-2)*(b-2)==red){
                    answer[0] = a;
                    answer[1] = b;
                    break;
                }
            }
        }
        
        
        return answer;
    }
}