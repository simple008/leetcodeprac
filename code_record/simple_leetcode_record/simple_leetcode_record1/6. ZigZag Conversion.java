/*Created by ${USER} on ${DATE}.
*题意：以Z的形式输出字符串
*思路：找出坐标的对应规律 仔细，看轮询
*一刷：
*二刷：
*复杂度分析：
*反思：
*/


public class Solution {
    public String convert(String s, int numRows) {
        if (numRows==1) return s; // corner answer
        int len =s.length();
        int rot=2*numRows-2;
        // int a=0;
        StringBuilder sb=new StringBuilder();

        for(int j=0;j<numRows;j++){
            int i=j;

            while(i<len)
            {
                sb.append(s.charAt(i));
                if(j!=0&&j!=(numRows-1)&&(i+rot-2*j)<len) // 第一行 最后一行 最后一个轮询如果超长除外
                {
                    sb.append(s.charAt(i+rot-2*j)); //z中间的一部分
                }

                i+=rot;
            }
        }
        return sb.toString();
    }
}

/*
索引对应关系要注意
 */
public class Solution {
    public String convert(String s, int numRows) {
        int num=(numRows-2)*2+2;
        if(numRows==1) return s;
        StringBuilder sb=new StringBuilder();
        int i=0,j=1;
        while(j<=numRows){
            i=j-1;
            while(i<s.length()){
                sb.append(s.charAt(i));
                if(j!=1&&j!=numRows&&(i+num-2*(j-1))<s.length())
                    sb.append(s.charAt(i+num-2*(j-1)));
                i+=num;
            }
            j++;
        }
        return sb.toString();
    }
}