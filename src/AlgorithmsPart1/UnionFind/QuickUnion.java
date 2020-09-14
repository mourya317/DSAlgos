package AlgorithmsPart1.UnionFind;

/**
 * @author mballa
 */
public class QuickUnion {
    /*
    Data structure.
・Integer array id[] of length N.
・Interpretation: id[i] is parent of i.
・Root of i is id[id[id[...id[i]...]]]
     */
    int[] id;
    int[] sz; //size of components for roots(site indexed)

    public QuickUnion(int N) {
        id = new int[N];
        sz = new int[N];
        for(int i=0;i<N;i++) {
            id[i]=i;
            sz[i]=1;
        }
    }

    //chase down the root of i
    //Improvement: path compression , Just after computing the root of p,
    //set the id of each examined node to point to that root
    public int root(int i) {
        while(i !=id[i]) {
            id[i]=id[id[i]];//make every node point to its grandparent
            i=id[i];
        }
        return i;
    }

    //O(N)
    public boolean connected(int p, int q) {
        return root(p)==root(q);
    }

    //O(N).cost of finding the roots.
    //trees can get very tall.
    /*
    Weighted QuickUnion for tall trees improvement. just use cache to store size of tree rooted at i,
    and always make sure to link smaller tree to root of larger tree.
     */
    public void union(int p, int q) {
        int i = root(p);
        int j = root(q);

        /*
        Weighted QuickUnion
        //FIND : time proportional to height of p,q
        //UNION: takes constant time given the roots.
        if(i==j)return ;
        if(sz[i] < sz[j]) {
            id[i]=j; sz[j]+=sz[i];
        } else {
            id[j]=i; sz[i]+=sz[j];
        }
         */
        if(i==j)return ;
        if(sz[i] < sz[j]) {
            id[i]=j; sz[j]+=sz[i];
        } else {
            id[j]=i; sz[i]+=sz[j];
        }

        //change root of p to root of q
        //id[i]=j;
    }



}
