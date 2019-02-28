/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<TreeNode> generateTrees(int n) {
        if (n==0) return new ArrayList<TreeNode>();//return empty list if input is 0
        return addTrees(1, n);
    }
    
    private List<TreeNode> addTrees(int s, int e){
        List<TreeNode> subtrees = new ArrayList<TreeNode>();
        //base case
        if (s>e){
            subtrees.add(null);
            return subtrees;
        }
        if (s==e){
            subtrees.add(new TreeNode(s));
            return subtrees;
        }
        //recursively find subtrees
        List<TreeNode> left;
        List<TreeNode> right;
        for (int r=s; r<=e; r++){
            left = addTrees(s, r-1);
            right = addTrees(r+1, e);
            for (TreeNode lnode : left){
                for (TreeNode rnode : right){
                //cross match different left and right subtrees
                    TreeNode root = new TreeNode(r);
                    root.left = lnode;
                    root.right = rnode;
                    subtrees.add(root);
                }
            }
        }
        return subtrees;
    }
}
