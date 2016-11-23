package sort;

import java.util.Arrays;

/**
 * Created by lpeiz on 2016/11/23.
 */
public class CountingSort {
    public static void main(String[] args) throws Exception {
        int[] array = { 9, 9, 8, 8, 7, 5, 3, 2, 6, 0, 5 };
        int[] sort = sort(array, 9);
        System.out.println(Arrays.toString(sort));
    }
    /**
     * 输入数组的元素都是介于0..k之间的
     * @param data 待排序数组
     * @param k 最大元素
     * @return 排序结果
     */
    public static int[] sort(int[] data, int k) {
        // 存放临时数据的数组tmp，初始元素都是0；k为数组中最大元素
        int[] tmp = new int[k + 1];

        // 计算数组中每个元素i出现的次数，存入数组tmp中的第i项，即原数组中的元素值为tmp数组中的下标
        for (int i = 0; i <= data.length - 1; i++) {
            tmp[data[i]]++;
        }
        // 计算数组中小于等于每个元素的个数,即从tmp中的第一个元素开始，每一项和前一项相加
        for (int j = 1; j <= k; j++) {
            tmp[j] = tmp[j] + tmp[j - 1];
        }
        // result数组用来来存放排序结果
        int[] result = new int[data.length];
        for (int i = data.length - 1; i >= 0; i--) {
            result[tmp[data[i]] - 1] = data[i];
            tmp[data[i]]--;
        }
        return result;
    }
}
