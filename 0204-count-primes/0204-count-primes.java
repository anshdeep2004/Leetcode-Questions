class Solution {
    public int countPrimes(int n) {
        if(n <= 2) {
            return 0;
        }
        int[] arr = new int[n];
        Arrays.fill(arr, 1);
        arr[0] = 0;
        arr[1] = 0;
        int count = 0;
        for(int i=2; i*i<n; i++) {
            if(arr[i] == 1) {
                for(int j=i*i; j<n; j+=i) {
                    arr[j] = 0;
                }
            }
        }
        for(int i=0; i<n; i++) {
            if(arr[i] == 1) {
                count++;
            }
        }
        return count;
    }
}