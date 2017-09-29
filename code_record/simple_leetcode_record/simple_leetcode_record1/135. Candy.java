/*Created by ${USER} on ${DATE}.
 *题意：N个孩子站一排，每人都有评级。分糖，每人至少一块，评级高的必须比相邻的评级低的孩子分的多。最少需要多少糖
 *注意：
 *思路：每人确保一块糖。比较两轮，先确保分数高的人比前面的分数低的人多。再确保分数高的人比后面分数低的人多。
 *一刷：O(N)space
 *二刷：O(1)space  这个方法就比较牛逼了
 *复杂度分析：
 *反思：
 */
//第一次
public class Solution {
    public int candy(int[] rating) {
        int len=rating.length;
        int [] candy=new int[len];
        for(int i=0;i<len;i++){
            candy[i]=1;
        }
        for(int i=1;i<len;i++){
            if(rating[i]>rating[i-1])
                candy[i]=candy[i-1]+1;
        }
        for(int i=len-2;i>=0;i--){
            if((rating[i]>rating[i+1])&&(candy[i]<=candy[i+1]))
                candy[i]=candy[i+1]+1;
        }
        int num=0;
        for(int i=0;i<len;i++){
            num+=candy[i];
        }
        return num;
    }
}