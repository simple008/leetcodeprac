package bishi.sina;

import java.util.Random;
import java.util.Scanner;

/**
 * Created by lpeiz on 2017/9/17.
 */
public class Main {
    public static void main(String[] args) {
        Scanner in  = new Scanner(System.in);

    }
}


class BitmapTest {

    private static final int CAPACITY = 1000000000;//数据容量

    // 定义一个byte数组缓存所有的数据
    private byte[] dataBytes = new byte[1 << 29];

    public static void main(String[] args) {
        BitmapTest ms = new BitmapTest();

        byte[] bytes = null;

        Random random = new Random();
        for (int i = 0; i < CAPACITY; i++) {
            int num = random.nextInt();
            System.out.println("读取了第 " + (i + 1) + "\t个数: " + num);
            bytes = ms.splitBigData(num);
        }
        System.out.println("");
        ms.output(bytes);
    }


    /**
     * 读取数据，并将对应数数据的 到对应的bit中，并返回byte数组
     * @param num 读取的数据
     * @return byte数组  dataBytes
     */
    private byte[] splitBigData(int num) {

        long bitIndex = num + (1l << 31);         //获取num数据对应bit数组（虚拟）的索引
        int index = (int) (bitIndex / 8);         //bit数组（虚拟）在byte数组中的索引
        int innerIndex = (int) (bitIndex % 8);    //bitIndex 在byte[]数组索引index 中的具体位置

        System.out.println("byte[" + index + "] 中的索引：" + innerIndex);

        dataBytes[index] = (byte) (dataBytes[index] | (1 << innerIndex));
        return dataBytes;
    }

    /**
     * 输出数组中的数据
     * @param bytes byte数组
     */
    private void output(byte[] bytes) {
        int count = 0;
        for (int i = 0; i < bytes.length; i++) {
            for (int j = 0; j < 8; j++) {
                if (!(((bytes[i]) & (1 << j)) == 0)) {
                    count++;
                    int number = (int) ((((long) i * 8 + j) - (1l << 31)));
                    System.out.println("取出的第  " + count + "\t个数: " +  number);
                }
            }
        }
    }

}



class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        TrieNode node = root;
        int length = word.length();
        int position ;
        char c;
        for (int i = 0; i < length; i++) {
            c = word.charAt(i);
            position = c-'a';
            if (node.trieNodes[position] == null) {
                node.trieNodes[position] = new TrieNode();
            }
            node = node.trieNodes[position];
            node.setCount(node.getCount()+1);
        }
        node.setExist(true);
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        boolean result = false;
        TrieNode node = root;
        int length = word.length();
        int position ;
        char c;
        for (int i = 0; i < length; i++) {
            c = word.charAt(i);
            position = c - 'a';
            node = node.trieNodes[position];
            if (node == null) {
                break;
            }
        }
        if (node != null && node.getExist()) {
            result = true;
        }
        return result;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        TrieNode node = root;
        int length = prefix.length();
        int position ;
        char c;
        for (int i = 0; i < length; i++) {
            c = prefix.charAt(i);
            position = c - 'a';
            node = node.trieNodes[position];
            if (node == null) {
                return false;
            }
        }
        return true;
    }

    // delete if the word is in the trie.
    public boolean doDelete(String word, TrieNode node) {
        //树中已匹配的字符串比传入字符串短
        if (node == null) {
            return false;
        }

        //树中已匹配的字符串比传入字符串不短
        if (word.length()  > 1){
            char c = word.charAt(0);
            int position = c - 'a';
            TrieNode trieNode = node.trieNodes[position];
            boolean b = doDelete(word.substring(1), trieNode);
            if (b) {
                node.setCount(node.getCount() - 1);
                if (trieNode.getCount() == 0) {
                    node.trieNodes[position] = null;
                }
                return true;
            }
        }

        if (word.length() == 1) {
            char c = word.charAt(0);
            int position = c - 'a';
            TrieNode trieNode = node.trieNodes[position];
            //只删除单词 如果是前缀不删除
            if (trieNode != null && trieNode.getExist()) {
                return true;
            }
        }
        return false;
    }

    // delete if the word is in the trie.
    public boolean delete(String word) {
        return this.doDelete(word,root);
    }

    class TrieNode {
        // Initialize your data structure here.
        int count = 0;
        TrieNode[] trieNodes = new TrieNode[26];
        Boolean exist = false;
        public TrieNode() {
        }

        public TrieNode(int count, Boolean exist) {
            this.count = count;
            this.exist = exist;
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public TrieNode[] getTrieNodes() {
            return trieNodes;
        }

        public void setTrieNodes(TrieNode[] trieNodes) {
            this.trieNodes = trieNodes;
        }

        public Boolean getExist() {
            return exist;
        }

        public void setExist(Boolean exist) {
            this.exist = exist;
        }
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.search("lintcode");
        trie.startsWith("lint");
        trie.insert("lint");
        trie.startsWith("lint");

        boolean lint = trie.delete("lin");
        System.out.println("lint = " + lint);
        lint = trie.delete("lint");
        System.out.println("lint = " + lint);
    }
}










