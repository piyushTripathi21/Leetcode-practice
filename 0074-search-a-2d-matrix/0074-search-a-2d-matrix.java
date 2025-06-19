class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {

        int row = 0, col = matrix[0].length-1;

        while(row < matrix.length && col >= 0) {
            if(matrix[row][col] == target){
                System.out.println("found target at("+ row + "," + col + ")");
                return true;
            }
            else if (target < matrix[row][col]){
                col--;
            }
            else{
                row++;
            }
        }

         System.out.println("target not found!");
         return false;   
    }
}