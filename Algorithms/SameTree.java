/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

/**
 *Given two binary trees, write a function to check if they are the same or not.
 *Two binary trees are considered the same if they are structurally identical and the nodes have the same value.
*/

class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null)
            return q == null;
        if (q == null)
            return false;
        if (p.val == q.val) {
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }

        return false;
    }
}