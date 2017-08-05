/*Created by ${USER} on ${DATE}.
 *题意：给一个字符串，把字符串分割成回文子串的组合，返回这种分割的集合
 *注意：
 *思路：遍历。深度优先。dfs+回溯
 *一刷：
 *二刷：
 *复杂度分析：
 *反思：
 */

//第一次
public class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> list=new ArrayList<List<String>>();
        dfs(list,new ArrayList<String>(),s,0);
        return list;
    }
    public void dfs(List<List<String>> list,List<String> temp,String s,int start){
        if(start==s.length()){
            list.add(new ArrayList(temp));
            return ;
        }
        for(int j=start;j<s.length();j++){
            if(isPal(s,start,j)){
                temp.add(s.substring(start,j+1));
                dfs(list,temp,s,j+1);
                temp.remove(temp.size()-1);
            }
        }
    }
    public boolean isPal(String s,int start,int end){
        while(start<end){
            if(s.charAt(start)==s.charAt(end)){
                start++;
                end--;
            }
            else return false;
        }
        return true;
    }
}
//第二次
public class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> list = new ArrayList<List<String>>();
        List<String> temp = new ArrayList<String>();
        dfs(s,0,temp,list);
        return list;
    }
    public void  dfs(String s, int start, List<String> temp, List<List<String>> list){
        if(start == s.length()){
            list.add(new ArrayList<String>(temp));
        }
        for(int i = start; i < s.length(); i++){
            if(isPal(s,start,i)){
                temp.add(s.substring(start,i+1));
                dfs(s,i+1,temp,list);
                temp.remove(temp.size()-1);
            }
        }
    }
    public boolean isPal(String s, int start, int end){
        while(start<=end){
            if(s.charAt(start) == s.charAt(end)){
                start++;
                end--;
            }else
                return false;
        }
        return true;
    }
}
