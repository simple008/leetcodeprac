/*Created by ${USER} on ${DATE}.
 *题意：数组中有一个数字出现一次 其它出现三次 找出这个数字
 *注意：
 *思路：二进制各位数字之和 mod3 得到的是这个数
 *一刷：
 *二刷： 建一个32位的数组 （int就是32 位） 遍历所有数字的第i位 result 异或 现在的值
 *复杂度分析：
 *反思：
 */


//
public class Solution {
    public int singleNumber(int[] nums) {
        int bit[]=new int[32];
        int result=0;

        for(int i=0;i<32;i++){
            for(int n:nums){
                if(((n>>i)&1)==1)
                    bit[i]+=1;
            }
            result|=(bit[i]%3)<<i;
        }
        return result;
    }
}