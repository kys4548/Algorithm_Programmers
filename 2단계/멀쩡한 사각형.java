class Solution {
    int g = 0;
	public long solution(int w,int h) {
		long answer = 0;
        if(h > w){
            int temp = h;
            h = w;
            w = temp;
        }
        gcd(w,h);
        int a = h/ g;
        int b  = w / g;
        answer = (long)h*w - (a + b -1) *g;
        
		return answer;
	}
    public void gcd(int a, int b){
        if( a % b == 0){
            g = b;
            return;
        }
        gcd(b, a %b);
    }
}