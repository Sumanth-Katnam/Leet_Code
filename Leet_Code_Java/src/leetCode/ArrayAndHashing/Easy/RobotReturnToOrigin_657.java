package leetCode.ArrayAndHashing.Easy;

import javafx.util.Pair;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class RobotReturnToOrigin_657 {
    public boolean judgeCircle(String moves) {
        Map<Character, Pair<Integer, Integer>> moveMap = new HashMap<>();
        moveMap.put('U', new Pair<> (0, 1));
        moveMap.put('D', new Pair<> (0, -1));
        moveMap.put('L', new Pair<> (-1, 0));
        moveMap.put('R', new Pair<> (1, 0));

        int[] currPoint = new int[]{0, 0};
        for(char move: moves.toCharArray()){
            currPoint[0] += moveMap.get(move).getKey();
            currPoint[1] += moveMap.get(move).getValue();
        }
        return Arrays.equals(currPoint, new int[]{0, 0});
    }
}
