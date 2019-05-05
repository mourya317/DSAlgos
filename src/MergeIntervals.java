import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {
    public static void main(String[] args) {
        List<Interval> intervals = new ArrayList<>();
        /*intervals.add(new Interval(15,18));
        intervals.add(new Interval(2,6));
        intervals.add(new Interval(1,3));
        intervals.add(new Interval(8,10));*/

        intervals.add(new Interval(94230,94299));
        intervals.add(new Interval(94289,94699));
        intervals.add(new Interval(94200,94240));
        intervals.add(new Interval( 94133,94133));

        merge(intervals);
    }

    private static List<Interval> merge(List<Interval> intervals){
        List<Interval> result = new ArrayList<>();
        if(intervals == null || intervals.size() == 0){
            return result;
        }

        //sort intervals based on left elements
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                if(o1.l > o2.l){
                    return 1;
                }else{
                    return -1;
                }
            }
        });

        print(intervals);

        //Check if the interval overlaps then merge
        Interval prev = intervals.get(0);
        for(int i = 0 ; i<intervals.size();i++){
            Interval curr = intervals.get(i);
            if(curr.l>prev.j){ // if prev is not able to merge with next intervals, add to result.
                result.add(prev);
                prev = curr;
            }else{  // save merged interval in prev.
                Interval merged = new Interval(prev.l, Math.max(prev.j, curr.j));
                prev = merged;
            }
        }
        result.add(prev);

        System.out.println("result-----");
        print(result);
        return result;

    }

    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> result = new ArrayList<>();

        if (intervals.size() == 0) {
            result.add(newInterval);
            return result;
        }

        int p = helper(intervals, newInterval);
        result.addAll(intervals.subList(0, p));

        for (int i = p; i < intervals.size(); i++) {
            Interval interval = intervals.get(i);
            if (interval.j < newInterval.l) {
                result.add(interval);
            } else if (interval.l > newInterval.j) {
                result.add(newInterval);
                newInterval = interval;
            } else if (interval.j >= newInterval.l || interval.l <= newInterval.j) {
                newInterval = new Interval(Math.min(interval.l, newInterval.l), Math.max(newInterval.j, interval.j));
            }
        }

        result.add(newInterval);

        return result;
    }

    public int helper(List<Interval> intervals, Interval newInterval) {
        int low = 0;
        int high = intervals.size() - 1;

        while (low < high) {
            int mid = low + (high - low) / 2;

            if (newInterval.l <= intervals.get(mid).l) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return high == 0 ? 0 : high - 1;
    }

    private static class Interval {
        int l;
        int j;

        public Interval(int l, int j) {
            this.l = l;
            this.j = j;
        }

        public int getJ() {
            return j;
        }

        public void setJ(int j) {
            this.j = j;
        }

        public int getL() {
            return l;
        }

        public void setL(int l) {
            this.l = l;
        }
    }

    private static void print(List<Interval> intervals){
        for(Interval i:intervals){
            System.out.println("["+i.l+","+i.j+"]");
        }
    }
}
