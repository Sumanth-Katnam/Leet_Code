package leetCode.Strings;

public class ValidPalindrome_125 {
//    public static boolean isPalindrome(String s) {
//        s = s.trim().toLowerCase().replaceAll("[^A-Za-z0-9]", "");
//        String reverse = new StringBuilder(s).reverse().toString();
//        return s.equals(reverse);
//    }

    public static boolean isPalindrome(String s) {
        s = s.trim().toLowerCase().replaceAll("[^A-Za-z0-9]", "");
        int i = 0;
        int j = s.length() - 1;
        while(i < j){
            if (s.charAt(i) == s.charAt(j)){
                i++;
                j--;
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(isPalindrome("aba"));
//        isPalindrome("A man, a plan, a canal: Panama");
//        isPalindrome(" ");
    }
}
