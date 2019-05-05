public class ProductOfArrayExceptSelf {

    static int[] arr = {1,2,3,4};
    public static void main(String[] args) {
        //System.out.println(solution());
        solWithoutDivision();
    }

    private static void solution() {
        //use division
        int result=arr[0];
        int sol=0;
        for(int i=1;i< arr.length;i++){
            result*=arr[i];
        }

        for(int i=0;i<arr.length;i++){
            arr[i]=result/arr[i];
        }

        for(int i=0;i<arr.length;i++)
        System.out.println(arr[i]);

    }

    private static void solWithoutDivision(){
        int[] t1=new int[arr.length];
        int[] t2=new int[arr.length];
        int[] result=new int[arr.length];


        t1[0]=1;
        t2[arr.length-1]=1;
        //scan left to right
        for(int i=0;i<arr.length-1;i++){
            t1[i+1]=arr[i]*t1[i];
        }

        //scan right to left
        for(int i=arr.length-1;i>0;i--){
            t2[i-1]=arr[i]*t2[i];
        }


        for(int i=0;i<arr.length;i++)
            result[i]=t1[i]*t2[i];


        for(int i=0;i<arr.length;i++)
            System.out.println(result[i]);
    }
}
