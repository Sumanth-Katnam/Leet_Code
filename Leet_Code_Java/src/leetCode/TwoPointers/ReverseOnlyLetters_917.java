package leetCode.TwoPointers;

public class ReverseOnlyLetters_917 {
    public String reverseOnlyLetters(String s) {
        char[] char_arr = s.toCharArray();
        int i = 0, j = char_arr.length - 1;

        while(i < j){
            if(Character.isLetter(char_arr[i]) && Character.isLetter(char_arr[j])){
                char temp = char_arr[i];
                char_arr[i] =  char_arr[j];
                char_arr[j] = temp;
                i += 1;
                j -= 1;
            } else if(!Character.isLetter(char_arr[i]))
                i += 1;
            else
                j -= 1;
        }

        return new String(char_arr);
    }
}
