package leetCode.SlidingWindow.Easy;

public class ReverseWordsInAStringIII_557 {
    public String reverseWords(String s) {
        char[] char_arr = s.toCharArray();
        int start = 0, end = 0;

        for(int i = 0; i < char_arr.length + 1; i++){
            if(i == char_arr.length || char_arr[i] == ' '){
                end = i - 1;

                while(start < end){
                    char temp = char_arr[start];
                    char_arr[start] = char_arr[end];
                    char_arr[end] = temp;
                    start += 1;
                    end -= 1;
                }

                start = i + 1;
            }
        }
        return new String(char_arr);

//        String[] words = s.split(" ");
//
//        for(int i = 0; i< words.length; i++){
//            words[i] = new StringBuffer(words[i]).reverse().toString();
//        }
//
//        return String.join(" ", words);
    }
}
