/*Created by ${USER} on ${DATE}.
 *���⣺��������pairs�ڲ����� [1,2][2,3][3,4] �ҳ�[a,b][c,d] b<c �������pairs����󳤶ȣ�[1,2][3,4]
 *ע�⣺
 *˼·����̬�滮����ֹ����ǰλ�� ���γɵķ���Ҫ�������pairs�ĳ���
 *һˢ�� ����ѭ�� һλdp
 *��ˢ��
 *���Ӷȷ�����
 *��˼��
 */

//��һ��
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