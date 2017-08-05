package leetcoe_test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lpeiz on 2017/5/21.
 */
public class wordBreakII {
    public static void main(String[] args){
        wordBreakII test = new wordBreakII();
        String s ="catcatcatsanddog";
        List<String> list =new ArrayList<String>();
        list.add("cat");
        list.add("cats");
        list.add("and");
        list.add("sand");
        list.add("dog");
        System.out.println(test.wordBreak(s,list));

    }


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
