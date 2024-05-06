package leetCode.Greedy.Hard;

import java.util.Arrays;

public class Candy_135 {
    public int candy(int[] ratings) {
        int[] res = new int[ratings.length];
        Arrays.fill(res, 1);

        for(int i = 1; i < ratings.length; i++){
            if(ratings[i - 1] < ratings[i])
                res[i] = res[i - 1] + 1;
        }

        for(int i = ratings.length - 2; i > -1; i--){
            if(ratings[i + 1] < ratings[i] && res[i] < res[i + 1] + 1)
                res[i] = res[i + 1] + 1;
        }
        return Arrays.stream(res).sum();
    }
}
