package Java;

class TreeNode {

  int val;
  TreeNode left;
  TreeNode right;

  TreeNode() {
  }

  TreeNode(int val) {
    this.val = val;
  }

  TreeNode(int val, TreeNode left, TreeNode right) {
    this.val = val;
    this.left = left;
    this.right = right;
  }

class Solution {
  public boolean isValidBST(TreeNode root) {
    return isValidBSTImplement(root, Long.MIN_VALUE, Long.MAX_VALUE);
  }

  public boolean isValidBSTImplement(TreeNode root, long leftBound, long rightBound) {
    if (root == null) {
      return true;
    }

    if (root.val <= leftBound || root.val >= rightBound) {
      return false;
    }

    return isValidBSTImplement(root.left, leftBound, Math.min(root.val, rightBound))
        && isValidBSTImplement(root.right, Math.max(leftBound, root.val), rightBound);
  }
}