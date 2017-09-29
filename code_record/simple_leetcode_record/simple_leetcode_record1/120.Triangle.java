/*Created by ${USER} on ${DATE}.
 *题意：给定一个三角,找到从顶层到底层和最短的路径
 *注意：
 *思路：构建一个数组 从底层向上遍历，如果从上向下遍历会出现问题，数组的末尾都是0，那么每一层最后一个都会得到从0过来的路径和
 * 同时数组长度要是层高加1，不然最后一层的最后一个会越界
 *一刷：
 *二刷：
 *复杂度分析：
 *反思：
 */

//第一次

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

//第二次

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