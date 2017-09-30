/*Created by ${USER} on ${DATE}.
 *题意：1-n中 digit 1 出现的次数
 *注意：
 *思路：
 *一刷：
 *二刷：
 *复杂度分析：
 *反思：
 */
//第一次
public class Solution {
    public int countDigitOne(int n) {

        int res=0;
        for(long m=1;m<=n;m*=10){
            long a=n/m,b=n%m;
            res+=(a+8)/10*m;
            if(a%10==1) res+=b+1;
        }
        return res;
    }
}

//划分成  10的幂次的范围 进行循环处理
