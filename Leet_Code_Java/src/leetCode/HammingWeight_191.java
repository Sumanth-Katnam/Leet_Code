package leetCode;

public class HammingWeight_191 {
    // you need to treat n as an unsigned value
    public static int hammingWeight(int n) {
        int len = String.valueOf(n).length();
        int result = 0;
        for(int i = 0; i < len; i ++){
            int bit = (n >> i) & 1;
            result = result + bit;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(hammingWeight(1101));
    }
}
