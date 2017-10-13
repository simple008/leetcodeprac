/*
package bishi.jianchioffer;

import javax.swing.tree.TreeNode;

public class robot_range {
    public static void main(String[] args) {
        System.out.println(movingCount(10,1,100));
    }
    public static int movingCount(int threshold, int rows, int cols)
    {
        boolean[][] flag = new boolean[rows][cols];
        int cnt = dfs(threshold, rows, cols, flag,0,0);
         return cnt;
    }

    public static int dfs(int threshold, int rows, int cols, boolean[][] flag, int i, int j ){
        int count = 0;
        if(check(i,j,threshold, rows, cols) && !flag[i][j]){
            flag[i][j] = true;
            count = 1+
            dfs(threshold, rows, cols,flag,i+1,j)+
            dfs(threshold, rows, cols,flag,i-1,j)+
            dfs(threshold, rows, cols,flag,i,j+1)+
            dfs(threshold, rows, cols,flag,i,j-1);

        }

        return count;
    }
    public static boolean check(int i, int j, int threshold, int rows, int cols){
        if(i<0 || j<0 || i>= rows||j>= cols) return false;
        int res = 0;
        while(i != 0){
            res += i % 10;
            i/=10;
        }
        while(j != 0){
            res += j % 10;
            j/=10;
        }

        return res <= threshold;
    }
}


    public static boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        // 参数校验
        if (matrix == null || matrix.length != rows * cols || str == null || str.length < 1) {
            return false;
        }

        // 变量初始化
        boolean[] visited = new boolean[rows * cols];
        for (int i = 0; i < visited.length; i++) {
            visited[i] = false;
        }

        // 记录结果的数组，
        int[] pathLength = {0};
        // 以每一个点为起始进行搜索
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (hasPathCore(matrix, rows, cols, str, visited, i, j, pathLength)) {
                    return true;
                }
            }
        }

        return false;
    }

    */
/**
     * 回溯搜索算法
     *
     * @param matrix     输入矩阵
     * @param rows       矩阵行数
     * @param cols       矩阵列数
     * @param str        要搜索的字符串
     * @param visited    访问标记数组
     * @param row        当前处理的行号
     * @param col        当前处理的列号
     * @param pathLength 已经处理的str中字符个数
     * @return 是否找到 true是，false否
     *//*

    private static boolean hasPathCore(char[] matrix, int rows, int cols, char[] str, boolean[] visited,
                                       int row, int col, int[] pathLength) {

        if (pathLength[0] == str.length) {
            return true;
        }

        boolean hasPath = false;

        // 判断位置是否合法
        if (row >= 0 && row < rows
                && col >= 0 && col < cols
                && matrix[row * cols + col] == str[pathLength[0]]
                && !visited[row * cols + col]) {

            visited[row * cols + col] = true;
            pathLength[0]++;

            // 按左上右下进行回溯
            hasPath = hasPathCore(matrix, rows, cols, str, visited, row, col - 1, pathLength)
                    || hasPathCore(matrix, rows, cols, str, visited, row - 1, col, pathLength)
                    || hasPathCore(matrix, rows, cols, str, visited, row, col + 1, pathLength)
                    || hasPathCore(matrix, rows, cols, str, visited, row + 1, col, pathLength);

            if (!hasPath) {
                pathLength[0]--;
                visited[row * cols + col] = false;
            }

        }

        return hasPath;
    }


    TreeNode KthNode(TreeNode pRoot, int k)
    {
        return inorder(pRoot,k);
    }

    TreeNode inorder(TreeNode root, int k){
        if(root == null) return null;
        TreeNode result = null;
        if(root.left != null){
            result = inorder(root.left);
        }
        if(result == null) {
            if (k == 1) {
                return root;
            } else {
                k--;
            }

            if(root.right != null){
               result = inorder(root.right);
            }
        }


        return result;
    }
    {8,6,10,5,7,9,11},2

            如果一个结点有右子树，那么它的下一个结点就是它的右子树中的左子结点。
            也就是说右子结点出发一直沿着指向左子结点的指针，我们就能找到它的下一个结点。

            接着我们分析一个结点没有右子树的情形。如果结点是它父节点的左子结点，
            那么它的下一个结点就是它的父结点。

            如果一个结点既没有右子树，并且它还是它父结点的右子结点，这种情形就比较复杂。
            我们可以沿着指向父节点的指针一直向上遍历，直到找到一个是它父结点的左子结点的结点。
            如果这样的结点存在，那么这个结点的父结点就是我们要找的下一个结点。




*/
