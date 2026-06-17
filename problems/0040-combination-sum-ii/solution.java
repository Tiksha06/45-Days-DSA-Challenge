class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();        
        Arrays.sort(candidates);
        findCombinations(0, candidates, target, new ArrayList<>(), ans);        
        return ans;
    }

    private void findCombinations(int index, int[] arr, int target, List<Integer> current, List<List<Integer>> ans){
        if(target == 0){
            ans.add(new ArrayList<>(current));
            return;
        }
        
        for(int i=index; i<arr.length; i++){
            if (arr[i] > target){
                break;
            }
            if (i>index && arr[i]==arr[i-1]){
                continue;
            }
            current.add(arr[i]);
            //recursionnnn!
            findCombinations(i+1, arr, target-arr[i], current, ans);
            //backtrackkkinggg!!
            current.remove(current.size() -1);
        }
    }
}
