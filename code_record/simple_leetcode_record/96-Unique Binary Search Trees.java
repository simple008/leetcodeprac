/*Created by ${USER} on ${DATE}.
 *题意：计算n个节点的二叉树有多少种
 *注意：
 *思路：左节点的种类乘右节点的种类，遍历各种情况，当总节点数确定时 一确定左子树右子树随之确定
 *一刷：
 *二刷：
 *复杂度分析：
 *反思：
 */
//第一次
public class Solution {
    public int numTrees(int n) {
        int [] a=new int[n+1];
        a[0]=1;
        a[1]=1;
        for(int i=2;i<=n;i++){
            for(int j=0;j<i;j++){
                a[i]+=a[j]*a[i-j-1];
            }
        }
        return a[n];
    }
}


//第二次
public class Solution {
    public int numTrees(int n) {
        int a[]=new int [n+1];
        a[0]=1;
        a[1]=1;
        for(int i=2;i<n+1;i++){
            for(int j=0;j<i;j++){
                a[i]+=a[j]*a[i-j-1];
            }
        }
        return a[n];
    }
}