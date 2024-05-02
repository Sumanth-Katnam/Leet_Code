package leetCode.MathAndGeomerty.Medium;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RobotBoundedInCircle_1041 {
    public boolean isRobotBounded(String instructions) {
        int[][] directions = {{0, 1}, {-1, 0}, {0, -1}, {1, 0}};
        int[] currPoint = new int[]{0, 0};
        // 0: North, 1: West, 2: South, 3: East
        int dir = 0;

        for(char ins: instructions.toCharArray()){
            if(ins == 'G'){
                currPoint[0] += directions[dir][0];
                currPoint[1] += directions[dir][1];
            } else if (ins == 'L'){
                dir = (dir + 3) % 4;
            } else {
                dir = (dir + 1) % 4;
            }
        }
        return (currPoint[0] == 0 && currPoint[1] == 0) || dir != 0;
    }
}
