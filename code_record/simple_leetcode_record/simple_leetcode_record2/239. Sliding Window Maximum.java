/*Created by ${USER} on ${DATE}.
 *题意：滑动窗口 求最大值  剑指offer 原题
 *注意：
 *思路：用队列来控制范围 对列中的元素在窗口范围内，同时第一个元素是最大的  超出窗口范围是弹出
     *  如果当前值比队尾元素小直接入队（在之后可能成为最大的），比队尾元素大 不断将队尾出队找到队尾元素变大
 *一刷：用Deque
 *二刷：
 *复杂度分析：
 *反思：
 */

//剑指offer
import java.util.*;
public class Test65 {
    private static List<Integer> maxInWindows(List<Integer> data, int size) {
        List<Integer> windowMax = new LinkedList<>();
        // 条件检查
        if (data == null || size < 1 || data.size() < 1) {
            return windowMax;
        }
        Deque<Integer> idx = new LinkedList<>();
        // 窗口还没有被填满时，找最大值的索引
        for (int i = 0; i < size && i < data.size(); i++) {
            // 如果索引对应的值比之前存储的索引值对应的值大或者相等，就删除之前存储的值
            while (!idx.isEmpty() && data.get(i) >= data.get(idx.getLast())) {
                idx.removeLast();
            }
            //  添加索引
            idx.addLast(i);
        }
        // 窗口已经被填满了
        for (int i = size; i < data.size(); i++) {
            // 第一个窗口的最大值保存
            windowMax.add(data.get(idx.getFirst()));
            // 如果索引对应的值比之前存储的索引值对应的值大或者相等，就删除之前存储的值
            while (!idx.isEmpty() && data.get(i) >= data.get(idx.getLast())) {
                idx.removeLast();
            }
            // 删除已经滑出窗口的数据对应的下标
            if (!idx.isEmpty() && idx.getFirst() <= (i - size)) {
                idx.removeFirst();
            }
            // 可能的最大的下标索引入队
            idx.addLast(i);
        }
        // 最后一个窗口最大值入队
        windowMax.add(data.get(idx.getFirst()));
        return windowMax;
    }
    private static List<Integer> arrayToCollection(int[] array) {
        List<Integer> result = new LinkedList<>();
        if (array != null) {
            for (int i : array) {
                result.add(i);
            }
        }
        return result;
    }