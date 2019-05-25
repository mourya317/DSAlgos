package Trees;

import sun.reflect.generics.tree.Tree;

import java.util.*;

/**
 * @author Mourya Balla
 * @project Practice
 * @CreatedOn 23-05-2019
 */
public class Traversals {
    public static void main(String[] args) {
        TreeNode n = new TreeNode(1);
        n.left=new TreeNode(2);
        n.right=new TreeNode(3);

        n.left.left=new TreeNode(4);
        n.left.right=new TreeNode(5);
        n.left.right.right=new TreeNode(6);
        n.left.right.right.right=new TreeNode(7);

       // preOrder(n);
        //pre(n);
        //inOrder(n);
        //in(n);
        //postOrder(n);
        //postOrder(n);
        //System.out.println(height(n));
        levelReverse(n);
    }


    /*
    Get total height and print each level
    complexity is o(n) + o(n-1) + o(n-2) + ... + o(1) = o(n^2) worst case

     */
    public static void levelOrder(TreeNode n){
        int height =height(n);

        for(int i=1;i<=height;i++){
            printLevel(n, i);

            System.out.println("\n--------------");
        }

    }

    /*
    o(n)
     */
    public static void level(TreeNode n){
        if(n == null)return;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(n);

        while(!q.isEmpty()){
            TreeNode pop = q.poll();
            System.out.print(pop.data + " ");

            if(pop.left != null)q.add(pop.left);
            if(pop.right != null)q.add(pop.right);
        }

    }

    /*
    o(n)
     */
    public static void levelReverse(TreeNode n){
        if(n == null)return;
        Queue<TreeNode> q = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        q.add(n);
        stack.add(n);

        while(!q.isEmpty()){
            TreeNode pop = q.poll();
            //System.out.print(pop.data + " ");

            if(pop.left != null){
                q.add(pop.left);

            }
            if(pop.right != null){
                q.add(pop.right);
            }

            if(pop.right != null)stack.add(pop.right);
            if(pop.left != null)stack.add(pop.left);
        }

        //print stack
        System.out.println();
        //stack.forEach(e -> System.out.print(e.data + " "));

        while(!stack.isEmpty()){
            TreeNode k = stack.pop();
            System.out.print(k.data+" ");
        }

    }

    private static void printLevel(TreeNode n, int l) {
        if(n==null)return;
        if(l==1){
            System.out.print(n.data+" ");
        }else if(l > 1) {

            printLevel(n.left, l - 1 );
            printLevel(n.right, l -1 );
        }
    }

    public static int height(TreeNode n){
        if(n==null)return 0;
        return Integer.max(height(n.left), height(n.right))+1;
    }








    static class TreeNode{
        int data;
        TreeNode left;
        TreeNode right;

        TreeNode(int data){
            this.data=data;
            this.left=null;
            this.right=null;
        }
    }


    public static void preOrder(TreeNode n){
        if(n==null)return;

        System.out.println(n.data);
        preOrder(n.left);
        preOrder(n.right);
    }

    public static void pre(TreeNode n){
        //ArrayList<TreeNode> list = new ArrayList<>();

        if(n ==null)return;
        Stack<TreeNode> stack = new Stack<>();

        stack.push(n);

        while(!stack.empty()){
            TreeNode pop = stack.pop();
            System.out.println(pop.data);
            //stack.pop();


            if(pop.right!=null){
                stack.push(pop.right);
            }
            if(pop.left!=null){
                stack.push(pop.left);
            }
        }
    }

    /*
    similiar to preorder . we need to save the popped to a new stack
     */
    public static void post(TreeNode n){
        //ArrayList<TreeNode> list = new ArrayList<>();

        if(n ==null)return;
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();

        stack1.push(n);

        while(!stack1.empty()){
            TreeNode pop = stack1.pop();
            //System.out.println(pop.data);
            stack2.push(pop);


            if(pop.left!=null){
                stack1.push(pop.left);
            }

            if(pop.right!=null){
                stack1.push(pop.right);
            }
        }

        while(!stack2.empty()){
            System.out.println(stack2.pop().data);
        }
    }

    public static void inOrder(TreeNode n){
        if(n==null)return;

        inOrder(n.left);
        System.out.println(n.data);
        inOrder(n.right);
    }


    public static void in(TreeNode n){
        if(n==null)return;

        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = n;

        while(curr!= null || stack.size() > 0){
            //traverse all the left subtree
            while(curr != null){
                stack.push(curr);
                curr=curr.left;
            }

            TreeNode pop = stack.pop();
            System.out.println(pop.data);

            //traverse right subtree
            curr = pop.right;



        }
    }

    public static void postOrder(TreeNode n){
        if(n==null)return;

        postOrder(n.left);
        postOrder(n.right);
        System.out.println(n.data);
    }

}
