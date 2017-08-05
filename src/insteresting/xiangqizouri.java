package insteresting;

import java.util.Scanner;

/**
 * Created by lpeiz on 2017/5/17.
 * 马的遍历问题。在Ｎ＊Ｍ的棋盘中，马只能走日字。马从位置(x,y)处出发，把
 棋盘的每一格都走一次，且只走一次。找出所有路径。
 输入 N M x y
 如 5 5 3 3
 5*5的棋盘 马从第3行第3列开始出发
 */
public class xiangqizouri {
    private static int[][] next = new int[][] { { 1, 2 }, { 1, -2 }, { -1, 2 }, { -1, -2 }, { 2, 1 }, { 2, -1 },
            { -2, 1 }, { -2, -1 }, };
    private static int[][] book;
    private static int[][] map;
    private static int[][] a;//用来记录路径信息
    private static int n, m;
    private static int count = 0;//统计有多少种走法

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        int x = sc.nextInt() - 1;
        int y = sc.nextInt() - 1;
        map = new int[n][m];
        book = new int[n][m];
        a = new int[n][m];
        book[x][y] = 1;
        dfs(x, y, 1);
        System.out.println(count);
    }

    private static void dfs(int x, int y, int step) {
        // TODO Auto-generated method stub
        a[x][y] = step;
        if (step == n * m) {
            sop(a);
            count++;
        }
        int tx = 0, ty = 0;
        for (int i = 0; i < 8; i++) {
            tx = x + next[i][0];
            ty = y + next[i][1];
            if (tx < 0 || tx >= n || ty < 0 || ty >= m) {
                continue;
            }
            if (book[tx][ty] == 0) {
                book[tx][ty] = 1;
                dfs(tx, ty, step + 1);
                book[tx][ty] = 0;
            }
        }

    }

    private static void sop(int[][] arr) {
        // TODO Auto-generated method stub
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(arr[i][j] + "  ");
            }
            System.out.println();
        }
        System.out.println("---------");
    }
}
