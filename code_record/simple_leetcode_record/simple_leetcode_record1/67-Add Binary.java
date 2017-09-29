/*Created by ${USER} on ${DATE}.
 *题意：二进制字符串相加
 *注意：
 *思路：记 当前位两个值的和，对2取余，作为本位的值 通过取整来标识进位值 取整是1则进位
 *一刷：
 *二刷：没做出来，考虑的太复杂 分了各种情况  注意漏的情况
 *复杂度分析：
 *反思：
 */

//第一次

public class Solution {
    public String addBinary(String a, String b) {
        StringBuilder sb=new StringBuilder();
        int i=a.length()-1;
        int j=b.length()-1;
        int carry=0;
        int sum=0;
        while(i>=0||j>=0)
        {
            sum=carry;
            if(i>=0) sum+=a.charAt(i--)-'0';
            if(j>=0) sum+=b.charAt(j--)-'0';
            sb.insert(0,sum%2);
            carry=sum/2;
        }
        if(carry!=0)sb.insert(0,carry);
        return sb.toString();
    }
}

//第二次
public class Solution {
    public String addBinary(String a, String b) {
        int i=a.length()-1;
        int j=b.length()-1;
        int sum=0;
        int carry=0;
        StringBuilder sb=new StringBuilder();
        while(i>=0||j>=0){

            sum+=carry;
            if(i>=0) sum+=a.charAt(i--)-'0';  //把-'0'漏掉了！！！
            if(j>=0) sum+=b.charAt(j--)-'0';
            sb.insert(0,sum%2);
            carry=sum/2;
            sum=0;
        }
        if(carry!=0) sb.insert(0,'1');
        return sb.toString();
    }
}