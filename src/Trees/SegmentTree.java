package Trees;

/**
 * @author Mourya Balla
 * @project Practice
 * @CreatedOn 29-05-2019
 */

/*
Range sum query

We have an array arr[0 . . . n-1]. We should be able to
1 Find the sum of elements from index l to r where 0 <= l <= r <= n-1
2 Change value of a specified element of the array to a new value x. We need to do arr[i] = x where 0 <= i <= n-1.
 */
public class SegmentTree {
    //array representation
    int[] st;

    SegmentTree(int[] arr, int n){
        //max number of nodes of tree with height h = 2^(h+1)-1
        //With array representation of n items , the size of memory alcated is 2 * 2^(logn) - 1
        int x = (int)Math.ceil(Math.log(n)/Math.log(2)); // we get the height of the tree using the numebr of elements in array

        //Max size of segment tree
        int max_size = 2 * (int) Math.pow(2, x) - 1;
        st = new int[max_size];
        constructSTUtil(arr , 0 , n-1 , 0);
    }

    /*
    A recursive function that constructs Segment Tree for array[ss..se].
    // si is index of current node in segment tree st
     */
    private int constructSTUtil(int[] arr, int ss, int se, int si) {
        if(ss==se){
            st[si]=arr[ss];
            return arr[ss];
        }
        // If there are more than one elements, then recur for left and
        // right subtrees and store the sum of values in this node

        int mid = ss + (se - ss)/2;
        st[si] = constructSTUtil(arr, ss , mid , si*2+1)   +   constructSTUtil(arr , mid+1, se, si*2+2);   //right and left subtrees , the logic depends on the prob
        return st[si];

    }

    /*  A recursive function to get the sum of values in given range
        of the array.  The following are parameters for this function.

      st    --> Pointer to segment tree
      si    --> Index of current node in the segment tree. Initially
                0 is passed as root is always at index 0
      ss & se  --> Starting and ending indexes of the segment represented
                    by current node, i.e., st[si]
      qs & qe  --> Starting and ending indexes of query range */
    int getSumUtil(int ss, int se, int qs, int qe, int si){

        //if segment of this node is part of the query range , then return the sum of this segment
        if(qs <= ss && qe >= se){
            return st[si];
        }

        //If the segment of this node is falling outside the query range , then it doesnt contribute to the query sum , return 0
        if(qe < ss || se < qs){
            return 0;
        }

        //if it overlaps patially ==> recursevely return sum of left and right childs
        int mid = ss + (se - ss )/2;
        return getSumUtil(ss , mid , qs , qe , 2 * si + 1)   // For left child
                 + getSumUtil(mid+1 , se , qs, qe ,2*si+2); //For right child

    }


    // Return sum of elements in range from index qs (quey start) to
    // qe (query end).  It mainly uses getSumUtil()
    int getSum(int n, int qs , int qe){
        //validate
        if(qs < 0 || qe > n-1 || qs > qe){
            return -1;
        }

        return getSumUtil(0,n-1 , qs, qe, 0); //si=0 ,since root is always 0
    }


    /* A recursive function to update the nodes which have the given
           index in their range. The following are parameters
            st, si, ss and se are same as getSumUtil()
            i    --> index of the element to be updated. This index is in
                     input array.
           diff --> Value to be added to all nodes which have i in range */
    void updateValueUtil(int ss, int se, int i, int diff, int si) {
        // Base Case: If the input index lies outside the range of
        // this segment
        if (i < ss || i > se)
            return;

        // If the input index is in range of this node, then update the
        // value of the node and its children
        st[si] = st[si] + diff;
        if (se != ss) {
            int mid = ss + (se - ss) / 2;
            updateValueUtil(ss, mid, i, diff, 2 * si + 1);
            updateValueUtil(mid + 1, se, i, diff, 2 * si + 2);
        }
    }

    // The function to update a value in input array and segment tree.
    // It uses updateValueUtil() to update the value in segment tree
    void updateValue(int arr[], int n, int i, int new_val)
    {
        // Check for erroneous input index
        if (i < 0 || i > n - 1) {
            System.out.println("Invalid Input");
            return;
        }

        // Get the difference between new value and old value
        int diff = new_val - arr[i];

        // Update the value in array
        arr[i] = new_val;

        // Update the values of nodes in segment tree
        updateValueUtil(0, n - 1, i, diff, 0);
    }




}
