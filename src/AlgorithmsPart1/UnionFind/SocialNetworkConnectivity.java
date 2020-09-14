package AlgorithmsPart1.UnionFind;

/**
 * @author mballa
 *
 */
/**
 * Coursera - Algorithms Part I
 * Week 1 - Interview Questions - Union Find
 *
 * Question 1: Social network connectivity
 *
 * Given a social network containing N members and a log file containing M
 * timestamps at which times pairs of members formed friendships, design an
 * algorithm to determine the earliest time at which all members are connected
 * (i.e., every member is a friend of a friend of a friend ... of a friend).
 * Assume that the log file is sorted by timestamp and that friendship is an
 * equivalence relation. The running time of your algorithm should be MlogN or
 * better and use extra space proportional to N.
 */

/**
 * Solution:
 *
 * Use a union-find data structure with each site representing a social network
 * member. Add unions between sites in time order of friendships being formed.
 * After each union is added, check the number of connected components
 * within the union-find data structure. If only one, all members are connected.
 *
 * Must keep track of number of unique components. Decreases when a union occurs
 * between different components.
 */

/**
 * Determine when all members of a social network are connected.
 */
public class SocialNetworkConnectivity {
    private QuickUnion uf;
    private int count;

    //constructor
    public SocialNetworkConnectivity(int N) {
        uf = new QuickUnion(N);
        count=N;
    }

    private void addFriendship(int p1, int p2) {
        if(!uf.connected(p1, p2)) {
            --count;
        }
        uf.union(p1, p2);
    }

    private boolean fullyConnected() {
        return this.count == 1;
    }

    public static void main(String[] args) {
        //initialize soical connectivity data structure with N states
        //read file , with each line read the ts and relationship
        //for each relation call addFriendship
        //check if members are fully connected.
    }
}
