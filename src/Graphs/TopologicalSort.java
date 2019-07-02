package Graphs;

import com.sun.javaws.Cache6UpgradeHelper;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @author Mourya Balla
 * @project Practice
 * @CreatedOn 10-06-2019
 */
/*
time complexity o(n + m )   where n = total nodes , m = number of relations
 */
public class TopologicalSort {


    static class GraphNode{
        int data;
        boolean isVisited;
        List<GraphNode> neighbours;

        GraphNode(int data){
            this.data=data;
            this.neighbours=new ArrayList<>();

        }

        public void addNeighbours(GraphNode neighbourNode){
            this.neighbours.add(neighbourNode);
        }

        public List<GraphNode> getNeighbours(){
            return neighbours;
        }

        public void SetNeighbours(List<GraphNode> neighbours){
            this.neighbours=neighbours;
        }

        public String toString(){
            //System.out.println(data);
            return ""+data;
        }
    }

    public static void main(String[] args) {


        TopologicalSort topological = new TopologicalSort();
        GraphNode node40 =new GraphNode(40);
        GraphNode node10 =new GraphNode(10);
        GraphNode node20 =new GraphNode(20);
        GraphNode node30 =new GraphNode(30);
        GraphNode node60 =new GraphNode(60);
        GraphNode node50 =new GraphNode(50);
        GraphNode node70 =new GraphNode(70);

        node40.addNeighbours(node10);
        node40.addNeighbours(node20);
        node10.addNeighbours(node30);
        node20.addNeighbours(node10);
        node20.addNeighbours(node30);
        node20.addNeighbours(node60);
        node20.addNeighbours(node50);
        node30.addNeighbours(node60);
        node60.addNeighbours(node70);
        node50.addNeighbours(node70);

        System.out.println("Topological Sorting Order:");
        topological.topologicalSort(node40);

        // Print contents of stack
        Stack<GraphNode> resultStack=topological.stack;
        while (resultStack.empty()==false)
            System.out.print(resultStack.pop() + " ");
    }

    Stack<GraphNode> stack ;

    public TopologicalSort(){
        this.stack=new Stack<>();
    }

    //recursive topological sorting
    public void topologicalSort(GraphNode n){
        List<GraphNode> neighbours = n.getNeighbours();
        for(int i=0;i<neighbours.size();i++){
            GraphNode neighbour = neighbours.get(i);
            if(neighbour!=null && !neighbour.isVisited){
                topologicalSort(neighbour);
                neighbour.isVisited=true;
            }
        }
        stack.push(n);
    }


}


