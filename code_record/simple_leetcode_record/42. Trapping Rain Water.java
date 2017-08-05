/*Created by ${USER} on ${DATE}.
 *题意：坐标系 方形柱体 盛水问题，
 *注意：
 *思路：牛客有讲过 记录左右两侧的最大值，较小的一侧是盛水的限制，从这一侧开始比较。
 *一刷：
 *二刷：注意while(i<=j) 如果没有= 相等的情况是可能出现的，出现的时候无法处理。
 * 比如[2,0,2] 一开始的时候i j就是相同的 这时候就没法处理
 *复杂度分析：O(n)
 *反思：
 *
 *
 */
//第一次  思路一样
public class Solution {
    public int trap(int[] height) {
        if(height==null||height.length==0) return 0;
        int Lmax=height[0];
        int Rmax=height[height.length-1];
        int i=1,j=height.length-2;
        int count=0;
        while(i<=j){
            if(Lmax<=Rmax){
                if(height[i]<=Lmax)
                    count+=(Lmax-height[i++]);
                else Lmax=height[i++];
            }
            else{
                if(height[j]<=Rmax)
                    count+=(Rmax-height[j--]);
                else Rmax=height[j--];
            }
        }
        return count;
    }
}


//第二次

public class Solution {
    public int trap(int[] height) {
        int total=0;
        if(height.length<=2) return 0;
        int lMax=height[0];
        int rMax=height[height.length-1];
        int i=1,j=height.length-2;
        while(i<=j){
            if(lMax<=rMax){
                if(height[i]<lMax){
                    total+=lMax-height[i];
                    i++;
                }else{
                    lMax=height[i];
                    i++;
                }
            }else{
                if(height[j]<rMax){
                    total+=rMax-height[j];
                    j--;
                }else{
                    rMax=height[j];
                    j--;
                }
            }
        }
        return total;
    }
}
/*
没仔细看
    O(1) space的方法来自Discuss里的@shpolsky

1. 这里我们一次遍历数组， 主要使用一个变量countDown来记录遍历时遇到的递减序列
2. 当ratings[i] < ratings[i - 1]时，我们遇到的就是递减序列，这时我们countDown增加一，
3. 否则，ratings[i] >= ratings[i - 1]，大于或者等于这两种情况里，我们都需要对之前遇到的递减情况进行处理
     1.处理之前含有递减序列的情况
        1.这里我们用prev这个变量记录了递减序列排头元素peak，有多少块糖
        2. 然后我们利用等差数列求和公式来计算这整个递减序列里我们需要补发多少块糖，countDown是长度n，也是最后一个元素an
        3. 之后还要判断，当countDown >= peak的时候，就是这个递减序列里，需要最多块糖的元素和peak的当前糖数比较，假如peak的糖数少，我们要给peak补充countDown - prev + 1块糖，或者理解为把peak所在位置的糖数从 prev 替换为 countDown + 1。
     2. 接下来我们处理一般情况，就是 ratings[i] = ratings[i - 1]时，prev为1，否则prev加1，我们再把prev添加到结果total中
4. 最后也要判断一下，是否数组最后的一部分为递减序列，假如是，则按照之前的代码处理。
5. 返回结果。*/
public class Solution {
    public int candy(int[] ratings) {
        if (ratings == null || ratings.length == 0) return 0;
        int total = 1, prev = 1, countDown = 0;

        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] >= ratings[i - 1]) {
                if (countDown > 0) {
                    total += countDown * (countDown + 1) / 2;
                    if (countDown >= prev) total += countDown - prev + 1;
                    countDown = 0;
                    prev = 1;
                }
                prev = (ratings[i] == ratings[i - 1]) ? 1 : prev + 1;
                total += prev;
            } else countDown++;
        }

        if (countDown > 0) {
            total += countDown * (countDown + 1) / 2;
            if (countDown >= prev) total += countDown - prev + 1;
        }

        return total;
    }
}