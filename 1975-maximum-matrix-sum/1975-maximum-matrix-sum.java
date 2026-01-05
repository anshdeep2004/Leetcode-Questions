class Solution {
    public long maxMatrixSum(int[][] matrix) {
        int n = matrix.length;
        int negNum = 0;
        long minAbsNum = Integer.MAX_VALUE;
        long ansSum = 0;

        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(matrix[i][j] < 0) negNum++;

                long absVal = (long) Math.abs(matrix[i][j]);
                minAbsNum = Math.min(minAbsNum, absVal);
                ansSum += absVal;
            }
        }

        if(negNum % 2 == 0) {
            return ansSum;
        }
        else {
            return (ansSum -  2 * minAbsNum);
        }
    }
}