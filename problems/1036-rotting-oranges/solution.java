class Solution {
    class Pair {
        int row;
        int col;
        int tm;
        Pair(int r, int c, int t) {
            this.row = r;
            this.col = c;
            this.tm = t;
        }
    }
    public int orangesRotting(int[][] grid) {
        int n =grid.length;
        int m =grid[0].length;
        Queue<Pair> q = new LinkedList<>();
        
        int cntFresh = 0;
        
        for (int i=0; i<n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j]==2) {
                    q.add(new Pair(i,j,0));
                } else if (grid[i][j]==1) {
                    cntFresh++;
                }
            }
        }

        int tm=0;
        int cnt=0;
        int[] dRow ={-1, 0, 1, 0};
        int[] dCol ={0, 1, 0, -1};

        while(!q.isEmpty()){
            int r=q.peek().row;
            int c=q.peek().col;
            int t=q.peek().tm;
            tm = Math.max(tm, t);
            q.remove();

            for(int i = 0; i < 4; i++){
                int nRow = r+dRow[i];
                int nCol = c+dCol[i];
                
                if (nRow >= 0 && nRow < n && nCol >= 0 && nCol < m && grid[nRow][nCol] == 1) {
                    grid[nRow][nCol] = 2;
                    q.add(new Pair(nRow, nCol, t + 1));
                    cnt++;
                }
            }
        }

        if (cnt != cntFresh) return -1;
        return tm;
    }
}
