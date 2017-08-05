/*Created by ${USER} on ${DATE}.
 *���⣺������άƽ���ϵ�һ��㣬�ҳ�һ��ֱ��������ж��ٸ���
 *ע�⣺
 *˼·��˫��ѭ����������ȡб�ʡ�hashmap��¼б�ʺͶ�Ӧ�ĵ�������һ���Ǽ������㣬֮��û������ͬ��б�ʼ�һ���㡣ע���ظ��ĵ�Ҫ��¼ ÿ����һ����ѭ����Ҫ�Ƚ�һ��
 *һˢ��
 *��ˢ��
 *���Ӷȷ�����
 *��˼��
 */
//��һ��
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