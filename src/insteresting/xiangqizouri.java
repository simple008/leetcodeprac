package insteresting;

import java.util.Scanner;

/**
 * Created by lpeiz on 2017/5/17.
 * ��ı������⡣�ڣΣ��͵������У���ֻ�������֡����λ��(x,y)����������
 ���̵�ÿһ����һ�Σ���ֻ��һ�Ρ��ҳ�����·����
 ���� N M x y
 �� 5 5 3 3
 5*5������ ��ӵ�3�е�3�п�ʼ����
 */
public class xiangqizouri {
    private static int[][] next = new int[][] { { 1, 2 }, { 1, -2 }, { -1, 2 }, { -1, -2 }, { 2, 1 }, { 2, -1 },
            { -2, 1 }, { -2, -1 }, };
    private static int[][] book;
    private static int[][] map;
    private static int[][] a;//������¼·����Ϣ
    private static int n, m;
    private static int count = 0;//ͳ���ж������߷�

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
