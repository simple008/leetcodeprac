package leetcoe_test;

import java.util.HashMap;

/**
 * Created by lpeiz on 2017/5/21.
 */
public class slope {
    static class Point {
        int x;
        int y;
        Point() {
            x = 0;
            y = 0;
        }
        Point(int a, int b) {
            x = a;
            y = b;
        }

    }
    public static void main(String[] args){
        Point a = new Point(0,0);
        Point b = new Point(94911151,94911150);
        Point c = new Point(94911152,94911151);
        Point[] points = new Point[3];

        points[0]=a;
        points[1]=b;
        points[2]=c;

        slope test = new slope();
        System.out.println(test.maxPoints(points));
    }
    public int maxPoints(Point[] points) {
        if(points == null || points.length == 0) return 0;
        HashMap<Double,Integer> map = new HashMap<Double,Integer>(points.length);
        int max = 0;
        int len = points.length;
        int dul = 0;

        for(int i = 0; i < len; i++){
            map.clear();
            dul = 0;
            for(int j = i+1; j < len; j++){
                if(points[i].x == points[j].x && points[i].y == points[j].y){
                    dul++;
                    continue;
                }
                double slope = 0.0;
                // if(points[i].x == points[j].x)
                //     slope = Double.POSITIVE_INFINITY;
                // else slope = (double)(points[i].y - points[j].y) / (double)(points[i].x - points[j].x);

                if (points[j].y == points[i].y) slope = 0.0;
                else if (points[j].x == points[i].x) slope = Double.POSITIVE_INFINITY;
                else slope = (double)(points[j].y - points[i].y) / (double)(points[j].x - points[i].x);

                if(map.containsKey(slope))
                    map.put(slope,map.get(slope)+1);
                else map.put(slope,2);
            }
            max = Math.max(max,dul+1);
            for(int count : map.values())
                max = Math.max(max,count+dul);
        }
        return max;
    }
}
