/*Created by ${USER} on ${DATE}.
 *题意：链式 pair的最大长度
 *注意：
 *思路：
 *一刷：
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
                max = Math.max(max, dp[i]);
            }
        }
        return max;
    }
}