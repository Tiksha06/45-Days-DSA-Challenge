class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);

        findSubsets(0,nums, new ArrayList<>(), ans);
        return ans;
    }

    private void findSubsets(int index, int[]nums, List<Integer> curr, List<List<Integer>> ans){
        ans.add(new ArrayList<>(curr));

        for(int i=index; i<nums.length;i++){
            if(i>index && nums[i]==nums[i-1]) continue;
            curr.add(nums[i]);
            findSubsets(i+1,nums,curr,ans);
            curr.remove(curr.size()-1);
        }
    }
}
