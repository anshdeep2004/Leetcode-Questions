class Solution {
    public int findLucky(int[] arr) {
        HashMap<Integer,Integer> freqMap = new HashMap<>();
        int max=-1;
        for(int i=0;i<arr.length;i++){
            freqMap.put(arr[i],freqMap.getOrDefault(arr[i],0)+1);
        }
        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            if(entry.getValue()==entry.getKey()&& entry.getValue()>max){
                max=entry.getValue();
            }
        }
        return max;
    }
}