package leetCode;

public class MajorityElement_169 {
    public static int majorityElement(int[] nums) {
//        Moore's voting algorithm
        int majElem = 0;
        int count = 0;
        for(int i: nums){
            if(count == 0){
                count = 1;
                majElem = i;
            } else if(i == majElem){
                count++;
            } else {
                count --;
            }
        }
        return majElem;
    }
    public static void main(String[] args) {
        majorityElement(new int[]{2,3,4,2,2,2,2,1});
    }
}
