class Solution {
    public int countCompleteSubarrays(int[] nums) {
        int k= (int)Arrays.stream(nums).distinct().count();
        //System.out.println(k);
        int count = 0;
        for(int i=0;i<nums.length;i++){
            Set<Integer> st= new HashSet<>();
            for(int j=i;j<nums.length;j++){
                st.add(nums[j]);
                if(st.size()==k){
                    count++;
                }
            }    
        }
        return count;
    }
}