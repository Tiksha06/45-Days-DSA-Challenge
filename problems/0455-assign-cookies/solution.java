class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int i=0, n=g.length, m=s.length;
        for(int j=0; j<s.length; j++){
            if(i==g.length) break;
            if(g[i]<=s[j]){
                i++;
            } 
        }
        return i;
    }
}
