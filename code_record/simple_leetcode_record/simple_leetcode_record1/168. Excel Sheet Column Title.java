/*Created by ${USER} on ${DATE}.
 *题意：数字变成excel的栏目编码方式
 *注意：
 *思路：
 *一刷：
 *二刷： 注意n--的操作！！ 核心就是进位 跟26进制不完全一样，表示1-26 而26进制表示0-25 需要--之后才能对应过去
 *复杂度分析：
 *反思：
 */
//第一次

public class Solution {
    public String convertToTitle(int n) {
        String a="";
        if(n<=0) return "" ;

        while(n>0)
        {   n--;
            a =String.valueOf((char)(n%26+65)+a);
            n=n/26;
        }
        return a;
    }
}
//第二次
class Solution {
    public String convertToTitle(int n) {
        StringBuffer sb = new StringBuffer();

        while(n>0){
            n--;
            sb.insert(0, (char)('A' + n % 26));
            n = n /26;
        }
        return sb.toString();
    }
}

public class Solution {
    public String convertToTitle(int n) {
        return n == 0 ? "" : convertToTitle(--n / 26) + (char)('A' + (n % 26));
    }

}