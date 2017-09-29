/*Created by ${USER} on ${DATE}.
 *���⣺����n��k �����1-n ��ɵ���������еĵ�k������
 *ע�⣺
 *˼·��
 *һˢ��
 *��ˢ��
 *���Ӷȷ�����
 *��˼��
 */
 //��һ��
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