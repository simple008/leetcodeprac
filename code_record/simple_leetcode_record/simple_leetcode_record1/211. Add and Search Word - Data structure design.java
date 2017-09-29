/*Created by ${USER} on ${DATE}.
 *题意：设计一个数据结构 可以添加单词 查询单词
 *注意：
 *思路：
 *一刷：
 *二刷：
 *复杂度分析：
 *反思：
 */
//第一次
class TrieNode{
    private char val;
    boolean isWord;
    public TrieNode[]children=new TrieNode[26];
    public TrieNode(){

    }
    public TrieNode(char c){
        TrieNode node=new TrieNode();
        node.val=c;
    }
}

public class WordDictionary {
    TrieNode root=new TrieNode();
    // Adds a word into the data structure.
    public void addWord(String word) {
        TrieNode ws=root;
        for(int i=0;i<word.length();i++){
            char c=word.charAt(i);
            if(ws.children[c-'a']==null)
                ws.children[c-'a']=new TrieNode();;
            ws=ws.children[c-'a'];
        }
        ws.isWord=true;
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        return find(word,0,root);
    }
    boolean find(String word,int index,TrieNode now){
        if(index==word.length())
            return now.isWord;
        Character c=word.charAt(index);
        if(c=='.'){
            for(int i=0;i<26;i++)
                if(now.children[i]!=null){
                    if(find(word,index+1,now.children[i]))
                        return true;
                }
            return false;
        }
        else if(now.children[c-'a']!=null)
            return class TrieNode{
    private char val;
    boolean isWord;
    public TrieNode[]children=new TrieNode[26];
    public TrieNode(){

    }
    public TrieNode(char c){
        TrieNode node=new TrieNode();
        node.val=c;
    }
}

public class WordDictionary {
    TrieNode root=new TrieNode();
    // Adds a word into the data structure.
    public void addWord(String word) {
        TrieNode ws=root;
        for(int i=0;i<word.length();i++){
            char c=word.charAt(i);
            if(ws.children[c-'a']==null)
                ws.children[c-'a']=new TrieNode();;
            ws=ws.children[c-'a'];
        }
        ws.isWord=true;
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        return find(word,0,root);
    }
    boolean find(String word,int index,TrieNode now){
        if(index==word.length())
            return now.isWord;
        Character c=word.charAt(index);
        if(c=='.'){
            for(int i=0;i<26;i++)
            if(now.children[i]!=null){
                if(find(word,index+1,now.children[i]))
                return true;
            }
            return false;
        }
        else if(now.children[c-'a']!=null)
            return find(word,index+1,now.children[c-'a']);
        else return false;
    }
}

// Your WordDictionary object will be instantiated and called as such:
// WordDictionary wordDictionary = new WordDictionary();
// wordDictionary.addWord("word");
// wordDictionary.search("pattern");(word,index+1,now.children[c-'a']);
        else return false;
    }
}

// Your WordDictionary object will be instantiated and called as such:
// WordDictionary wordDictionary = new WordDictionary();
// wordDictionary.addWord("word");
// wordDictionary.search("pattern");

