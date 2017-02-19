/*Created by ${USER} on ${DATE}.
 *题意：一个数组 每一位都是0-9 开头不是0 代表一个整数  返回这个整数+1的数组
 *注意：
 *思路：记一个进位标识   处理最高位需要进位 原来的数组不能满足要求的情况
 *     因为加1 所以进位的可能只有10 ，可以判断是否==10 来决定进位，如果一开始就不是10 就不会有进位
 *
 *一刷：+1之后 从末位开始判断是否是10 如果不是直接返回，如果是 进行操作，判断当前是不是第0位
 *     如果最后有进位 那么只可能是1..00所以新建的数组也很简单 将首位置1 返回即可
 *二刷：flag 记是否有进位，最开始+1 可以认为是进位  %10 判断是否进位
 *复杂度分析：
 *反思：
 */

//第一次
public class Solution {
    public int[] plusOne(int[] digits) {
        int len=digits.length;
        int index=len-1;
        digits[index]+=1;
        // if (digits[0]==1&&len==1){
        //     //  digits[0]=1;
        //     return digits;
        // }
        while(digits[index]==10)
        {if(index!=0)
        {
            digits[index]=0;
            digits[index-1]+=1;
            index--;
        }
        else if (index==0)
        {
            int []abc=new int[len+1];
            abc[0]=1;
            return abc;
        }
        }

        return digits;
    }
}


//第二次

public class Solution {
    public int[] plusOne(int[] digits) {
        boolean flag=true;
        for(int i=digits.length-1;i>=0;i--){
            if(flag){
                digits[i]+=1;
                if(digits[i]>=10){
                    digits[i]=digits[i]%10;
                    flag=true;
                }
                else flag=false;
            }
        }
        if(!flag) return digits;
        else{
            int []nums=new int[digits.length+1];
            nums[0]=1;
            for(int i=0;i<digits.length;i++)
                nums[i+1]=digits[i];
            return nums;
        }

    }
}