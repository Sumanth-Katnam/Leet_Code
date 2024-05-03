package leetCode.MathAndGeomerty.Medium;

public class MinimizeTheMaximumOfTwoArrays_2513 {
    static int gcd(int a,int b){
        return b == 0 ? a : gcd(b,a % b);
    }
    public static int minimizeSet(int divisor1, int divisor2, int uniqueCnt1, int uniqueCnt2) {
        long l = 1,r = (int)(2 * 1e9);
        long ans = r;
        long lcm = ((long) divisor1 * divisor2) / gcd(divisor1, divisor2);
        while (l <= r) {
            long mid = (l + r) >> 1;
            long x = mid - mid / divisor1;
            long y = mid - mid / divisor2;
            long z = mid - mid / lcm;
            if(x < (long) uniqueCnt1 || y < (long) uniqueCnt2 || z < (long) (uniqueCnt1 + uniqueCnt2)) l = mid + 1;
            else{
                ans = Math.min(ans,mid);
                r = mid - 1;
            }
        }
        return (int)ans;
    }

    public static void main(String[] args) {
        System.out.println(minimizeSet(2, 4, 8, 2));
    }
}
