class Solution {
    public String solution(int[] numbers, String hand) {
        String answer = "";
        boolean isLeftHanded = false;
        
        if(hand.equals("left")) {
            isLeftHanded = true;
        }
        
        StringBuilder sb = new StringBuilder();
        
        int[] leftHandPosition = new int[2];
        int[] rightHandPosition = new int[2];
        
        leftHandPosition[0] = 3;
        leftHandPosition[1] = 0;
        rightHandPosition[0] = 3;
        rightHandPosition[1] = 2;
        
        for(int number : numbers) {
            int[] numberPosition = new int[2];
            if(number == 0) {
                numberPosition[0] = 3;
                numberPosition[1] = 1;
            } else {
                numberPosition[0] = (number-1) / 3;
                numberPosition[1] = (number-1) % 3;
            }
            
            if(numberPosition[1] == 0) {
                leftHandPosition[0] = numberPosition[0];
                leftHandPosition[1] = numberPosition[1];
                sb.append("L");
                continue;
            }
            
            if(numberPosition[1] == 2) {
                rightHandPosition[0] = numberPosition[0];
                rightHandPosition[1] = numberPosition[1];
                sb.append("R");
                continue;
            }
            
            int leftHandDif = Math.abs(leftHandPosition[0] - numberPosition[0]) + Math.abs(leftHandPosition[1] - numberPosition[1]);
            int rightHandDif = Math.abs(rightHandPosition[0] - numberPosition[0]) + Math.abs(rightHandPosition[1] - numberPosition[1]);
            
            if(leftHandDif < rightHandDif) {
                leftHandPosition[0] = numberPosition[0];
                leftHandPosition[1] = numberPosition[1];
                sb.append("L");
            } else if(leftHandDif > rightHandDif) {
                rightHandPosition[0] = numberPosition[0];
                rightHandPosition[1] = numberPosition[1];
                sb.append("R");
            } else {
                if(isLeftHanded) {
                    leftHandPosition[0] = numberPosition[0];
                    leftHandPosition[1] = numberPosition[1];
                    sb.append("L");
                } else {
                    rightHandPosition[0] = numberPosition[0];
                    rightHandPosition[1] = numberPosition[1];
                    sb.append("R");
                }
            }
        }
        answer = sb.toString();
        
        return answer;
    }
}