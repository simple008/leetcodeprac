/*Created by ${USER} on ${DATE}.
 *���⣺����һ������,�ҵ��Ӷ��㵽�ײ����̵�·��
 *ע�⣺
 *˼·������һ������ �ӵײ����ϱ���������������±�����������⣬�����ĩβ����0����ôÿһ�����һ������õ���0������·����
 * ͬʱ���鳤��Ҫ�ǲ�߼�1����Ȼ���һ������һ����Խ��
 *һˢ��
 *��ˢ��
 *���Ӷȷ�����
 *��˼��
 */

//��һ��

public class Solution {
    public int minimumTotal(List<List<Integer>> trgl) {
        int sz = trgl.size();
        int[] results = new int[sz+1];
        for(int i=sz-1; i>=0; i--) {
            List<Integer> tmp = trgl.get(i);

            for(int j=0; j<tmp.size(); j++) {
                results[j] = Math.min(results[j], results[j+1]) + tmp.get(j);
            }
        }
        return results[0];
    }
}

//�ڶ���

public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int len = triangle.size();
        int sum[] = new int [len+1];
        for(int i = len-1; i >= 0; i-- ){
            List<Integer> list = triangle.get(i);
            for(int j =0; j < list.size(); j++ ){
                sum [j] = Math.min(sum[j], sum[j+1]) + list.get(j);
            }
        }
        return sum[0];
    }
}