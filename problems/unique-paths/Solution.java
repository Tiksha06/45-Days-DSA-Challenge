class Solution {
    public int uniquePaths(int m, int n) {
        int R = n-1;
        int D = m-1;
        int T = m+n-2;

        int small = Math.min(R,D);

        double result = 1;
        for(int i =1; i<=small; i++){
        result = result*(T-small+i)/i;
        }
        return (int) result;
    }
}