/*Created by ${USER} on ${DATE}.
 *题意：找出最短的回文字符串
 *注意：
 *思路：
 *一刷：
 *二刷：
 *复杂度分析：
 *反思：
 */

//第一次
    int j = 0;
            for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == s.charAt(j)) { j += 1; }
            }
            if (j == s.length()) { return s; }
            String suffix = s.substring(j);
            return new StringBuffer(suffix).reverse().toString() + shortestPalindrome(s.substring(0, j)) + suffix;


