package jiaojiang.leetcode2.onlinejudge;

import java.util.List;
import java.util.ArrayList;

/**
 * @author: zhang
 * @since: Jan 1, 2014 11:20:05 PM
 */
public class Interval {
    int start;
    int end;
    Interval() {
        start = end = 0;
    }

    Interval(int s, int e) {
        start = s;
        end = e;
    }

    public String toString() {
        return "[" + start + ", " + end + "]";
    }

    public static List<Interval> getSampleIntervals() {
        List<Interval> ret = new ArrayList<Interval>();
        ret.add(new Interval(1, 3));
        ret.add(new Interval(2, 6));
        ret.add(new Interval(5, 9));
        ret.add(new Interval(8, 10));
        ret.add(new Interval(15, 18));

        return ret;
    }

    public static List<Interval> getSampleIntervals2() {
        List<Interval> ret = new ArrayList<Interval>();
        ret.add(new Interval(1, 4));
        ret.add(new Interval(4, 5));

        return ret;
    }

    public static List<Interval> getSampleIntervals3() {
        List<Interval> ret = new ArrayList<Interval>();
        ret.add(new Interval(1, 4));
        ret.add(new Interval(2, 3));

        return ret;
    }
}
