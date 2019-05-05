package BinarySearch;

/**
 * @author Mourya Balla
 * @project Practice
 * @CreatedOn 11-04-2019
 */
public class CountNumberOfSmallerElementsAfterSelf {
    //static int[] result = new int[7];
    public static void main(String[] args) {
        int[] arr = {12,1,2,3,0,11,4};
       // count(arr,arr.length);
        countOptimised(arr,arr.length);
    }

    /*
    naive solution O(n^2) space ,
    o(n) time
     */
    private static int[] count(int[] arr,int n){
        int[] c = new int[n];
        for(int i=0;i<n;i++){
            for(int j= i+1;j<n;j++){
                if(arr[j] < arr[i]){
                    c[i]+=1;
                }
            }
        }

        for(int i=0;i<n;i++)
        System.out.println(c[i]);
        return c;
    }

    /*
    O(n*log(n)) , space is O(N)
        use a BST to insert from backwards (since we can get the answer for each node while inserting inside the bst )
        each node has number of duplicates and total number left nodes , while inserting we can increment the result whenever we go right (if we go right that means we encountered a element
        which is less than the current element)
     */
    private static void countOptimised(int[] arr,int n){
        Integer[] result = new Integer[arr.length];
        BstNode root =null;

        for(int i=0;i<arr.length;i++){
            root =insert(root,arr[i],i, result,0);
        }

        for(int i=0;i<arr.length;i++)
            System.out.println(result[i]);
    }

    /*
    insert from backwards
     */
    private static BstNode insert(BstNode root, int num, int i, Integer[] result, int presum){
        if(root == null){
            root = new BstNode(num,0);
            result[i] = presum;
            return root;
        }

        if(root.value == num){
            //increment dup for that node
            root.dup++;
            result[i] = presum + root.numOfLeftNodes;
            return root;
        }

        if(root.value > num){
            //go left
            //we encountered a value wic is lesser than the node,so we increment the current node's numofleftnodes
            root.numOfLeftNodes++;
            root.left = insert(root.left,num,i,result,presum);
        }else {
            root.right = insert(root.right,num,i,result,presum+root.numOfLeftNodes+root.dup);
        }
        return root;
    }


    /*
    Idea is to insert into a BST ,whenever we go left at a node we increment the numofleftnodes of that node and update the result[i]
    result array denotes at every i there are result[i] elements smaller after self.
    when node is equal go right(since it is not lesser)


    i missed the fact that when we insert on the left side we need to update the result for all the elements in root.right subtree !!!!
     */
    public static BstNode insertBst(BstNode root, int num, int index){
        if(root == null){
            root = new BstNode(num,0,index);
            //result[index] = 0;
            return root;
        }

        if(num < root.value){
            //go left since we got a number lesser
            root.numOfLeftNodes++;
            //result[root.index] +=1;
            root.left = insertBst(root.left, num, index);
        }else {
            //go right
            root.right = insertBst(root.right , num, index);
        }
        return  root;
    }



    private static class BstNode {
        int value;
        int dup = 1; // denotes numebr of duplicates
        int numOfLeftNodes;
        int index;
        BstNode left,right;

        BstNode(int val, int numOfLeftNodes, int index){
            this.value =val;
            this.index=index;
            this.numOfLeftNodes=numOfLeftNodes;
        }

        public BstNode(int num, int i) {
            this.value =num;
            this.numOfLeftNodes=i;
        }
    }
}
