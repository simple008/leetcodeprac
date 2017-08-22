package bishi.hiho;

/**
 * Created by lpeiz on 2017/4/12.
 */
 import java.util.Scanner;

/**
 * Created by ZhengChaoJie on 2017/4/1/0001.
 */
public class Tree_restoration {
    public static void main(String[] args) {
        int n, m, k;
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        k = scanner.nextInt();
        int[][] nodes = new int[m][];
        for (int i = 0; i < m; i++) {
            int count = scanner.nextInt();
            nodes[i] = new int[count];
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < nodes[i].length; j++) {
                nodes[i][j] = scanner.nextInt();
            }
        }
        int[] leaf = new int[k];
        for (int i = 0; i < k; i++)
            leaf[i] = scanner.nextInt();

        int[][] distance = new int[n + 1][n + 1];
        for (int i = 0; i <= n; i++)
            for (int j = 0; j <= n; j++)
                distance[i][j] = -1;

        for (int i = 0; i < k; i++) {
            for (int j = 0; j < k; j++) {
                distance[leaf[i]][leaf[j]] = scanner.nextInt();
            }
        }
        int[] parentList = findParent(nodes, distance, leaf, n, m, k);

        for (int i = 1; i < n; i++)
            System.out.print(parentList[i] + " ");
        System.out.println(parentList[n]);
    }

    static int[] findParent(int[][] nodes, int[][] distance, int[] leaf, int n, int m, int k) {
        int[] parentList = new int[n + 1];
        boolean[] isLeaf = new boolean[n + 1];
        for (int i = 0; i < leaf.length; i++) {
            isLeaf[leaf[i]] = true;
        }
        int curLevel = nodes.length - 1, index = 0, parentIndex = 0;
        while (curLevel > 0) {
            while (parentIndex < nodes[curLevel - 1].length && isLeaf[nodes[curLevel - 1][parentIndex]])
                parentIndex++;
            while (index < nodes[curLevel].length) {
                parentList[nodes[curLevel][index]] = nodes[curLevel - 1][parentIndex];
                for (int i = 0; i < distance.length; i++) {
                    if (i != nodes[curLevel - 1][parentIndex]) {
                        distance[i][nodes[curLevel - 1][parentIndex]] = distance[i][nodes[curLevel][index]] - 1;
                        distance[nodes[curLevel - 1][parentIndex]][i] = distance[nodes[curLevel][index]][i] - 1;
                    } else
                        distance[i][i] = 0;
                }
                if (index + 1 < nodes[curLevel].length && distance[nodes[curLevel][index]][nodes[curLevel][index + 1]] > 2) {
                    parentIndex++;
                    while (parentIndex < nodes[curLevel - 1].length && isLeaf[nodes[curLevel - 1][parentIndex]])
                        parentIndex++;
                }
                index++;
            }
            curLevel--;
            parentIndex = 0;
            index = 0;
        }
        return parentList;
    }
}