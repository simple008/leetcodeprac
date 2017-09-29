/*Created by ${USER} on ${DATE}.
 *题意：给定n和k 输出由1-n 组成的排列组合中的第k个序列
 *注意：
 *思路：
 *一刷：
 *二刷：
 *复杂度分析：
 *反思：
 */
 //第一次
 public class Solution {
     public int calFactorial(int n){
         int ans = 1;
         for(int i = 1; i <= n; i++){
             ans *= i;
         }
         return ans;
     }
     public String getPermutation(int n, int k) {
         StringBuilder s = new StringBuilder("");
         StringBuilder ans = new StringBuilder("");
         int factorial = calFactorial(n);

         for(int i = 1; i <= n; i++){
             s.append(i);
         }
         for(int i = n; i >= 1; i--){
             factorial /= i;

             int index = (k-1) / factorial;
             // String tmp=""+s.charAt(index);
             // ans.append(tmp);
             ans.append(s.charAt(index));
             k = k - index * factorial;
             s = s.deleteCharAt(index);
         }
         return ans.toString();
     }
 }