class Solution {
    
    public int maxTwoEvents(int[][] events) {
        int n = events.length;

        // sort according to the endTime
        Arrays.sort(events, (a, b) -> Integer.compare(a[1], b[1]));

        int[] prefixMax = new int[n];

        prefixMax[0] = events[0][2];

        for(int i=1; i<n; i++) {
            prefixMax[i] = Math.max(prefixMax[i-1], events[i][2]);
        }

        int ans = 0;

        for(int i=0; i<n; i++) {
            int start = events[i][0];
            int value = events[i][2];

            int idx = binarySearch(events, start);

            // case when 2 events are considered.
            if(idx != -1) {
                ans = Math.max(ans, value + prefixMax[idx]);
            }

            // case when one event is considered.
            ans = Math.max(ans, value);
        }

        return ans;
    }

    public int binarySearch(int[][] events, int start) {
        int left = 0;
        int right = events.length - 1;
        int mid = 0;
        int tempResult = -1;

        while(left <= right) {
            mid = left + (right - left) / 2;
            if(events[mid][1] < start) {
                tempResult = mid;
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }

        return tempResult;
    }
    
}