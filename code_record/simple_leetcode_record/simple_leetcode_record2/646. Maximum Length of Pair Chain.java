/*Created by ${USER} on ${DATE}.
 *题意：给定这种pairs内部有序 [1,2][2,3][3,4] 找出[a,b][c,d] b<c 这种组合pairs的最大长度，[1,2][3,4]
 *注意：
 *思路：动态规划，截止到当前位置 所形成的符合要求的最大的pairs的长度
 *一刷： 两层循环 一位dp
 *二刷：
 *复杂度分析：
 *反思：
 */

//第一次
class Solution {
    public int findLongestChain(int[][] pairs) {
        if(pairs == null || pairs.length == 0) return 0;
        int length = pairs.length;
        int [] dp = new int[length];
        Arrays.sort(pairs, new Comparator<int[]>(){
            public int compare(int[] a, int[]b){
                return a[0] - b [0];
            }

        });
        // for(int )
        dp[0] = 1;
        int max = 0;
        for(int i = 1; i < length; i++){
            for(int j = 0; j <= i; j++ ){
                if(pairs[i][0] > pairs[j][1])
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                else
                    dp[i] = Math.max(dp[i], dp[j]);
                // max = Math.max(max, dp[i]);
            }
        }
        return dp[length-1];
    }
}