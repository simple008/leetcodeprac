/*Created by ${USER} on ${DATE}.
*题意：实现C++中的atoi函数，把字符串转换成整型  注意各种corner问题
*思路：注意四方面的问题：1.开头的空格 2.正负号问题 3.无效字符，有无效字符返回无效字符之前的结果而不是0
*4.结果是否越界  给定一个全局索引变量i，
*一刷：
*二刷：
*复杂度分析：
*反思：
*/

public class Solution {
    public int myAtoi(String str) {
        str = str.trim();
        int len=str.length();

        long sum=0;
        boolean zf=true;
        if (str.equals("")) return 0;
        int fir=str.charAt(0);
        if (fir==43)
            zf=true;
        else if(fir==45)
            zf=false;
        else if(fir>=48&&fir<=57)
            sum=fir-48;
        else return 0;
        for(int i=1;i<len;i++)
        {
            if(str.charAt(i)<48||str.charAt(i)>=58)
                break;

            sum=sum*10+(str.charAt(i)-'0');
//            if(sum > Integer.MAX_VALUE)
//                sum=Integer.MAX_VALUE;
            if(zf==true&&sum>=Integer.MAX_VALUE)
                return Integer.MAX_VALUE;
            else if(zf==false&&sum >Integer.MAX_VALUE)
                return Integer.MIN_VALUE;
//            else if(zf==true&&sum == Integer.MAX_VALUE)
//                return Integer.MIN_VALUE;
        }

        sum=zf?sum:-sum;

        return (int)sum;
    }
}

/*
注意是否会超过long的界限
 */
public class Solution {
    public int myAtoi(String str) {
        if(str==null||str.length()==0) return 0;
        int i=0;
        boolean flag=true;
        while(str.charAt(i)==' ') i++; //去除开头的空格
        if(str.charAt(i)=='+'){  //正负号判断
            i++;
        }
        else if(str.charAt(i)=='-'){
            flag=false;
            i++;
        }
        long res=0;
        while(i < str.length()){
            int bit=str.charAt(i)-'0';
            if(bit<0||bit>9){//如果有无效字符则返回当前的结果
                break;
            }
            res=res*10+bit;
            i++;
            if(res>Integer.MAX_VALUE) break;  //判断是否会在遍历的过程中越出long的上界
        }
        res=flag==true?res:-res;
        if(res>=Integer.MAX_VALUE) return Integer.MAX_VALUE;
        if(res<=Integer.MIN_VALUE) return Integer.MIN_VALUE;
        return (int)res;
    }
}