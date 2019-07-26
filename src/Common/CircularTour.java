package Common;

import java.util.Scanner;

/**
 * @author Mourya Balla
 * @project Practice
 * @CreatedOn 26-07-2019
 */
/*
Suppose there is a circle. There are N petrol pumps on that circle. You will be given two sets of data.
1. The amount of petrol that every petrol pump has.
2. Distance from that petrol pump to the next petrol pump.

Your task is to complete the function tour() which returns an integer denoting the first point from where a truck will be able to complete the circle (The truck will stop at each petrol pump and it has infinite capacity).

Note :  Assume for 1 litre petrol, the truck can go 1 unit of distance.

Input:
The first line of input will be the number of test cases. Then T test cases follow. Each Test case contains 2 lines. The first line will contain an integer N denoting the number of petrol pumps and in the next line are N space separated values petrol and distance denoting the amount of petrol every petrol pump has and the distance to next petrol pump respectively .

Output:
The output of each test case will be the index of the the first point from where a truck will be able to complete the circle otherwise -1 .

Constraints:
1 <= T <= 100
1 <= N <= 50
1 <= petrol, distance <= 100

Example (To be used only for expected output)
Input:
1
4
4 6 6 5 7 3 4 5
Output:
1

Explanation:
Testcase 1: there are 4 petrol pumps with amount of petrol and distance to next petrol pump value pairs as {4, 6}, {6, 5}, {7, 3} and {4, 5}. The first point from where truck can make a circular tour is 2nd petrol pump. Output in this case is 1 (index of 2nd petrol pump).
 */
public class CircularTour {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {

            int pumps = sc.nextInt();
            int[] petrol = new int[pumps];
            int[] distance = new int[pumps];
            int l=0,m=0;
            for(int i=0;i<pumps*2;i++){
                if(i%2==0){
                    petrol[l++]=sc.nextInt();
                }else{
                    distance[m++]=sc.nextInt();
                }
            }
            System.out.println(tour(petrol,distance));
        }
    }

    /*
    First detrimince if it is possible to circle it,irrespective of the order of starting point.
     */
    private static int tour(int[] petrol, int[] distance){
        int start_point=0;
        int sum=0;
        int N=petrol.length;
        int deficit = 0;
        for(int i=0;i<N;i++) {
            sum += petrol[i] - distance[i];

            if (sum < 0) {
                //change the start point
                start_point = i + 1;
                deficit+=sum; //shortage we faced already
                //start again
                sum=0;
            }
        }
        return (sum+deficit > 0)?start_point:-1;

    }
}
