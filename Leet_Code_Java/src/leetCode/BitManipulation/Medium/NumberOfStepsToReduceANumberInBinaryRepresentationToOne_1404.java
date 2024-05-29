package leetCode.BitManipulation.Medium;

public class NumberOfStepsToReduceANumberInBinaryRepresentationToOne_1404 {
    public int numSteps(String s) {
        int steps = 0, carry = 0;
        int digit;
        for(int i = s.length() - 1; i > 0; i--){
            digit = (int) s.charAt(i);
            if(digit + carry == 1){
                carry = 1;
                steps += 2;
            } else {
                steps++;
            }
        }
        return steps;
    }
}
