/*Created by ${USER} on ${DATE}.
 *题意：给定一个数字字符串，按照手机按键中的字符代表含义，输出所有可能的字符串组合
 *注意：链表的特点  peek() remove() Character.getNumericValue()
 *思路：1.手机按键的数字字符代表含义是固定的可以列出，然后依次取出digits中的字符，比较链表最靠前位置的字符串的长度与字符串的索引是否相等
 *    来判断是否应该遍历
 *
 *一刷：
 *二刷：
 *复杂度分析：
 *反思：
 *
 */

//第一次
public class Solution {
    public List<String> letterCombinations(String digits) {

        LinkedList<String> ans=new LinkedList<String>();
        if(digits.length()==0) return ans;
        String[] mapping=new String[]{"0","1","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        ans.add("");
        for(int i=0;i<digits.length();i++){
            int x=Character.getNumericValue(digits.charAt(i));
            while(ans.peek().length()==i){
                String t=ans.remove();
                for(char s:mapping[x].toCharArray())
                    ans.add(t+s);
            }
        }
        return ans;
    }
}

//二刷参考一刷
public class Solution {
    public List<String> letterCombinations(String digits) {
        LinkedList<String> ans=new LinkedList<>();
        if(digits.length()==0) return ans;
        String []map={"0","1","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        ans.add("");
        for(int i=0;i<digits.length();i++){
            int x=Character.getNumericValue(digits.charAt(i));
            while(ans.peek().length()==i){
                String a=ans.remove();
                for(char t:map[x].toCharArray()){
                    ans.add(a+t);
                }
            }
        }
        return ans;
    }
}
//使用了比较常规的 回溯 +dfs算法，很显然这个是一个回溯问题，因为每一层都会有多个选择，每一层做完当前选择后都应该能回到本层继续做其他选择
//
public class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> ans=new ArrayList<String>();
        if(digits.length()==0) return ans;
        String []map={"0","1","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        getPer(ans,new StringBuilder(),digits,map,0);
        return ans;
    }
    public void getPer(List<String> ans,StringBuilder sb,String digits,String [] map,int pos){
        if(pos==digits.length()){
            ans.add(sb.toString());
            return ;
        }
        int index=digits.charAt(pos)-'0';
        for(char x:map[index].toCharArray()){
            sb.append(x);
            getPer(ans,sb,digits,map,pos+1);   //回溯方法的关键
            sb.setLength(sb.length() - 1);          //删除最后一个字符，回到上一层进行回溯
        }

    }
}


