package dp;

import java.util.Arrays;

/**
 * @author Mourya Balla
 * @project Practice
 * @CreatedOn 11-06-2019
 */
/*
we are given a set of items having weight and value ,determine number of each item to include in collection so that total weight is <= given limit and total
value is as high as possible
 */
public class KnapsackProblem {
    //sort in deccreasing order of weights
    public static void main(String[] args) {
        Element e1 = new Element(1,50);
        Element e2 = new Element(56,30);
        Element e3 = new Element(42,20);
        Element e4 = new Element(78,10);
        Element e5 = new Element(12,50);
        //Element e6 = new Element(4,25);


        Element e7 = new Element(10,60);
        Element e8 = new Element(20,100);
        Element e9 = new Element(30,120);

        Element e10 = new Element(10,100);
        Element e11 = new Element(40,280);
        Element e12 = new Element(20,120);
        Element e13 = new Element(24,120);

        Element[] arr = {e1,e2,e3,e4,e5};
        Element[] arr1 = {e10,e11,e12,e13};
        System.out.println(FractionalKS(arr,150));
    }


    static class Element{
        float w;
        float v;
        Element(float w,float v){
            this.w=w;
            this.v=v;
        }
    }

    /*private static int knapsackValue(Element[] arr , int totalW){
        Arrays.sort(arr, (e1,e2) -> e1.w-e2.w);
        int sum =0 ;
        int currentW=0;

        for(int i=0;i<arr.length;i++){
            if(totalW >= (currentW + arr[i].w) && sum < sum+arr[i].v){
                sum+=arr[i].v;
                currentW+=arr[i].w;
            }
        }

        return sum;
    }*/

    /*
    nlogn
     */
    private static float FractionalKS(Element[] arr, float totalW){
        Arrays.sort(arr, (e1,e2) -> (int) (e2.v/e2.w-e1.v/e1.w));
        float sum =0.0f ;
        float currentW=0.0f;
        float remainingW = totalW;

        for(int i=0;i<arr.length;i++){
            if(currentW < totalW /*&& sum < sum+arr[i].v*/){
                float ratio  = (totalW-currentW)/arr[i].w >=1?1:(totalW-currentW)/arr[i].w;

                //remainingW = remainingW - ratio;

                sum+=(ratio)*arr[i].v;
                currentW+=ratio*arr[i].w;
            }
        }



        return sum;
    }
}