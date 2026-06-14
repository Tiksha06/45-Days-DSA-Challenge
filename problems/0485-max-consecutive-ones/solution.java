class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int maxOnes = 0;
        int count = 0;

        for(int i=0; i<nums.length; i++){
            if(nums[i]==1){
                count++;
            } else {
                if(maxOnes<count){
                    maxOnes= count;
                }
                count=0;
            }
        }
        if(maxOnes<count){
            maxOnes= count;
        }

        return maxOnes;
    }
}
