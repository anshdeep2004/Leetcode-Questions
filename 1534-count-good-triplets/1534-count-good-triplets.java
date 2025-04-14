class Solution {
    public int countGoodTriplets(int[] arr, int a, int b, int c) {
        int count=0;
        for(int i=0;i<=arr.length-3;i++){
           for(int k=i+2;k<=arr.length-1;k++){
                if(Math.abs(arr[i]-arr[k])<=c){
                    for(int j=i+1;j<k;j++){
                        if(Math.abs(arr[i] - arr[j])<=a && Math.abs(arr[j] - arr[k])<=b){
                            count++;
                        }
                    }
                }
           }
        }
        return count;
    }
}