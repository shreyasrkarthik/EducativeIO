package leetcode;

public class PalindromeNumber {
    public static void main(String[] args) {
        System.out.println(isPalindrome(1221));
        System.out.println(isPalindrome(121));
        System.out.println(isPalindrome(11221));
        System.out.println(isPalindrome(-11221));
    }
    public static boolean isPalindrome(int x) {
        if(x<0)
            return false;
        else{
            int xCopy = x, newNum=0;
            while(x>0){
                newNum  = (newNum * 10) + (x%10);
                x = x/10;
            }
            if(newNum == xCopy)
                return true;
            else return false;
        }
    }
}
