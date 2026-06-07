/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode createBinaryTree(int[][] descriptions) {
        Map<Integer, TreeNode> map = new HashMap<>();
        Set<Integer> children = new HashSet<>();
        
        for (int[] desc : descriptions) {
            int parentVal = desc[0], childVal = desc[1], isLeft = desc[2];
            
       
            map.putIfAbsent(parentVal, new TreeNode(parentVal));
            map.putIfAbsent(childVal, new TreeNode(childVal));
            
            
            if (isLeft == 1) {
                map.get(parentVal).left = map.get(childVal);
            } else {
                map.get(parentVal).right = map.get(childVal);
            }
            
           
            children.add(childVal);
        }
        
        for (int val : map.keySet()) {
            if (!children.contains(val)) {
                return map.get(val);
            }
        }
        
        return null;
    }
}