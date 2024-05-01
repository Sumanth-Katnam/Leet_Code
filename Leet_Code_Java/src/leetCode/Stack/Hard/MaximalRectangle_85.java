package leetCode.Stack.Hard;

import java.util.Stack;

public class MaximalRectangle_85 {
    private int largestRectangleArea(int[] heights){
        Stack<Integer> st = new Stack<>();
        int area = 0;
        for(int i = 0; i <= heights.length; i++){
            while(!st.isEmpty()
                    && (i == heights.length
                    || heights[i] < heights[st.peek()])){
                int h = heights[st.pop()];
                int r = i;
                if(!st.isEmpty()){
                    int l = st.peek();
                    area = Math.max(area, h * (r - l - 1));
                }
                else{
                    area = Math.max(area, h * r);
                }
            }
            st.push(i);
        }
        return area;
    }

    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0)
            return 0;

        int ans = 0;
        int[] answer = new int[matrix[0].length];

        for (char[] row : matrix) {
            for (int i = 0; i < row.length; ++i)
                answer[i] = row[i] == '0' ? 0 : answer[i] + 1;
            ans = Math.max(ans, largestRectangleArea(answer));
        }

        return ans;
    }
}
