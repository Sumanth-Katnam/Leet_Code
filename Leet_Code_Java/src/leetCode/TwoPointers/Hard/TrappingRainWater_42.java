package leetCode.TwoPointers.Hard;

public class TrappingRainWater_42 {
    public int trap(int[] height) {
        int l = 0, r = height.length - 1;
        int volume = 0;
        int l_max = 0, r_max = 0;

        while(l < r){
            if(height[l] < height[r]){
                if(height[l] > l_max)
                    l_max = height[l];
                else
                    volume += (l_max - height[l]);
                l++;
            } else{
                if(height[r] > r_max)
                    r_max = height[r];
                else
                    volume += (r_max - height[r]);
                r--;
            }
        }
        return volume;
    }
}
