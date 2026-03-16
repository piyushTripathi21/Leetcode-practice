import java.util.*;

class Solution {
    public int[] getBiggestThree(int[][] grid) {
        
        int m = grid.length;
        int n = grid[0].length;
        
        TreeSet<Integer> set = new TreeSet<>();
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                
                // size 0 rhombus
                set.add(grid[i][j]);
                
                int size = 1;
                
                while (i + 2 * size < m && j - size >= 0 && j + size < n) {
                    
                    int sum = 0;
                    
                    // top -> right
                    for (int k = 0; k < size; k++)
                        sum += grid[i + k][j + k];
                    
                    // right -> bottom
                    for (int k = 0; k < size; k++)
                        sum += grid[i + size + k][j + size - k];
                    
                    // bottom -> left
                    for (int k = 0; k < size; k++)
                        sum += grid[i + 2 * size - k][j - k];
                    
                    // left -> top
                    for (int k = 0; k < size; k++)
                        sum += grid[i + size - k][j - size + k];
                    
                    set.add(sum);
                    size++;
                }
            }
        }
        
        List<Integer> list = new ArrayList<>(set);
        Collections.sort(list, Collections.reverseOrder());
        
        int k = Math.min(3, list.size());
        int[] res = new int[k];
        
        for (int i = 0; i < k; i++)
            res[i] = list.get(i);
        
        return res;
    }
}