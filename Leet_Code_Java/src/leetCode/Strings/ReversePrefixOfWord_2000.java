package leetCode.Strings;

public class ReversePrefixOfWord_2000 {
    public String reversePrefix(String word, char ch) {
        int idx  = word.indexOf(ch);

        if(idx == -1)
            return word;

        String sub = word.substring(0, idx + 1);
        String end = word.substring(idx + 1);
        return new StringBuffer(sub).reverse().append(end).toString();
    }
}
