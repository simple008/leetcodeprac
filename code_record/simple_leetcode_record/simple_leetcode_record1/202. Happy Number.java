/*Created by ${USER} on ${DATE}.
 *题意：给定一个数，不断计算各位数字平方之和，看最后能够得到1，
 *注意：
 *思路：
 *一刷：1. 硬算不断调用 用set判断 是否重复出现  2. 调用一次的结果和调用两次的结果比较，是否一样 不断迭代 一样就退出，剪枝
 *二刷：
 *复杂度分析：
 *反思：
 */
//第一次

public class Solution {
    public boolean isHappy(int n) {
        if(n<=0)return false;
        long ln=n;
        Set<Long> con=new HashSet<Long>();

        while(ln<=Integer.MAX_VALUE){
            if(con.contains(ln)) return false;
            else con.add(ln);
            ln=digitsquare(ln);
            if(ln==1)return true;
        }
        return false;
    }
    public long digitsquare(long n){
        long sum=0;
        while(n!=0)
        {
            sum+=Math.pow(n%10,2);
            n=n/10;
        }
        return sum;
    }
}

//第二次
public class Solution {
    public boolean isHappy(int n) {
        int x = n;
        int y = n;
        while(x>1){
            x = cal(x) ;
            if(x==1) return true ;
            y = cal(cal(y));
            if(y==1) return true ;

            if(x==y) return false;
        }
        return true ;
    }
    public int cal(int n){
        int x = n;
        int s = 0;
        while(x>0){
            s = s+(x%10)*(x%10);
            x = x/10;
        }
        return s ;
    }
}
