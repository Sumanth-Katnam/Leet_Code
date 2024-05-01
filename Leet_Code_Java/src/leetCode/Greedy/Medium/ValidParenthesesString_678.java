package leetCode.Greedy.Medium;

public class ValidParenthesesString_678 {
    public boolean checkValidString(String s) {
        int maxOpen = 0, minOpen = 0;

        for(char ch: s.toCharArray()){
            if(ch == '('){
                maxOpen += 1;
                minOpen += 1;
            } else if(ch == ')'){
                maxOpen -= 1;
                minOpen -= 1;
            } else{
                maxOpen += 1;
                minOpen -= 1;
            }

            if(maxOpen < 0)
                return false;

            if(minOpen < 0)
                minOpen = 0;
        }
        return minOpen == 0;
    }
}
