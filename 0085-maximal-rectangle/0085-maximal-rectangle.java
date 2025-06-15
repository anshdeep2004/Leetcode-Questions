class Solution {
    public int maximalRectangle(char[][] matrix) {
        int area = 0;
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] histoMatrix = new int[n][m];
        for(int j=0; j<m; j++) {
            int sum = 0;
            for(int i=0; i<n; i++) {
                sum += matrix[i][j] - '0';
                if(matrix[i][j] == '0') sum = 0;
                histoMatrix[i][j] = sum;
            }
        }
        for(int i=0; i<n; i++) {
            int tempArea = largestRectangleArea(histoMatrix[i]);
            if(tempArea > area) {
                area = tempArea;
            }
        }
        return area;
    }
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        Stack<Integer> st = new Stack<>();
        int[] pse = new int[n];
        int[] nse = new int[n];

        // prevSmallerElement
        for(int i=0; i<n; i++) {
            while(!st.isEmpty() && heights[st.peek()] >= heights[i]) st.pop();
            pse[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }
        st.clear();

        // nextSmallerElement
        for(int i=n-1; i>=0; i--) {
            while(!st.isEmpty() && heights[st.peek()] >= heights[i]) st.pop();
            nse[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }
        st.clear();

        int area = 0;
        for(int i=0; i<n; i++) {
            int tempArea = (nse[i] - pse[i] - 1) * heights[i];
            // System.out.println(pse[i] + " " + nse[i]);
            if(tempArea > area) {
                area = tempArea;
            }
        }
        return area;
    }
}