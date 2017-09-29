/*Created by ${USER} on ${DATE}.
 *题意：岛屿数  被0包围或者 在被边界包围
 *注意：
 *思路：
 *一刷：
 *二刷：从一个1的位置进去，把所有临近的1都变成0 并且不断的进行递归的深搜，看需要进多少次， 很好
 *复杂度分析：
 *反思：
 */
//第一次

public class Solution {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        int rowNum = grid.length, colNum = grid[0].length;
        boolean[][] visited = new boolean[rowNum][colNum];
        Queue<int[]> q = new LinkedList<>();
        int count = 0;

        for (int i = 0; i < rowNum; i++) {
            for (int j = 0; j < colNum; j++) {
                if (!visited[i][j] && grid[i][j] == '1') {
                    q.offer(new int[] {i, j});
                    while (!q.isEmpty()) {
                        int[] location = q.poll();
                        int k = location[0], l = location[1];
                        if (visited[k][l]) continue;
                        visited[k][l] = true;
                        if (k - 1 >= 0 && grid[k - 1][l] == '1' && !visited[k - 1][l])
                            q.offer(new int[] {k - 1, l});
                        if (k + 1 <= rowNum - 1 && grid[k + 1][l] == '1' && !visited[k + 1][l])
                            q.offer(new int[] {k + 1, l});
                        if (l - 1 >= 0 && grid[k][l - 1] == '1' && !visited[k][l - 1])
                            q.offer(new int[] {k, l - 1});
                        if (l + 1 <= colNum - 1 && grid[k][l + 1] == '1' && !visited[k][l + 1])
                            q.offer(new int[] {k, l + 1});
                    }
                    count++;
                }
            }
        }
        return count;
    }
}


public class Solution {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        int rowNum = grid.length, colNum = grid[0].length;
        boolean[][] visited = new boolean[rowNum][colNum];
        Queue<int[]> q = new LinkedList<>();
        int count = 0;

        for (int i = 0; i < rowNum; i++) {
            for (int j = 0; j < colNum; j++) {
                if (!visited[i][j] && grid[i][j] == '1') {
                    q.offer(new int[] {i, j});
                    while (!q.isEmpty()) {
                        int[] location = q.poll();
                        int k = location[0], l = location[1];
                        if (visited[k][l]) continue;
                        visited[k][l] = true;
                        if (k - 1 >= 0 && grid[k - 1][l] == '1' && !visited[k - 1][l]) q.offer(new int[] {k - 1, l});
                        if (k + 1 <= rowNum - 1 && grid[k + 1][l] == '1' && !visited[k + 1][l]) q.offer(new int[] {k + 1, l});
                        if (l - 1 >= 0 && grid[k][l - 1] == '1' && !visited[k][l - 1]) q.offer(new int[] {k, l - 1});
                        if (l + 1 <= colNum - 1 && grid[k][l + 1] == '1' && !visited[k][l + 1]) q.offer(new int[] {k, l + 1});
                    }
                    count++;
                }
            }
        }
        return count;
    }
}
//3ms

public class Solution {
    public int numIslands(char[][] grid) {
        if(grid==null||grid.length==0) return 0;
        int m=grid.length;
        int n=grid[0].length;
        int count=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]=='1'){
                    dfs(grid,i,j);
                    count++;
                }
            }
        }
        return count;
    }
    public void dfs(char [][]grid,int i,int j){
        if(i<0||j<0||i>grid.length-1||j>grid[0].length-1) return ;
        if(grid[i][j]!='1') return ;
        grid[i][j]='0';
        dfs(grid,i-1,j);
        dfs(grid,i+1,j);
        dfs(grid,i,j-1);
        dfs(grid,i,j+1);
    }
}





//又一次
class Solution {
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length ==0 || grid[0].length ==0) return 0;
        int m =gird.length;
        int n = grid[0].length;
        int count = 0;
        for(int i =0; i<m; i++){
            for(int j =0;j<n;j++){
                if(grid[i][j] == '1'){
                    dfs(grid,i,j);
                    count++;
                }
            }
        }
        return count;
    }
    public void dfs(char[][] grid, int i, int j){
        if(i>=grid.length || i<0||j>=grid[0].length || j<0) return ;
        if(grid[i][j] =='0') return ;
        if(grid[i][j] == '1') {
            grid[i][j]='0';
            dfs(grid, i+1,j);
            dfs(grid, i-1,j);
            dfs(grid, i,j+1);
            dfs(grid, i,j-1);
        }
    }
}




























