package AlgorithmsPart1.UnionFind;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
/**
 * @author mballa
 */
/*
The <tt>WeightedQuickUnionUF</tt> class represents a union-find data structure.
 *  It supports the <em>union</em> and <em>find</em> operations, along with
 *  methods for determinig whether two objects are in the same component
 *  and the total number of components.
 *  <p>
 *  This implementation uses weighted quick union by size (without path compression).
 *  Initializing a data structure with <em>N</em> objects takes linear time.
 *  Afterwards, <em>union</em>, <em>find</em>, and <em>connected</em> take
 *  logarithmic time (in the worst case) and <em>count</em> takes constant
 *  time.
 *  <p>
 *  For additional documentation, see <a href="http://algs4.cs.princeton.edu/15uf">Section 1.5</a> of
 *  <i>Algorithms, 4th Edition</i> by Robert Sedgewick and Kevin Wayne.
 */
public class WeightedQuickUnionUF {
    private int[] parent;
    private int[] size;//size of subtree rooted at i
    private int[] max; // max element subtree rooted at i
    private int count;

    //constructor
    public WeightedQuickUnionUF(int N) {
        count=N;
        parent = new int[N];
        size = new int[N];
        max = new int[N];
        for(int i=0;i<N;i++) {
            parent[i]=i;
            size[i]=1;
            max[i]=i;
        }
    }

    public int find(int p) {
        validate(p);
        while(p!=parent[p]) {
            p=parent[p];
        }
        return p;
    }

    public boolean connected(int p, int q) {
        return find(p)==find(q);
    }

    public int findMax(int p) {
        int rootP=find(p);
        return max[rootP];
    }

    private void validate(final int p) {
        int N=parent.length;
        if(p<0||p>=N) {
            throw new IndexOutOfBoundsException("index " + p + " is not between 0 and " + N);
        }
    }

    public void union(int p, int q) {
        int rootP=find(p);
        int rootQ=find(q);
        if(rootP==rootQ)return ;
        //make smaller root point to larger root
        if(size[rootP]<size[rootQ]) {
            parent[rootP]=rootQ;
            size[rootQ]+=size[rootP];
            max[rootQ]=Math.max(max[rootP],max[rootQ]);
        } else {
            parent[rootQ]=rootP;
            size[rootP]+=size[rootQ];
            max[rootP]=Math.max(max[rootP],max[rootQ]);
        }
        count--;
    }

    public int count() {
        return count;
    }

    /**
     * Reads in a sequence of pairs of integers (between 0 and N-1) from standard input,
     * where each integer represents some object;
     * if the objects are in different components, merge the two components
     * and print the pair to standard output.
     */
    public static void main(String[] args) {
        int N = StdIn.readInt();
        WeightedQuickUnionUF uf = new WeightedQuickUnionUF(N);
        while (!StdIn.isEmpty()) {
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            if (uf.connected(p, q)) continue;
            uf.union(p, q);
            StdOut.println(p + " " + q);
        }
        StdOut.println(uf.count() + " components");

        for(int i = 0; i < N; ++i) {
            StdOut.println("Max: " + i + " = " + uf.findMax(i));
        }
    }

}
