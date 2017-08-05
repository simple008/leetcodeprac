/*
package nowcoder;

import java.util.Scanner;

*/
/**
 * Created by lpeiz on 2017/3/25.
 *//*

public class demo     {
     public static void main(String[]args){
        String b="adf";
        Scanner in=new Scanner(System.in);
         in.next
        System.err.println(b);

    }
}

public class Main {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        while (cin.hasNextInt()) {
            int n = cin.nextInt();
            int m = cin.nextInt();
            int[] keep = new int[100002];
            for (int i = 1; i < n; i++) {
                keep[cin.nextInt()] = 1;
            }
            int last = cin.nextInt();
            keep[last] = 1;
            int[] tmp = new int[m];
            for (int i = 0; i < m; i++) {
                tmp[i] = cin.nextInt();
            }
            for (int i = 0; i < m; i++) {
                int j = tmp[i];
                for (; keep[j] != 0; j++) ;
                System.out.println(j);
            }
        }
    }
}
*/
