//Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.

class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null)
            return false;
        return findPath(root, sum, 0);
    }
    
    private boolean findPath(TreeNode root, int sum, int result){
        result = result + root.val;
        
        if (result == sum && root.left == null && root.right == null){
            return true;
        }
        
        boolean left = (root.left != null) ? findPath(root.left, sum, result) : false;
        boolean right = (root.right != null) ? findPath(root.right, sum, result) : false;
        
        return left || right;
    }
}