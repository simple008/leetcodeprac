package bishi.SAP;

import java.util.Scanner;

/**
 * Created by lpeiz on 2017/9/24.
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[][] arr = new int[n][m];
        for(int i = 0; i < n; i++){
            String s = in.nextLine().trim();

            for (int j = 0; j < m; j++){
                arr[i][j] = s.charAt(j) == '.' ? 0:1;
            }
        }
        int des = in.nextInt();

        int[][] dp = new int[n][m];
        for(int i = 0; i < m; i++){
            dp[0][i] = arr[0][i];
        }
        for(int i = 1; i < n; i++){
            for(int j = 0; j < m; j++){
                dp[i][j] = dp[i-1][j] + arr[i][j];
            }
        }
        for(int i = 1; i < n; i++){
            for(int j = 1; j < m; j++){
                dp[i][j] = dp[i][j-1] +  dp[i][j];
            }
        }

        int result = 0;
        int ii = 0, jj = 0, kk = 0, ll = 0;
        int max = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                for(int k = 0; k < i; k++){
                    for(int l = 0; l < j; l++){
                        result = dp[i][j] - dp[k][j] - dp[i][l] + dp[k][l];
                        if(result == des && getStep(i, j, k, l,n,m) < max){
                            max = getStep(i, j, k, l,n,m);
                        }
                    }
                }
            }
        }
        System.out.println(max);
    }
    public static int getArea(int i, int j, int k, int l){
        return i * j - k * j - i * l + k * l;
    }
    public static int getStep(int i, int j, int k, int l, int n, int m){
        return k + l +n - i + m -j;
    }
}


/**
 3 4 .x..
 xxxx
 ..x.
 3
 */