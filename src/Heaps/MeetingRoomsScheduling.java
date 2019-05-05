package Heaps;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author Mourya Balla
 * @project Practice
 * @CreatedOn 05-05-2019
 */

/*
Given a list of meeting times, checks if any of them overlaps.
The follow-up question is to return the minimum number of rooms required to accommodate all the meetings.
 */
public class MeetingRoomsScheduling {
    public static void main(String[] args) {
        Meeting[] m = new Meeting[5];
        /*m[0] = new Meeting(1,4);
        m[1] = new Meeting(5,6);
        m[2] = new Meeting(8,9);
        m[3] = new Meeting(2,6);*/

        m[0] = new Meeting(2,15);
        m[1] = new Meeting(36,45);
        m[2] = new Meeting(9,29);
        m[3] = new Meeting(16,23);
        m[4] = new Meeting(4,9);


        System.out.println(checkNumberOfOverlaps(m));
        System.out.println(minRooms(m));
    }

    static class Meeting{
        int start;
        int end;
        Meeting(int i,int j){
            this.start = i;
            this.end = j;
        }
        public String toString(){
            return start+"-"+end;
        }
    }

    /*
    sort the meetings by starttimes
    sorting takes nlogn + n
     */
    private static int checkNumberOfOverlaps(Meeting[] meetings){
        int count =0;

        Arrays.sort(meetings, Comparator.comparingInt(x -> x.start));
        for(Meeting m:meetings){
            System.out.println(m.toString());
        }

        int i=0;
        while(i < meetings.length-2){
            if(meetings[i+1].start < meetings[i].end){
                count++;
            }
            i++;
        }
        return count == 0 ? 1:count;
    }

    /*
    nlogn + n = nlogn
     */
    private static int minRooms(Meeting[] meetings){
        if(meetings == null || meetings.length == 0){
            return  0;
        }

        Arrays.sort(meetings , Comparator.comparingInt(x-> x.start));
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        queue.offer(meetings[0].end); // track the end times
        int count =1;
        for(int i=1;i<meetings.length;i++){
            int prev = queue.peek();
            if(prev < meetings[i].end){
                //release the room
                queue.poll();
            }else{
                count++;
            }

            queue.offer(meetings[i].end);
        }

        return count;

    }



}
