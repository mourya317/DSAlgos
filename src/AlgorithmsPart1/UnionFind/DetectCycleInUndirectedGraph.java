package AlgorithmsPart1.UnionFind;

/**
 * @author mballa
 */
public class DetectCycleInUndirectedGraph {
    /*
    Use array representation to rep disjoint sets.
    1. initially all elements are different sets
    2. procecss each edge and see if they belong to same set ; if true, there is a cycle in graph
    3. Else do union and merge the sets.
     */
    public static void main(String[] args) {
         /* Let us create the following graph
        0
        | \
        |  \
        1---2 */
        int V = 3, E = 3;
        Graph graph = new Graph(V, E);

        // add edge 0-1
        graph.edge[0].src = 0;
        graph.edge[0].dest = 1;

        // add edge 1-2
        graph.edge[1].src = 1;
        graph.edge[1].dest = 2;

        // add edge 0-2
        graph.edge[2].src = 0;
        graph.edge[2].dest = 2;

        if (graph.isCycle(graph) == 1)
            System.out.println("graph contains cycle");
        else
            System.out.println("graph doesn't contain cycle");
    }

    static class Graph {
        int V, E;
        Edge[] edge;

        class Edge {
            int src, dest;
        }

        Graph(int v, int e) {
            V = v;
            E = e;
            edge = new Edge[E];
            for (int i = 0; i < e; i++) {
                edge[i] = new Edge();
            }
        }

        int find(int[] parent, int i) {
            if (parent[i] == -1) {
                return i;
            }
            return find(parent, parent[i]);//Find the subset of element i
        }

        void union(int[] parent, int x, int y) {
            //set the root of x to root of y
            int xset = find(parent, x);
            int yset = find(parent, y);
            parent[xset] = yset; //can be improved by weighted union-find
        }

        int isCycle(Graph graph) {
            int[] parent = new int[graph.V];
            for (int i = 0; i < graph.V; i++) {
                parent[i] = -1;
            }

            for (int i = 0; i < graph.E; i++) {
                //find subsets of both the vertices
                int x = graph.find(parent, graph.edge[i].src);
                int y = graph.find(parent, graph.edge[i].dest);
                if (x == y)
                    return 1;//Found cycle

                graph.union(parent, x, y);
            }
            return 0;
        }
    }
}


