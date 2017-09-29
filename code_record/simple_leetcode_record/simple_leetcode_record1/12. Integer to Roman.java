/*Created by ${USER} on ${DATE}.
*题意：把正数转成罗马数字，感觉没什么意思 不再做了
*思路：要知道罗马数字和正数数字的转换规则 把所有罗马字母组合都表示出来  尤其是900 400 90 40 9 4这种东西
*一刷：
*二刷：
*复杂度分析：
*反思：
*/


public String intToRoman(int number) {
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
        String[] numerals = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };
        StringBuilder result = new StringBuilder();
             for (int i = 0; i < values.length; i++) {
                 while (number >= values[i]) {
                     number -= values[i];
                     result.append(numerals[i]);
                 }
             }
             return result.toString();
        }