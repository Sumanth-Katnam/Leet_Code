package leetCode.TwoPointers.Medium;

public class ContainerWithMostWater_11 {
    public static int maxArea(int[] height) {
        int res = 0, l = 0, r = (height.length - 1);
        while(l < r){
            res = Math.max(res, Math.min(height[l], height[r]) * (r - l));
            if(height[l] < height[r])
                l++;
            else
                r--;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
    }
}
