/*Created by ${USER} on ${DATE}.
 *题意：实现乘方运算
 *注意： 函数递归的套用，以及函数的出口条件
 *思路：递归
 *一刷：
 *二刷：
 *复杂度分析：
 *反思：  1.这两种用法时间差距很多myPow(x,n/2)*myPow(x,n/2)   myPow(myPow(x,n/2),2)
 *         2.要有函数的出口 n==2  否在在循环到最后一次是 会出现pow(x,2) 如果没有2 循环会死
 */
//第一次
public class Solution {
    public double myPow(double x, int n) {
        if(n<0) return 1/x * myPow(1/x, -(n+1));
        if(n==0) return 1;
        if(n==2) return x*x;
        if(n%2==0) return myPow( myPow(x, n/2), 2);
        else return x*myPow( myPow(x, n/2), 2);
    }
}
//第二次
public class Solution {
    public double myPow(double x, int n) {
        if(n<0) return (1/x)*1/myPow(x,-(n+1));
        if(n==0) return 1;
        if(n==2) return x*x;
        // if(n%2==0) return myPow(x,n/2)*myPow(x,n/2);
        // if(n%2==1) return x*myPow(x,n/2)*myPow(x,n/2);
        if(n%2==0) return myPow(myPow(x,n/2),2);
        if(n%2==1) return x*myPow(myPow(x,n/2),2);
        return 0;
    }
}