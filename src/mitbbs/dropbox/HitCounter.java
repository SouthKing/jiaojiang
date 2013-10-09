package mitbbs.dropbox;

import jiaojiang.utils.Utils;

import java.util.Random;

/**
 * @author: zhang
 * @since: Oct 8, 2013 10:12:37 PM
 */
/*
Write a counter function, which return the number of function call hit() in past 5 minutes

Two functions:
void hit()
long getHits() // counter function
 */
public class HitCounter {

    private int[] circularBuffer = new int[5 * 60 + 1];
    //circular buffer
    public void hit() {

    }

    public long getHits() {
        long hits = 0;
        for (int i : circularBuffer) {
            hits += i;
        }

        return hits;
    }

    public static void test() throws InterruptedException {
        int totalTime = 0;
        HitCounter hc = new HitCounter();
        long timeRange = 2 * 5 * 60 * 1000;
        long count = 0;
        Random r = new Random();
        while (totalTime < timeRange) {
            int t = r.nextInt(5000);
            Thread.sleep(t);
            totalTime += t;
            hc.hit();
            count++;
        }

        Utils.println(hc.getHits(), count);
    }

    public static void main(String[] args) throws InterruptedException {
        test();
    }
}
