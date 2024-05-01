package leetCode.ArrayAndHashing.Easy;

public class FindFirstPalindromicStringInTheArray_2108 {
    public boolean isPalindrome(String word){
        int i = 0, j = word.length() - 1;

        while(i <= j){
            if(word.charAt(i) != word.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }
    public String firstPalindrome(String[] words) {
        for(String word: words){
            if(isPalindrome(word))
                return word;
        }
        return "";

//        for(String word: words){
//            if(new StringBuffer(word).reverse().toString().equals(word))
//                return word;
//        }
//        return "";
    }
}
