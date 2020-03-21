class TreeSumPath {
    
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;
        boolean ret = hasPathSumHelper(root, sum, 0);
        return ret;
    }
    
    public static boolean hasPathSumHelper(TreeNode node, int sum, int currSum) {
        if (node == null) {
            return false;
        } 
        if (node.left == null && node.right == null && currSum + node.val == sum) {
            return true;
        }
        return hasPathSumHelper(node.left, sum, currSum + node.val) || hasPathSumHelper(node.right, sum, currSum + node.val);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeSumPath.TreeNode(5);
        root.left = new TreeSumPath.TreeNode(4);
        root.right = new TreeSumPath.TreeNode(8);
        root.left.left = new TreeSumPath.TreeNode(11);
        root.left.left.right = new TreeSumPath.TreeNode(2);
        root.left.left.left = new TreeSumPath.TreeNode(7);
        root.right.left = new TreeSumPath.TreeNode(13);
        root.right.right = new TreeSumPath.TreeNode(4);
        root.right.right.right = new TreeSumPath.TreeNode(1);
        boolean exists = hasPathSum(root, 18);
        System.out.println(exists);
    }
}