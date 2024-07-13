package leetCode.Stack.Hard;

import java.util.*;
import java.util.stream.Collectors;

public class RobotCollisions_2751 {
    static class Robot {
        int health;
        int position;
        int index;

        public Robot(int health, int position, int index) {
            this.health = health;
            this.position = position;
            this.index = index;
        }
    }

    public static List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        List<Robot> robots = new ArrayList<>();

        for (int i = 0; i < positions.length; i++) {
            robots.add(new Robot(directions.charAt(i) == 'R' ? healths[i] : -healths[i], positions[i], i));
        }
        robots.sort(Comparator.comparingInt(robot -> robot.position));
        Stack<Robot> stk = new Stack<>();

        for (Robot robot : robots) {
            boolean collided = false;
            while (!stk.isEmpty() && stk.peek().health > 0 && robot.health < 0) {
                collided = true;
                if (stk.peek().health + robot.health == 0) {
                    stk.pop();
                    break;
                } else if (stk.peek().health > Math.abs(robot.health)) {
                    stk.peek().health -= 1;
                    break;
                } else {
                    stk.pop();
                    robot.health += 1;
                    collided = false;
                }
            }
            if(!collided) stk.add(robot);
        }
        stk.sort(Comparator.comparingInt(robot -> robot.index));
        return stk.stream().map(robot -> Math.abs(robot.health)).collect(Collectors.toList());
    }

    public static void main(String[] args) {
        System.out.println(survivedRobotsHealths(new int[]{3, 5, 2, 6}, new int[]{10, 10, 15, 12}, "RLRL")); //[14]
        System.out.println(survivedRobotsHealths(new int[]{1, 40}, new int[]{10, 11}, "RL")); //[10]
    }
}
