package LinkedInQuestions;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by rmukherj on 8/20/16.
 */
interface Intervals {

    /**
     * Adds an interval [from, to] into internal structure.
     */
    void addInterval(int from, int to);


    /**
     * Returns a total length covered by intervals.
     * If several intervals intersect, intersection should be counted only once.
     * Example:
     *
     * addInterval(3, 6)
     * addInterval(8, 9)
     * addInterval(1, 5)
     *
     * getTotalCoveredLength() -> 6
     * i.e. [1,5] and [3,6] intersect and give a total covered interval [1,6]
     * [1,6] and [8,9] don't intersect so total covered length is a sum for both intervals, that is 6.
     *
     *                   _________
     *                                               ___
     *     ____________
     *
     * 0  1    2    3    4    5   6   7    8    9    10
     *
     */
    int getTotalCoveredLength();
}

public class IntervalImpl implements Intervals{

    static class Node implements Comparable<Node>{
        int f;
        int t;

        Node(int _f, int _t){
            this.f = _f;
            this.t = _t;
        }

        @Override
        public int compareTo(Node o) {
            return this.f -o.f; // order by from
        }

        public boolean checkAndUpdateIfIntersects(Node o){
            if(o.f < this.t && o.t > this.t ){
                this.t = o.t;
                return true;
            }
            else if(o.f < this.f && o.t > this.f){
                this.f=o.f;
                return true;
            }
            else if(o.f < this.f && o.t < this.t)  return true;
            else return false;

        }

        public int getLen(){
            return this.t - this.f;
        }
    }

    List<Node> nodes = new LinkedList<Node>();
    int len = 0;
    @Override
    public void addInterval(int from, int to) {
        boolean flag = false;
        Node obj = new Node(from,to);
        for(Node n : nodes){
            int oldLen = n.getLen();
            flag = n.checkAndUpdateIfIntersects(obj);
            if(flag){
                len += n.getLen() - oldLen;
                return;
            }
        }
        nodes.add(obj);
        len += obj.getLen();
    }

    @Override
    public int getTotalCoveredLength() {
        return len;
    }

    public static void main(String... args){
        IntervalImpl obj = new IntervalImpl();
        obj.addInterval(3, 6);
        obj.addInterval(8, 9);
        obj.addInterval(1, 5);
        System.out.println(obj.getTotalCoveredLength());
    }
}
