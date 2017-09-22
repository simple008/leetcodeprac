/*Created by ${USER} on ${DATE}.
 *题意：乱序数组，找到排序只有相邻两个数相差最大的值 gap
 *注意：
 *思路：分桶，桶的个数等于数组长度，记录每个桶的最大值，最小值。遍历数组把数字放入相应的桶中。最大的gap一定是出现在
 * 后一个桶的最小值和前一个桶的最大值下。 如果在一个桶内那这个范围一定小于桶的长度，那么一定出现一个空桶使gap变大
 *一刷：
 *二刷：
 *复杂度分析：
 *反思：
 */

//第一次
public class Solution {
    public int maximumGap(int[] num) {
        if (num == null || num.length < 2)
            return 0;
        // get the max and min value of the array
        int min = num[0];
        int max = num[0];
        for (int i:num) {
            min = Math.min(min, i);
            max = Math.max(max, i);
        }
        // the minimum possibale gap, ceiling of the integer division
        int gap = (int)Math.ceil((double)(max - min+1)/(num.length));

        int[] bucketsMIN = new int[num.length ]; // store the min value in that bucket
        int[] bucketsMAX = new int[num.length ]; // store the max value in that bucket
        Arrays.fill(bucketsMIN, Integer.MAX_VALUE);
        Arrays.fill(bucketsMAX, Integer.MIN_VALUE);
        // put numbers into buckets
        for (int i:num) {
           /* if (i == min || i == max)
                continue;*/
            int idx = (i - min) / gap; // index of the right position in the buckets
            bucketsMIN[idx] = Math.min(i, bucketsMIN[idx]);
            bucketsMAX[idx] = Math.max(i, bucketsMAX[idx]);
        }
        // scan the buckets for the max gap
        int maxGap = Integer.MIN_VALUE;
        int previous = min;
        for (int i = 0; i < num.length; i++) {
            if (bucketsMIN[i] == Integer.MAX_VALUE && bucketsMAX[i] == Integer.MIN_VALUE)
                // empty bucket
                continue;
            // min value minus the previous value is the current gap
            maxGap = Math.max(maxGap, bucketsMIN[i] - previous);
            // update previous bucket value
            previous = bucketsMAX[i];
        }
        maxGap = Math.max(maxGap, max - previous); // updata the final max value gap
        return maxGap;
    }
}

//第二次

