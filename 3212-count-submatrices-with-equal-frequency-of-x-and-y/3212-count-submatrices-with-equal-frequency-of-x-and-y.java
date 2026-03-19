class Solution {
    public int numberOfSubmatrices(char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        
        // diff[i][j] stores (count of X - count of Y) in submatrix (0,0) to (i,j)
        int[][] diff = new int[rows + 1][cols + 1];
        // hasX[i][j] stores total count of X in submatrix (0,0) to (i,j)
        int[][] hasX = new int[rows + 1][cols + 1];
        
        int count = 0;
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int val = 0;
                int xPresent = 0;
                
                if (grid[i][j] == 'X') {
                    val = 1;
                    xPresent = 1;
                } else if (grid[i][j] == 'Y') {
                    val = -1;
                }
                
                // 2D Prefix Sum Formula: Current + Top + Left - TopLeft
                diff[i + 1][j + 1] = val + diff[i][j + 1] + diff[i + 1][j] - diff[i][j];
                hasX[i + 1][j + 1] = xPresent + hasX[i][j + 1] + hasX[i + 1][j] - hasX[i][j];
                
                // Check conditions: diff is 0 (X == Y) and total X > 0
                if (diff[i + 1][j + 1] == 0 && hasX[i + 1][j + 1] > 0) {
                    count++;
                }
            }
        }
        
        return count;
    }
}