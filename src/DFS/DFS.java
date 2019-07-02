package DFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @author Mourya Balla
 * @project Practice
 * @CreatedOn 13-06-2019
 */
public class DFS {

    static boolean[] visted;
    static int[][] matrix;
    public static void main(String[] args) throws Exception{
        //BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int N = Integer.parseInt(input.split(" ")[0]);
        int M = Integer.parseInt(input.split(" ")[1]);

        visted = new boolean[N+1];
        matrix = new int[N+1][N+1];
        for(int l=1;l<=N;l++){
            for(int m=1;m<=N;m++){
                matrix[l][m]=0;            }
        }
        Arrays.fill(visted,false);

        while(M-- > 0 ){
            String row = br.readLine();
            String[] edge = row.split(" ");
            matrix[Integer.parseInt(edge[0])][Integer.parseInt(edge[1])] = 1 ;
            matrix[Integer.parseInt(edge[1])][Integer.parseInt(edge[0])] = 1 ;
        }

        //Find all connected Components
        /*int numberOfConnectedComponents = 0 ;
        for(int i=1; i<=N;i++){
            if(visted[i] == false){
                dfs(i);
                numberOfConnectedComponents++;
            }
        }
        System.out.println("Total CC : "+numberOfConnectedComponents);*/

        //Find unreachable nodes from head node
        int headNode = 1;
        dfs(1);

        System.out.println("unreachable nodes from "+ headNode);
        for (int i=1;i<=N;i++) {
            //count how many nodes are false/unvisited
            if(!visted[i]) System.out.println(i);
        }



    }

    private static void dfs(int i) {
        int[] edges = matrix[i];
        int size = edges.length;
        visted[i]=true;
        for(int j =1;j<size;j++){
            if(matrix[i][j] == 1 && !visted[j]){
                dfs(j);
            }
        }

    }


}
