/*Created by ${USER} on ${DATE}.
 *题意：给一个数字字符串 判断有多少种 组成ip地址的情况
 *注意：
 *思路：1.分四段
 *     2.每段在0-255范围内
 *     3.段长不超3   如果第一位是0那长度只能为1
 *
 *一刷：
 *二刷：用i j k 分成四段 注意每段的下标控制
 *复杂度分析：
 *反思：
 */
// 第一次 没看
public class Solution {
    List<String> res;
    StringBuilder seq;
    public List<String> restoreIpAddresses(String s) {
    /*  采用递归的解法。基本思路就是取出一个合法的数字，作为IP地址的一项，然后递归处理剩下的项。
        可以想象出一颗树，每个结点有三个可能的分支（因为范围是0-255，所以可以由一位两位或者三位组成）。
        并且这里树的层数不会超过四层，因为IP地址由四段组成，到了之后我们就没必要再递归下去，可以结束了。
        递归结束的条件是遍历完4段，字符串也恰好读完了。可以看出这棵树的规模是固定的，
        时间复杂度取决于输入的规模，是指数量级的，所以这道题并不是NP问题，因为他的分支是四段，有限制。*/

        res=new ArrayList<String>();
        seq=new StringBuilder();
        getIpAddress(s,0,1);//index  segment
        return res;
    }
    public void getIpAddress(String s,int index,int seg){
        if(seg>4){//递归截止的条件，大于4段，并且不存在多余的字符
            if(index==s.length()){
                res.add(new String(seq));
            }
            return;
        }

        for(int i=1;i<4&&(index+i)<=s.length();i++){//DFS,注意要删除seq的值
            String temp=s.substring(index,index+i);
            if(isvalid(temp)){
                if(seg==1){
                    seq.append(temp);
                }else{
                    seq.append("."+temp);
                }
                getIpAddress(s,index+i,seg+1);
                int t=seg==1?0:1;
                seq.delete(seq.length()-i-t,seq.length());
            }
        }

    }
    public boolean isvalid(String s){//验证每一段是否满足要求，不能是“01”，不能大于三位，范围在0 到255
        if(s==null||s.length()>3) return false;
        if(s.length()>1&&s.charAt(0)=='0') return false;
        int temp=Integer.parseInt(s);/////
        if(temp>=0&&temp<=255) return true;
        return false;
    }
}
//第二次
public class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> list=new ArrayList<String>();
        int len=s.length();
        for(int i=0;i<3&&i<len-3;i++){
            for(int j=i+1;j<i+4&&j<len-2;j++){
                for(int k=j+1;k<j+4&&k<len-1;k++){
                    String s1=s.substring(0,i+1);
                    String s2=s.substring(i+1,j+1);
                    String s3=s.substring(j+1,k+1);
                    String s4=s.substring(k+1,len);
                    if(isValid(s1)&&isValid(s2)&&isValid(s3)&&isValid(s4))
                        list.add(s1+"."+s2+"."+s3+"."+s4);

                }
            }
        }
        return list;
    }
    public boolean isValid(String s){
        if(s.length()>3||(s.charAt(0)=='0'&&s.length()>1)||Integer.parseInt(s)>255||Integer.parseInt(s)<0)
            return false;
        return true;
    }
}