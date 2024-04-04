package leetCode.BitManipulation;

public class ReverseBits_190 {
    // you need treat n as an unsigned value
    public static int reverseBits(int n) {
        int result = 0;
        for(int i = 0; i < 32; i ++){
            int bit = (n >> i) & 1;
            result = result | (bit << (31 - i));
        }
        return result;
    }

    public static void main(String[] args) {
//        System.out.println(reverseBits(00000010100101000001111010011100));
//        System.out.println(reverseBits(11111111111111111111111111111101));
        System.out.println(reverseBits(1101));
    }
}
