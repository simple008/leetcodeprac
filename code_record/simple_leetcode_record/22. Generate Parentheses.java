/*Created by ${USER} on ${DATE}.
 *题意：列出N个（）的各种组合方式
 *注意：
 *思路：
 *一刷：
 *二刷：
 *复杂度分析：
 *反思：回溯的下一级操作要在函数中进行而不是提前处理好 再放到函数里，如果提前操作了就不能回到上一次的状态
 * 如果这里用stringbuilder 并且在if循环里 进行append 那么下一级if得到的str 和本if的str就不是同一个了，不能回溯到上一个状态！需要注意
 *
 *
 */

//第二次
//又是典型的回溯，但是要找到回溯的规律，先用（ 一直放到最大，然后再返回来找 比如 先摆三个（，（（（））），再变两个(( 看这种情况的组合
//判断条件是现在的左引号数比右引号数多
public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> list=new ArrayList<String>();
        backtrack(list,n,0,0,new String());
        return list;
    }
    public void backtrack(List<String> list,int max,int open,int close,String str){
        if(str.length()==max*2){
            list.add(str);
            return ;
        }
        if(open<max){

            backtrack(list,max,open+1,close,str+'('); //str 是没加“（”的str  所以回溯过来不用再减去刚才加的内容 可以直接用
        }
        if(close<open){
            //  str.append(')');
            backtrack(list,max,open,close+1,str+')');
        }
    }
}