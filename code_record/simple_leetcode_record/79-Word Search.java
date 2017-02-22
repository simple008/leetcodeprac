/*Created by ${USER} on ${DATE}.
 *题意：在矩阵中能够找到单词，单词的每个字母在矩阵中是相邻的（上下，左右）
 *注意：不能重复访问
 *思路：回溯，boolean 返回类型，以返回类型来判断是否符合要求。
 *          设置一个标识数组，判断当前位置是否被访问过，访问的时候做标记，访问结束之后 置回原来的标记
 *一刷：
 *二刷： visited 作为标识数组判断当前位置是否已经被遍历过
 *复杂度分析：
 *反思：
 */
//第一次
public class Solution {
    public boolean exist(char[][] board, String word) {
        char[] w = word.toCharArray();
        for (int y=0; y<board.length; y++) {
            for (int x=0; x<board[y].length; x++) {
                if (exist(board, y, x, w, 0)) return true;
            }
        }
        return false;
    }

    private boolean exist(char[][] board, int x, int y, char[] word, int i) {
        if (i == word.length) return true;
        if (x<0 || y<0 || x == board.length || y == board[x].length) return false;
        if (board[x][y] != word[i]) return false;
        board[x][y] ^= 256;    //256异或是什么鬼
        boolean exi = exist(board, x, y+1, word, i+1)
                || exist(board, x, y-1, word, i+1)
                || exist(board, x+1, y, word, i+1)
                || exist(board, x-1, y, word, i+1);
        board[x][y] ^= 256;
        return exi;
    }

}
//第二次
public class Solution {
    public boolean exist(char[][] board, String word) {
        if(word.length()==0) return true;
        if(board.length==0) return false;
        int m=board.length;
        int n=board[0].length;
        boolean visited[][]=new boolean[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(search(board,word,i,j,0,visited))
                    return true;
            }
        }
        return false;
    }
    public boolean search(char[][]board,String word,int i,int j,int index,boolean visited[][]){
        if(index==word.length()) return true;
        if(i<0||j<0||i>=board.length||j>=board[0].length||visited[i][j]) return false;
        if(board[i][j]!=word.charAt(index)) return false;

        visited[i][j]=true;
        if(search(board,word,i+1,j,index+1,visited)) return true;
        if(search(board,word,i-1,j,index+1,visited)) return true;
        if(search(board,word,i,j+1,index+1,visited)) return true;
        if(search(board,word,i,j-1,index+1,visited)) return true;

        visited[i][j]=false;
        return false;

    }
}

//code by wxw
public class Solution {
    char[][] b;
    String w = null;
    int l,m,len;

    public boolean exist(char[][] board, String word) {
        if(board == null) return false;
        b = board;
        w = word;
        //System.out.println(w);
        l = board.length;
        m = board[0].length;
        len = word.length();
        for(int i = 0; i<l; i++){
            for(int j = 0; j<m; j++){
                if(b[i][j] == word.charAt(0)){
                    if(recusive(i, j, 1)) return true;
                }
            }
        }
        return false;

    }

    public boolean recusive( int i, int j, int n){
        if(n==len)return true;
        //else if(n > len) return false;
        char tmp = b[i][j];
        b[i][j] = '#';
        if(i+1 < l && w.charAt(n) == b[i+1][j]){ if(recusive( i+1, j, n+1)) return true;}
        if(j+1 < m && w.charAt(n) == b[i][j+1]){ if(recusive( i, j+1, n+1)) return true; }
        if(i-1 >= 0 && w.charAt(n) == b[i-1][j]){ if(recusive( i-1, j, n+1)) return true;}
        if(j-1 >= 0 && w.charAt(n) == b[i][j-1]){ if(recusive( i, j-1, n+1)) return true;}
        b[i][j]= tmp;
        return false;
    }
}