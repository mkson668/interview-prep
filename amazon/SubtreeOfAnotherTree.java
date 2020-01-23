import java.util.*;

class SubtreeOfAnotherTree {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public static void main(String[] args) {
        
        TreeNode original = new TreeNode(3);
        original.left = new TreeNode(4);
        original.right = new TreeNode(5);
        original.left.left = new TreeNode(1);
        original.left.right = new TreeNode(2);
        original.left.right.right = new TreeNode(3);

        TreeNode subTree = new TreeNode(4);
        subTree.left = new TreeNode(1);
        subTree.right = new TreeNode(2);

        boolean ret = isSubtree(subTree, original);
        System.out.println(ret);
    }

    public static boolean isSubtree(TreeNode s, TreeNode t) {
        TreeNode original = t;
        TreeNode subTree = s;
        boolean isMatching = false;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(original);
        while (!q.isEmpty()) {
            TreeNode head = q.remove();
            // detect if root is found
            if (head.val == subTree.val) {
                // BFS comparison
                Queue<TreeNode> qOriginal = new LinkedList<>();
                Queue<TreeNode> qSub = new LinkedList<>();
                qOriginal.add(head);
                qSub.add(subTree);
                isMatching = true;
                while ((!qSub.isEmpty() || !qOriginal.isEmpty()) && isMatching) {
                    if (qSub.size() == qOriginal.size()) {
                        TreeNode headOriginal = qOriginal.remove();
                        TreeNode headSub = qSub.remove();

                        if (headOriginal.val == headSub.val) {
                            if (headOriginal.left != null) {
                                qOriginal.add(headOriginal.left);
                            }
                            if (headOriginal.right != null) {
                                qOriginal.add(headOriginal.right);
                            }
                            if (headSub.left != null) {
                                qSub.add(headSub.left);
                            }
                            if (headSub.right != null) {
                                qSub.add(headSub.right);
                            }
                        } else {
                            isMatching = false;
                        }
                    } else {
                        isMatching = false;
                    }
                }
            }
            if (isMatching == true) {
                break;
            }
            // root is not matching so keep searching on original
            if (head.left != null) {
                q.add(head.left);
            }
            if (head.right != null) {
                q.add(head.right);
            }

        }
        return isMatching;
    }
}