class Solution {
    public void sortColors(int[] nums) {
        int count0=0;
        int count1=0;
        int count2=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                count0++;
            }
            else if(nums[i]==1){
                count1++;
            }
            else{
                count2++;
            }
        }
        for(int j=0;j<count0;j++){
            nums[j]=0;
        }
        for(int k =count0;k<count1+count0;k++){
            nums[k]=1;
        }
        for(int l =count0+count1;l<count1+count0+count2;l++){
            nums[l]=2;
        }
    }
}