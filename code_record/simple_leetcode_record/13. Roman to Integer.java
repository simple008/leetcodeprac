/*Created by ${USER} on ${DATE}.
*题意：把罗马数字转成整数
*思路：重点注意 100  10  1 这三个组合的情况  1000-100 500-100 100-10  50-10  10-1  5-1
*一刷：
*二刷：
*复杂度分析：
*反思：
*/

public class Solution {
    public int romanToInt(String s) {
        int len=s.length();
        int num=0;
        for(int i=0;i<len;i++){
            switch (s.charAt(i)){
                case 'I':
                    if(i!=len-1&&(s.charAt(i+1)=='V'||s.charAt(i+1)=='X'))
                        num--;
                    else num++;
                    continue;
                case 'V':
                    num+=5;
                    continue;
                case 'X':
                    if(i!=len-1&&(s.charAt(i+1)=='L'||s.charAt(i+1)=='C'))
                        num-=10;
                    else num+=10;
                    continue;
                case 'L':
                    num+=50;
                    continue;
                case 'C':
                    if(i!=len-1&&(s.charAt(i+1)=='D'||s.charAt(i+1)=='M'))
                        num-=100;
                    else num+=100;
                    continue;
                case 'D':
                    num+=500;
                    continue;
                case 'M':
                    num+=1000;
                    continue;
            }

        }
        return num;
    }
}