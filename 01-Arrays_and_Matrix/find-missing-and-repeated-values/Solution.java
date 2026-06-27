class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int repeating = 0;
        int missing = 0;
        int n = grid.length;
        int totalElements = n*n;
        int[] count = new int[totalElements+1];

        for(int i = 0; i<n; i++) {
            for(int j = 0; j<n; j++){
            count[grid[i][j]]++;
            }
        }

        for(int i = 0; i<=totalElements; i++) {
            if (count[i] == 2) {
                repeating = i;
            } else if (count[i] == 0) {
                missing = i;
            }            
        }
        return new int[]{repeating,missing};
    }
}