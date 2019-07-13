package Trees;

import sun.reflect.generics.tree.Tree;

/**
 * @author Mourya Balla
 * @project Practice
 * @CreatedOn 13-07-2019
 */
public class BstToGst {

    static int sum=0;

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(1);
        root.left.left = new TreeNode(0);

        root.left.right = new TreeNode(2);
        root.left.right.right = new TreeNode(3);

        root.right = new TreeNode(6);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(7);
        root.right.right.right = new TreeNode(8);

        bstToGst(root);


    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static TreeNode bstToGst(TreeNode root) {
        gst(root); //Bottom up reverse inorder , visit all nodes with val > than the node itself
        return root;
    }

    private static void gst(TreeNode root){
        //base case
        if(root == null){
            return;
        }

        gst(root.right);

        sum += root.val;
        root.val = sum;

        gst(root.left);

    }
}

