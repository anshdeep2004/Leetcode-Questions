class Solution {
    public int binarySearch(int num2, int i, int[] numbers) {
        int left = i+1;
        int right = numbers.length - 1;
        int mid = 0;
        int idx2 = -1;
        while(left <= right) {
            mid = left + (right - left) / 2;
            if(numbers[mid] < num2) {
                left = mid + 1;
            }
            else if(numbers[mid] > num2) {
                right = mid - 1;
            }
            else {
                idx2 = mid;
                break;
            }
        }

        return idx2;
    }

    public int[] twoSum(int[] numbers, int target) {
        int n = numbers.length;
        int[] ans = new int[2];

        for(int i=0; i<n; i++) {
            int toFind = target - numbers[i];
            int idx2 = binarySearch(toFind, i, numbers);
            if(idx2 != -1) {
                ans[0] = i + 1;
                ans[1] = idx2 + 1;
                break;
            }
            else {
                // Did not find a match to this number.
            }
        }

        return ans;
    }
}