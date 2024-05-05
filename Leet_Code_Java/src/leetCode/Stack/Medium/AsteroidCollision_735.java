package leetCode.Stack.Medium;

import java.util.Stack;

public class AsteroidCollision_735 {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stk = new Stack<>();

        int idx = 0, asteroid;
        while(idx < asteroids.length){
            asteroid = asteroids[idx];
            if(!stk.isEmpty() && stk.peek() > 0 && asteroid < 0){
                if(stk.peek() < asteroid * -1){
                    stk.pop();
                    continue;
                }

                if(stk.peek() == asteroid * -1)
                    stk.pop();

                asteroid = Integer.MAX_VALUE;

            }
            if(asteroid != Integer.MAX_VALUE)
                stk.add(asteroid);

            idx++;
        }
        int[] res = new int[stk.size()];
        for(int pos = stk.size() - 1; pos > -1; pos--){
            res[pos] = stk.pop();
        }
        return res;
    }
}
