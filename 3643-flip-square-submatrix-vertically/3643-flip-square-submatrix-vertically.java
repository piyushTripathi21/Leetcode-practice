class Solution {
    public int[][] reverseSubmatrix(int[][] grid, int x, int y, int k) {
        // Iterate through the first half of the submatrix rows to perform swaps
        for (int i = 0; i < k / 2; i++) {
            // Identify the two rows to be swapped
            int row1 = x + i;
            int row2 = x + k - 1 - i;
            
            // Swap elements for each column in the k-sized submatrix
            for (int j = 0; j < k; j++) {
                int col = y + j;
                
                int temp = grid[row1][col];
                grid[row1][col] = grid[row2][col];
                grid[row2][col] = temp;
            }
        }
        return grid;
    }
}