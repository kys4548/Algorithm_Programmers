import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        
        char[] charArr = new char[a];
        
        for(int i=0; i<charArr.length; i++){
            charArr[i]='*';
        }
        for(int i=0; i<b; i++){
            System.out.println(String.valueOf(charArr));
        }
    }
}