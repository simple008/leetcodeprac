/*Created by ${USER} on ${DATE}.
 *题意：给定开始的单词集合，和单词列表判断经过多少次变换能够得到结束单词
 *注意：
 *思路：
 *一刷：一个开始集合把当次得到的单词放进来，结束集合放最后的单词。把所有遍历过得单词都记录下来作为一个visited集合
 *二刷：
 *复杂度分析：
 *反思：
 */

//第一次
public class Solution {
    public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        Set<String> beginSet=new HashSet<>();
        Set<String> endSet=new HashSet<>();
        int len=1;
        HashSet<String> visited=new HashSet<>();
        beginSet.add(beginWord);
        endSet.add(endWord);
        while(!beginSet.isEmpty()&&!endSet.isEmpty()){
            if (beginSet.size() > endSet.size()) {
                Set<String> set = beginSet;
                beginSet = endSet;
                endSet = set;
            }
            Set<String> temp=new HashSet<>();
            for(String each:beginSet){
                char []chs=each.toCharArray();
                for(int i=0;i<chs.length;i++){
                    for(char c='a';c<='z';c++){
                        char old=chs[i];
                        chs[i]=c;
                        String target=String.valueOf(chs);
                        if(endSet.contains(target)){
                            return len+1;
                        }
                        if(!visited.contains(target)&&wordList.contains(target)){
                            temp.add(target);
                            visited.add(target);
                        }
                        chs[i]=old;
                    }
                }
            }
            beginSet=temp;
            len++;
        }
        return 0;
    }
}

//第二次

public class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (beginWord == null || endWord == null || wordList == null) return 0;
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        int steps = 1, curLevel = 1, nextLevel = 0;
        Set<String> visited = new HashSet<>(5000);
        visited.add(beginWord);
        while(!queue.isEmpty()){
            String word = queue.poll();
            char [] wordArr = word.toCharArray();
            curLevel--;
            for(int i = 0; i< wordArr.length; i++){
                char tmp = wordArr[i];
                for(char c = 'a'; c <='z'; c++){
                    if(c != tmp){
                        wordArr[i]=c;
                    }
                    String newWord = String.valueOf(wordArr);
                    if(newWord.equals(endWord)) return steps + 1;
                    if(!visited.contains(newWord) && wordList.contains(newWord)){
                        queue.offer(newWord);
                        nextLevel++;
                        visited.add(newWord);
                    }
                }
                wordArr[i] = tmp;
            }
            if (curLevel == 0) {
                curLevel = nextLevel;
                nextLevel = 0;
                steps++;
            }
        }
        return 0;
    }
}