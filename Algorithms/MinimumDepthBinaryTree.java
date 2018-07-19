//Given a binary tree, find its minimum depth.
//The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.

class Solution {
    public int minDepth(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        TreeNode separator = new TreeNode(0);
        int result = 1;
        
        if (root == null)
            return 0;
        
        q.add(root);
        q.add(separator);
        
        while (!q.isEmpty()){
            TreeNode n = q.remove();
            if (n == separator){
                result++;
                q.add(separator);
            } else if (n.left == null && n.right == null){
                return result;
            } else {
                if (n.left != null){
                    q.add(n.left);
                } 
                if (n.right != null){
                    q.add(n.right);
                } 
            }
        }
        
        return -1;
    }
}