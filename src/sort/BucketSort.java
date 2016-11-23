package sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;

/**
 * Created by lpeiz on 2016/11/23.
 */
public class BucketSort {

    public static void main(String[] args) {
        double array[] = { 0.78, 0.17, 0.39, 0.26, 0.72, 0.94, 0.26, 0.12,
                0.23, 0.68 };
        bucketSort(array);
        System.out.println(Arrays.toString(array));
    }
    public static void bucketSort(double array[]) {
        int length = array.length;
        ArrayList arrList[] = new ArrayList[length];
        for (int i = 0; i < length; i++) {
            //0.7到0.79放在第8个桶里,编号7；第一个桶放0到0.09
            int temp = (int) Math.floor(10 * array[i]);
            if (null == arrList[temp])
                arrList[temp] = new ArrayList();
            arrList[temp].add(array[i]);
        }
        // 对每个桶中的数进行插入排序
        for (int i = 0; i < length; i++) {
            if (null != arrList[i]) {
                Collections.sort(arrList[i]);
            }
        }
        int count = 0;
        for (int i = 0; i < length; i++) {
            if (null != arrList[i]) {
                Iterator iter = arrList[i].iterator();
                while (iter.hasNext()) {
                    Double d = (Double) iter.next();
                    array[count] = d;
                    count++;
                }
            }
        }
    }
}
