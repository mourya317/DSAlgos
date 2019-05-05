package BinarySearch;

/**
 * @author Mourya Balla
 * @project Practice
 * @CreatedOn 26-03-2019
 */
public class SearchRotatedSortedArray {
    public static void main(String[] args) {
        int[] a = {4,5,6,7,0,1,2};
        int[] b = {10, 15, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10};
        int[] c = {2,3,2,2,2};
        int n = c.length;
        //System.out.println(findOne(a,0,n-1, 1));
        System.out.println(findOneImproved(c,0,n-1, 3));
    }


    //Failed solution
    private static boolean findOne(int[] a, int l, int r, int s) {

        // use binary search the array
        //compare middle with both
        //compare l and r and select min(l,r)
        if (l == r) {
            return a[l] == s;
        }

        if((a[l] == s) || a[r]==s ){
            //System.out.println("location:");
            return true;
        }

        if ((r - l) == 1) {
            return (a[l] == s) || (a[r] == s);
        }

        int m = l + (r - l) / 2;

        if (a[m] == s) {
            System.out.println("location:"+m);
            return true;
        }else if(a[l] == a[r]) { // check for duplicates .... remove the left elemnt
            return findOne(a,l+1,r,s);
        }else if (s > a[m]) { // its anyway sorted from left to right
            //go right
            return findOne(a, m, r-1, s);
        } else {
            //go left
            return findOne(a, l, m-1, s);
        }
    }

    /*
    two cases : we need to find how to update left and right pointers , there are 2 cases .
    solution : we need to aprtition the arrays into two parts  A,B . only one of  or B is sorted
    1. if the target lies in soted part , its easy
    2. if it falls on unsorted part we need to recursively call the function to determine its location

We can easily know which half is sorted by comparing start and end element of each half.
Once we find which half is sorted we can see if the key is present in that half - simple comparison with the extremes.
If the key is present in that half we recursively call the function on that half
else we recursively call our search on the other half.
We are discarding one half of the array in each call which makes this algorithm O(logN).

    N(log n )
     */

    private static boolean findOneImproved(int[] a, int l, int r, int s) {
        if(l > r)return false;
        int m = l+(r-l)/2;

        if(s == a[m])return true;

        //skip duplicates
        if(a[l] == a[r]){
            return findOneImproved(a,l+1,r,s);
        }
        //check if left is sorted
        if(a[l] <= a[m]){
            //if sorted then check if key lies in left or right
            if(s >= a[l] && s < a[m]){
                return findOneImproved(a, l, m-1, s );
            }

            return findOneImproved(a, m+1, r,s);
        }

        //right must be sorted
        if(s > a[m] && s<= a[r]){
            return findOneImproved(a, m+1, r,s);
        }
        return findOneImproved(a, l,m-1,s);
    }





    }
