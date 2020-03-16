import java.util.*;

class SameBinaryTree {
    public static void main(String[] args) {
        SameBinaryTree sbt = new SameBinaryTree();
        TreeNode p = sbt.new TreeNode(1);
        TreeNode q = sbt.new TreeNode(1);
        p.left = sbt.new TreeNode(2);
        p.right = sbt.new TreeNode(3);
        q.left = sbt.new TreeNode(2);
        q.right = sbt.new TreeNode(3);
        boolean ret = isSameTree(p, q);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if ((p != null && q == null) || (q != null && p == null)) {
            return false; 
        } 
        if (p == null && q == null) {
            return true;
        }
        Stack<TreeNode> stackT = new Stack<>();
        
        stackT.add(p);
        stackT.add(q);
        while (!stackT.isEmpty()) {
            TreeNode nodeA = stackT.pop();
            TreeNode nodeB = stackT.pop();
            if ((nodeA == null && nodeB != null) || (nodeA != null && nodeB == null)) {
                return false;
            }
            if (nodeA == null && nodeB == null) {
                continue;
            }
            if (nodeA.val != nodeB.val) {
                return false;
            }
            stackT.add(nodeA.left);
            stackT.add(nodeB.left);
            stackT.add(nodeA.right);
            stackT.add(nodeB.right);
        }
        return true;
    }
}