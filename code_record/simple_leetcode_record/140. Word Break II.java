/*Created by ${USER} on ${DATE}.
 *题意：单词组成个各种情况，返回一个list的list
 *注意：
 *思路：
 *一刷：
 *二刷：
 *复杂度分析：
 *反思：
 */
//第一次
//直接递归回溯超时。
public class Solution {

    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> list = new ArrayList<String>();
        List<String> temp = new ArrayList<String>();
        dfs( s,  0,list,temp,wordDict);
        return list;
    }
    public void dfs(String s, int start, List<String> list,List<String> temp, List<String> wordDict){
        if(start == s.length()){
            addList(list,temp);
            return ;
        }
        for(int i = start; i < s.length(); i++){
            if(wordDict.contains(s.substring(start,i+1))){
                temp.add(s.substring(start,i+1));
                dfs(s,i+1,list,temp,wordDict);
                temp.remove(temp.size()-1);
            }
        }
    }
    public void addList(List<String> list,List<String> temp){
        StringBuilder sb = new StringBuilder();
        for(String s: temp){
            sb.append(s);
            sb.append(" ");
        }
        sb.deleteCharAt(sb.length()-1);
        list.add(sb.toString());
    }
}