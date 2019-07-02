package Trees;

import java.util.*;

/**
 * @author Mourya Balla
 * @project Practice
 * @CreatedOn 30-05-2019
 */

/*

[[1, 5, 11], [2, 7, 6], [3, 9, 13], [12, 16, 7], [14, 25, 3],
 [19, 22, 18], [23, 29, 13], [24, 28, 4]]

 Treat start and edge points separately and sort them .
 add to MAX heap one by one and track the height heap

 */
public class SkylineProblem {


    public static void main(String[] args) {
        int[][] bs0 = {

                {1, 5, 11},

                {2, 7, 6},

                {3, 9, 13},

                {12, 16, 7},

                {14, 25, 3},

                {19, 22, 18},

                {23, 29, 13},

                {24, 28, 4}

        };

        List<Point> result = getSkyline(bs0);
        System.out.println("hello");
        //printList(result);
    }

    static class Edge{
        int x;
        int y;
        int h;
        boolean isStart;

        Edge(int x, int y , int h,boolean isStart){
            this.x=x;
            this.y=y;
            this.h=h;
            this.isStart=isStart;
        }
    }

    //Create edges

    static class Point {
        int x;
        int h;
        boolean isStart;

        Point(int x, int h, boolean isStart) {
            this.isStart = isStart;
            this.x = x;
            this.h = h;
        }
    }


        public static List<Point> getSkyline(int[][] buildings){
            //process building 2d array
            List<Point> points = processBuildings(buildings);
            Collections.sort(points, new Comparator<Point>() {
                @Override
                public int compare(Point o1, Point o2) {
                    if(o1.x != o2.x){
                        return Integer.compare(o1.x , o2.x);
                    }

                    if(o1.isStart && o2.isStart){
                        return Integer.compare(o2.h, o1.h);
                    }

                    if(!o1.isStart && !o2.isStart){
                        return Integer.compare(o1.h, o2.h);
                    }
                    return o1.isStart?1:-1;

                }
            });
            List<Point> result = new ArrayList<>();
            //Logic is to add all the points one by one from left to right
            /*
            add to height heap , if start add to heap , else remove
             */
            PriorityQueue<Integer> heightHeap = new PriorityQueue<>(10, Collections.reverseOrder());

            for(Point p:points){
                if(p.isStart){
                    if(heightHeap.isEmpty() || p.h > heightHeap.peek()){
                        //add to result
                        result.add(p);
                    }
                    heightHeap.add(p.h);
                }else {
                    //remove that point
                    heightHeap.remove(p.h);
                    //if heap is empty add 0 point
                    if(heightHeap.isEmpty()){
                        result.add(new Point(p.x,0,false));
                    }else if(p.h > heightHeap.peek()){ //edge case
                        result.add(new Point(p.x,heightHeap.peek(),false));
                    }
                }
            }
            return result;
        }

        private static List<Point> processBuildings(int[][] buildings) {
            List<Point> points = new ArrayList<>();
            int size = buildings.length;
            for(int i=0;i<size;i++){
                int[] building = buildings[i];
                points.add(new Point(building[0],building[2],true));//start Edge
                points.add(new Point(building[1],building[2],false)); //endEdge
            }
            return points;
        }

    }




