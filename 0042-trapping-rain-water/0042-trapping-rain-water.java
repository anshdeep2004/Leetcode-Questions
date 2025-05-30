class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int leftMax = 0;
        int rightMax = 0;
        int total = 0;
        int start = 0;
        int end = n - 1;

        while (start <= end) {
            if (height[start] <= height[end]) {
                if (height[start] >= leftMax) {
                    leftMax = height[start];
                } else {
                    total += leftMax - height[start];
                }
                start++;
            } else {
                if (height[end] >= rightMax) {
                    rightMax = height[end];
                } else {
                    total += rightMax - height[end];
                }
                end--;
            }
        }

        return total;
    }
}