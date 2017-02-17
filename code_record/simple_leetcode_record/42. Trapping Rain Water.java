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