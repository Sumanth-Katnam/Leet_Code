package leetCode.TwoPointers.Medium;

public class LongestMountainInArray_845 {
    public int longestMountain(int[] arr) {
        int arrLen = arr.length;
        int res = 0;
        int l, r;
        for(int idx = 1; idx < arrLen - 1; idx++){
            if(arr[idx - 1] < arr[idx] && arr[idx] > arr[idx + 1]){
                l = r = idx;

                while(l > 0 && arr[l - 1] < arr[l])
                    l--;

                while(r + 1 < arrLen && arr[r + 1] < arr[r])
                    r++;

                res = Math.max(res, (r - l + 1));
            }
        }
        return res;
    }
}
