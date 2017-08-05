/*Created by ${USER} on ${DATE}.
 *题意：给定二维平面上的一组点，找出一条直线上最多有多少个点
 *注意：
 *思路：双层循环，遍历，取斜率。hashmap记录斜率和对应的点数，第一次是加两个点，之后没出现相同的斜率加一个点。注意重复的点要记录 每进行一次外循环就要比较一次
 *一刷：
 *二刷：
 *复杂度分析：
 *反思：
 */
//第一次
public class Solution {

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
                else slope = (double)(points[j].y - points[i].y) / (points[j].x - points[i].x);

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