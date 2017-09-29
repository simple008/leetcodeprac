/*Created by ${USER} on ${DATE}.
 *题意：两个单词可以进行 针对每一个位置 可以进行增删改 找出一个字符串变成另一个字符串的最小步数
 *注意：二维矩阵一定要画对  一定要画对，做好矩阵的初始化
 *思路：建立一个[m+1][n+1]的矩阵，记录i——j需要的变化次数，如果两个位置字符相同dp[i][j]=dp[i-1][j-1] 不相同则取
 * 左 上的三个位置中最小值+1
 *一刷：
 *二刷：还是矩阵画错了，矩阵初始化错了。第一行地一列的初始化初始化成坐标值 i  j
 *复杂度分析：
 *反思：
 */
//第一次
public class Solution {
    public int minDistance(String word1, String word2) {
        if(word1==null||word2==null) return 0;
        int len1=word1.length();
        int len2=word2.length();
        int [][]distance=new int[len1+1][len2+1];
        for(int i=1;i<len1+1;i++){
            distance[i][0]=i;
        }
        for(int i=1;i<len2+1;i++){
            distance[0][i]=i;
        }
        for(int i=1;i<len1+1;i++){
            for(int j=1;j<len2+1;j++){
                if(word1.charAt(i-1)==word2.charAt(j-1))
                    distance[i][j]=distance[i-1][j-1];
                else{
                    distance[i][j]=Math.min(distance[i-1][j-1],Math.min(distance[i][j-1],distance[i-1][j]))+1;
                }
            }
        }
        return distance[len1][len2];
    }
}


//第二次
public class Solution {
    public int minDistance(String word1, String word2) {
        int m=word1.length();
        int n=word2.length();
        if(m==0||n==0){
            return m==0?n:m;
        }
        int dp[][]=new int [m+1][n+1];
        for (int i=1;i<m+1;i++)
            dp[i][0]=i;
        for(int j=1;j<n+1;j++)
            dp[0][j]=j;

        for(int i=1;i<m+1;i++){
            for(int j=1;j<n+1;j++){
                if(word1.charAt(i-1)==word2.charAt(j-1))
                    dp[i][j]=dp[i-1][j-1];
                else{
                    dp[i][j]=Math.min(dp[i-1][j-1],Math.min(dp[i][j-1],dp[i-1][j]))+1;
                }
            }
        }
        return dp[m][n];
    }
}