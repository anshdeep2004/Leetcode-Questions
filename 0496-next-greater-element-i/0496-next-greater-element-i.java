class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> arr = new HashMap<>();
        int[] result = new int[nums1.length];
        for(int i=0; i<nums2.length; i++) {
            arr.put(nums2[i], i);
        }
        for(int j=0; j<nums1.length; j++) {
            int pos = arr.get(nums1[j]);
            if(pos == nums2.length-1) {
                result[j] =-1;
                continue;
            }
            for(int k=pos+1; k<nums2.length; k++) {
                if(nums2[k] > nums1[j]) {
                    result[j] = nums2[k];
                    break;
                }
                else {
                    result[j] = -1;
                }
            }
        }
        return result;
    }
}