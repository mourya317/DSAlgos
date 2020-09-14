package AlgorithmsPart1.UnionFind;

/**
 * @author mballa
 */
public class QuickFind {
    int[] id;

    public QuickFind(int N) {
        id = new int[N];
        for(int i=0;i<N;i++) {
            id[i]=i;
        }
    }

    //O(1)
    public boolean connected(int p, int q) {
        return id[p]==id[q];
    }

    //O(N)
    public void union(int p, int q) {
        //change all entries of id[p] to id[q]
        int pid=id[p];
        int qid=id[q];
        for(int i=0;i<id.length;i++) {
            if(id[i]==pid) id[i]=qid;
        }
    }
}
