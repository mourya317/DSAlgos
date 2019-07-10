package dp;

/**
 * @author Mourya Balla
 * @project Practice
 * @CreatedOn 06-07-2019
 */
public class EggDropping {
    public static void main(String[] args) {
        int n = 2, k = 36;
        /*System.out.print("Minimum number of "
                + "trials in worst case with "
                + n + " eggs and " + k
                + " floors is " + eggDrop(n, k));*/
        System.out.println("---------------");
        System.out.print("Minimum number of "
                + "trials in worst case with "
                + n + " eggs and " + k
                + " floors is " + eggDropDP(n, k));
    }

    /*
    Trivial problems: 1 egg, 10 floors = Then we need to try each floor 1 by 1
                      10 eggs , 1 floor = Then only 1 attempt possible

                      time complexity is 2^f
     */
    private static int eggDrop(int e, int f){
        if(e == 1)return f;
        if(f == 1 || f == 0)return f;
        int min = Integer.MAX_VALUE;
        int res;

        //Try all droppings from 1st to fth floor and find the worst case for each and return the minimum
        for(int x=1;x<=f;x++){
            res = Math.max(eggDrop(e-1,f-1), eggDrop(e,f-x));
            if(res<min){
                min=res;
            }
        }
        return min+1;
    }

    private static int eggDropDP(int n, int k){
        int C[][]=new int[n+1][k+1];

        //base case 1 if f = 0 then no drops required , if f = 1 , then 1 drop

        for(int i=1;i<=n;i++){
            C[i][0]=0;
            C[i][1]=1;
        }


        //base case 2 , if n = 1 , then drops = floors
        for(int i=1;i<=k;i++){
            C[1][i]=i;
        }

        for(int i=2;i<=n;i++){
            for(int j=2;j<=k;j++){
                C[i][j]=Integer.MAX_VALUE;
                int res;
                for(int x=1;x<=j;x++){
                    res = 1 + Math.max(C[i-1][x-1],C[i][j-x]);
                    //C[i][j] = Math.min(res, C[i][j]);
                    if(res < C[i][j]){
                        C[i][j]=res;
                    }
                }
            }
        }

        //Floors used for minimum trail
        System.out.println("used floors....");
        System.out.println(1);
        for(int i=1;i<k;i++){
            if(C[n][i+1] > C[n][i]) {
                System.out.println(i+1);
            }
        }
        return C[n][k];

    }
}
