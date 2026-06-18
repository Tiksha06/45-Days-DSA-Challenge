class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();

        //initializeee!!!
        char[][] board = new char[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                board[i][j]='.';
            }
        }

        boolean cols[]=new boolean[n];
        boolean leftD[]=new boolean[2*n-1];//row+col
        boolean rightD[]=new boolean[2*n-1];//row-col+n-1

        solve(0, board, ans, cols, leftD, rightD, n);
        return ans;
    }

    private void solve(int row, char[][] board, List<List<String>> ans, boolean[] cols, boolean[] leftD, boolean[] rightD, int n){
        
        if(row==n){
            ans.add(construct(board));
        }

        for(int col=0; col<n; col++){
            if(cols[col] || leftD[row+col] || rightD[row-col+n-1]){
                continue;
            }

            //Queen to sit
            board[row][col] = 'Q';
            cols[col]=true;
            leftD[row+col] = true;
            rightD[row-col + n-1] = true;

            solve(row+1,board, ans,cols,leftD, rightD, n);

            //backtrackingg!!
            board[row][col] = '.';
            cols[col]=false;
            leftD[row+col]=false;
            rightD[row-col + n-1]=false;
        }
    }

    private List<String> construct(char[][] board){
        List<String> result = new ArrayList<>();
        for(char[] row: board){
            result.add(new String(row));
        }
        return result;
    }
}
