/*Created by ${USER} on ${DATE}.
 *题意：数组有序，找到两个元素和等于给定值， 返回值这两个元素的序号，从1开始计数
 *注意：
 *思路：
 *一刷：双指针夹逼
 *二刷：
 *复杂度分析：
 *反思：
 */

public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int i=0;int j=numbers.length-1;
        while(i<j){
            if(numbers[i]+numbers[j]<target)
                i++;
            else if(numbers[i]+numbers[j]>target)
                j--;
            else if(numbers[i]+numbers[j]==target){
                return new int[]{i+1,j+1};
            }
        }
        return new int[]{};
    }
}
//第二次

class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;
        while(left < right){
            if(numbers[left] + numbers[right] > target){
                right--;
            }else if(numbers[left] + numbers[right] == target)
                return new int[]{left + 1, right + 1};
            else
                left++;
        }
        return new int[2];
    }
}