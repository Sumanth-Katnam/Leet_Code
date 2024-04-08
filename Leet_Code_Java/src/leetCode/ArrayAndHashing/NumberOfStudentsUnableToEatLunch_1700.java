package leetCode.ArrayAndHashing;

public class NumberOfStudentsUnableToEatLunch_1700 {
    public int countStudents(int[] students, int[] sandwiches) {
        int[] sandwich_map = new int[2];

        for(int choice : students)
            sandwich_map[choice] += 1;

        int res = sandwiches.length;
        for(int sandwich : sandwiches){
            if(sandwich_map[sandwich] == 0 || res == 0)
                break;

            sandwich_map[sandwich] -= 1;
            res -= 1;
        }

        return res;
    }
}
