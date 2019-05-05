package BinarySearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Mourya Balla
 * @project Practice
 * @CreatedOn 13-04-2019
 */
public class RussianDolls {

    public static void main(String[] args) {
        RussianDoll r = new RussianDoll(0,2);
        RussianDoll r1 = new RussianDoll(2,3);
        RussianDoll r2 = new RussianDoll(3, 2);
        RussianDoll r3 = new RussianDoll(0,2);
        RussianDoll r4 = new RussianDoll(1,2);
        RussianDoll r5 = new RussianDoll(3,1);

        //RussianDoll[] r5 = new RussianDoll[5];
        List<RussianDoll> l = new ArrayList<>();
        l.add(r);
        l.add(r1);
        l.add(r2);
        l.add(r3);
        l.add(r4);
        l.add(r5);
        RussianDoll[] r6 = l.toArray(new RussianDoll[l.size()]);
       // System.out.println(naive(r6));
        System.out.println(solutionOptimised(r6));

    }

    private static class RussianDoll{
        int w;
        int h;
        public  RussianDoll (int w,int h){
            this.w=w;
            this.h=h;
        }

        @Override
        public String toString(){
            return w+"-"+h;
        }
    }

    /*
    sort the dolls
     */
    private static int naive(RussianDoll[] arr ){
        Arrays.sort(arr, (o1, o2) -> {
            if(o1.w != o2.w){
                return o1.w-o2.w;
            }else{
                return o1.h-o2.h;
            }
        });

        for(RussianDoll r:arr){
            System.out.println(r.toString());
        }

        //we need to find the max russain doll by comparing all the prev ones o(n^2)
        /*
        at every iteration we need to check the previous ones and at each location we have to store the max dolls it will hold upto then
        use this result at each location and add 1 to this result if that element can fit (it is like cascading)
         */
        int max =1;
        int[] res = new int[arr.length];
        for(int i = 0 ; i<arr.length;i++){
            res[i]=1;
            for(int j=i-1;j>=0;j--){
                if(arr[j].w < arr[i].w && arr[j].h < arr[i].h){
                    res[i] = Math.max(res[i],res[j]+1);
                }
            }
            max=Math.max(max,res[i]);
        }
        return max;
    }


    /*
    shud be reduced to longest increasing subsequence
     */
    private static int solutionOptimised(RussianDoll[] arr){
        Arrays.sort(arr, (o1, o2) -> {
            if(o1.w != o2.w){
                return o1.w-o2.w;
            }else{
                return o1.h-o2.h;
            }
        });

        for(RussianDoll r:arr){
            System.out.println(r.toString());
        }

        return LISBinary(arr,arr.length);
    }

    /*
     select strictly increasing subsequences
     1. if A[i] is smallest among all the end elements of active lists , we create a new active list of length 1
     2. if A[i] is largest among all the end elements , we will clone the largest active list and extend by A[i]
     3. if A[i] is in between, we will find the list with largest end element that is smaller than A[i].
     then Clone and extend this list by A[i], and discard all other lists of same length as that of this modified list

     We will maintain that the end element of the smaller list is always smaller than the end elemtn of the larger lists

     For gettign the length of LIS we need to maintain a auxillary array/list -
     1. adding elemnet to list  = extending the list
     2. replacing an element = discarding list     -   we will

     */
    private static int LISBinary(RussianDoll[] arr, int n){
        if(arr == null || arr.length == 0 )return 0;

        ArrayList<RussianDoll> list  = new ArrayList<>();
        for(RussianDoll num:arr){
            if(list.size() == 0 || compareRussainDolls(num , list.get(list.size()-1))){ //1. Adding element
                list.add(num);
            }else {
                //replacing element
                int i=0;
                int j = list.size()-1;

                while(i<j){  // 2. finding the ceiling
                    int mid = (i+j)/2;
                    if(compareRussainDolls(num, list.get(mid) )){
                        i=mid+1;
                    }else {
                        j=mid;
                    }
                }
                //replace here after find hte ceiling
                list.set(j,num);
            }
        }
        return list.size();
    }

    private static boolean compareRussainDolls(RussianDoll d1, RussianDoll d2){
        return  (d1.w > d2.w && d1.h > d2.h);
    }
}



