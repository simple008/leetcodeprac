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
     * ���������Ԫ�ض��ǽ���0..k֮���
     * @param data ����������
     * @param k ���Ԫ��
     * @return ������
     */
    public static int[] sort(int[] data, int k) {
        // �����ʱ���ݵ�����tmp����ʼԪ�ض���0��kΪ���������Ԫ��
        int[] tmp = new int[k + 1];

        // ����������ÿ��Ԫ��i���ֵĴ�������������tmp�еĵ�i���ԭ�����е�Ԫ��ֵΪtmp�����е��±�
        for (int i = 0; i <= data.length - 1; i++) {
            tmp[data[i]]++;
        }
        // ����������С�ڵ���ÿ��Ԫ�صĸ���,����tmp�еĵ�һ��Ԫ�ؿ�ʼ��ÿһ���ǰһ�����
        for (int j = 1; j <= k; j++) {
            tmp[j] = tmp[j] + tmp[j - 1];
        }
        // result�������������������
        int[] result = new int[data.length];
        for (int i = data.length - 1; i >= 0; i--) {
            result[tmp[data[i]] - 1] = data[i];
            tmp[data[i]]--;
        }
        return result;
    }
}
