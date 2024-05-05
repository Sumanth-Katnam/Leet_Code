package leetCode.BinarySearch.Medium;

public class SearchA2DMatrix_74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int ROWS = matrix.length, COLS = matrix[0].length;
        int low = 0, high = ROWS*COLS - 1;
        int mid, r, c;
        while(low <= high){
            mid = (low + high)/2;

            r = mid / COLS;
            c = mid % COLS;

            if(matrix[r][c] == target)
                return true;
            else if (matrix[r][c] > target) {
                high = mid - 1;
            } else
                low = mid + 1;
        }
        return false;
    }
}
