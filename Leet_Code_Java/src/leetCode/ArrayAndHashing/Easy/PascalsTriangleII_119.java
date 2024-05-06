package leetCode.ArrayAndHashing.Easy;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangleII_119 {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> prevRow = new ArrayList<>();
        List<Integer> row;
        for(int i = 0; i <= rowIndex; i++){
            row = new ArrayList<>();
            for(int j = 0; j <= i; j++){
                if(j == 0 || j == i)
                    row.add(1);
                else
                    row.add(prevRow.get(j - 1) + prevRow.get(j));
            }
            prevRow = row;
        }
        return prevRow;
    }
}
