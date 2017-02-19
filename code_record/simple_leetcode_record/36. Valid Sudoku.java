/*Created by ${USER} on ${DATE}.
 *题意：验证给定的数独是否是有效的
 *注意：明白题意，验证当前的数独是否有效即可。每行每列每个小3*3都是合法数字即可  没有重复，数值都在1-9范围内
 *思路：检查三个纬度，行 列 小方块
 *一刷：三次遍历 分别验证    第三次遍历的 取余 取整  标识数组的定义  有效性判断方法的数组索引范围
 *二刷：一次遍历。 通过一次遍历检查三个维度是否符合要求 行列 块  利用hashset来判断是否出现过。[i][j]  [j][i] 坐标，通过i 计算
 *     块状区域的基数，利用j来计算移动坐标   每做一次循环清空一次，  每一次循环都可以遍历一行 一列 一块
 *复杂度分析：Time Complexity - O(n2) ， Space Complexity - O(1)。
 *反思：
 *
 *
 */
//第一次  三次遍历
public class Solution {
    boolean []bool=new boolean[9];
    public boolean isValidSudoku(char[][] board) {
        for(int i=0;i<9;i++){
            Arrays.fill(bool,false);
            for(int j=0;j<9;j++){
                if(!process(bool,board[i][j]))
                    return false;
            }
        }
        for(int i=0;i<9;i++){
            Arrays.fill(bool,false);
            for(int j=0;j<9;j++){
                if(!process(bool,board[j][i]))
                    return false;
            }
        }
        for(int i=0;i<9;i+=3){
            for(int j=0;j<9;j+=3){
                Arrays.fill(bool,false);
                for(int k=0;k<9;k++){
                    if(!process(bool,board[i+k/3][j+k%3]))
                        return false;
                }
            }
        }
        return true;
    }
    public boolean process(boolean[]bool,char ch){
        if(ch=='.') return true;
        int num=ch-'0';
        if(num<1||num>9||bool[num-1])
            return false;
        bool[num-1] =true;
        return true;

    }
}
// 第二次  三次遍历
public class Solution {
    public boolean isValidSudoku(char[][] board) {
        boolean[] bool=new boolean[9];
        for(int i=0;i<9;i++){
            Arrays.fill(bool,false);
            for(int j=0;j<9;j++){
                if(!valid(bool,board[i][j]))
                    return false;
            }
        }
        for(int i=0;i<9;i++){
            Arrays.fill(bool,false);
            for(int j=0;j<9;j++){
                if(!valid(bool,board[j][i]))
                    return false;
            }
        }
        for(int i=0;i<9;i+=3){
            for(int j=0;j<9;j+=3){
                Arrays.fill(bool,false);
                for(int k=0;k<9;k++){
                    if(!valid(bool,board[i+k/3][j+k%3]))
                        return false;
                }
            }
        }
        return true;
    }
    public boolean valid(boolean[] bool,char c){
        if(c=='.') return true;
        if((c-'0')>9||(c-'0')<1||bool[c-'0'-1])
            return false;
        bool[c-'0'-1]=true;
        return true;
    }
}
//一次遍历
public class Solution {
    public boolean isValidSudoku(char[][] board) {

        Set<Character> rows=new HashSet<>();
        Set<Character> cols=new HashSet<>();
        Set<Character> cubes=new HashSet<>();
        int ColIndex;
        int RowIndex;
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j]!='.'&&!rows.add(board[i][j]))
                    return false;
                if(board[j][i]!='.'&&!cols.add(board[j][i]))
                    return false;
                ColIndex=3*(i%3);
                RowIndex=3*(i/3);
                if(board[RowIndex+j/3][ColIndex+j%3]!='.'&&!cubes.add(board[RowIndex+j/3][ColIndex+j%3]))
                    return false;
            }
            rows.clear();
            cols.clear();
            cubes.clear();
        }
        return true;
    }
}