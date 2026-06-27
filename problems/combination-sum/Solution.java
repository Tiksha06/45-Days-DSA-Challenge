class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();

        findCombinations(0, candidates, target, new ArrayList<>(), ans);
        
        return ans;
    }

    private void findCombinations(int idx, int[] arr, int target, List<Integer> current, List<List<Integer>> ans){
        if(target == 0){
            ans.add(new ArrayList<>(current));
            return;
        }
        if(idx==arr.length || target<0){
            return;
        }

        if(arr[idx] <= target){
            current.add(arr[idx]); // Bag mein dala

            findCombinations(idx, arr, target-arr[idx], current, ans); 
            
            current.remove(current.size() - 1);
        }
        findCombinations(idx+1, arr, target, current, ans);
    }
}