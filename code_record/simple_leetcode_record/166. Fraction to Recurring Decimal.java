/*Created by ${USER} on ${DATE}.
 *题意：
 *注意：
 *思路：
 *一刷：
 *二刷：
 *复杂度分析：
 *反思：
 */

//第一次
public class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        StringBuilder str =new StringBuilder();
        String sign=(numerator<0==denominator<0||numerator==0)? "" : "-";

        long num=Math.abs((long)numerator);
        long den=Math.abs((long)denominator);
        str.append(sign);
        str.append(num/den);

        long remainder=num%den;
        if(remainder==0) return str.toString();
        str.append(".");
        HashMap<Long,Integer> hash=new HashMap<>();

        while(!hash.containsKey(remainder)){
            hash.put(remainder,str.length());
            str.append(10*remainder/den);
            remainder=10*remainder%den;
        }

        int index=hash.get(remainder);
        str.insert(index,"(");
        str.append(")");
        return str.toString().replace("(0)","");
    }
}
//第二次
