/*Created by ${USER} on ${DATE}.
 *题意：给定一个字符串和一个字符串字典，判断字符串是否由字符串字典中的字符串组成
 *注意：
 *思路：
 *一刷：dp
 *二刷：dfs  dfs要注意剪枝，当不在包含时要把前面一部分去掉
 * 注意dfs 的函数 判断（i,j） 是否能够由dict中的字符串组成，每一次dfs都要有前半部分和后半部分
 *复杂度分析：
 *反思：
 */
//第一次  dp
public class Solution {
    public boolean wordBreak(String s, Set<String> wordDict) {
        boolean []flag=new boolean[s.length()+1];
        flag[0]=true;
        for(int i=1;i<=s.length();i++){
            for(int j=0;j<i;j++){
                if(flag[j]&&wordDict.contains(s.substring(j,i))){
                    flag[i]=true;
                    break;
                }
            }
        }
        return flag[s.length()];
    }
}
//第二次

    public boolean wordBreak(String s, List<String> wordDict) {
        if(s == null || wordDict == null)
            return false;
        if(s.length() == 0)
            return true;
        int len = s.length();

        for(int i = 1; i <= len; i++) {
            String frontPart = s.substring(0, i);
            String backPart = s.substring(i, len);
            if(wordDict.contains(frontPart)) {
                if(wordBreak(backPart, wordDict))
                    return true;
                wordDict.remove(frontPart);  //剪枝操作，避免再次重复运算
            }
        }

        return false;
    }
