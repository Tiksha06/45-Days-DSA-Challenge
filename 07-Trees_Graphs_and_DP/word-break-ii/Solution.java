class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        ArrayList<String> ans = new ArrayList<>();
        HashSet<String> set = new HashSet<>(wordDict);
        solve(s, set, "", ans);
        return ans;
    }

    private void solve(String s,HashSet<String> set,String path, ArrayList<String> ans){
        if(s.length()==0){
            ans.add(path.trim());
            return;
        }
        for (int i = 1; i <= s.length(); i++) {
            String prefix = s.substring(0, i);

            if(set.contains(prefix)){
                String rem = s.substring(i);
                //recursionnn!!
                solve(rem, set, path+prefix +" ", ans);
            }
        }
    }
}