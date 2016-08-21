package LinkedInQuestions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by rmukherj on 8/20/16.
 */
public class IntervalsImp implements Intervals {
    List<Point> list = new ArrayList<Point>();

    @Override
    public void addInterval(int from, int to) {
        list.add(new Point(from,to));

    }

    @Override
    public int getTotalCoveredLength() {
        Collections.sort(list);
        int totalLen = 0;
        Point lastPoint = new Point(0,0);
        for(Point point:list){

        }

        return 0;
    }
}

class Point implements Comparable<Point> {

    public int x, y;


    Point(int x, int y) {
        if (x > y)
            throw new IllegalArgumentException("x can't be greater than y");

        this.x = x;
        this.y = y;
    }


    @Override
    public int compareTo(Point o) {
        return o == null ? 0 : (this.x - o.x);
    }
}
