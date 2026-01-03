class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        int i = 0;
        int j = 0;
        Set<Integer> ans = new HashSet<>();

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        while(i < n1 && j < n2) {
            if(nums1[i] == nums2[j]) {
                ans.add(nums1[i]);
                i++;
                j++;
            }
            else if(nums1[i] > nums2[j]) {
                j++;
            }
            else {
                i++;
            }
        }

        int[] answer = new int[ans.size()];
        int k = 0;

        for(int num : ans) {
            answer[k] = num;
            k++;
        }

        return answer;
    }
}