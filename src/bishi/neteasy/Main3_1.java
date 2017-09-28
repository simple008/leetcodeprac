package bishi.neteasy;

import java.util.Scanner;

/**
 * Created by lpeiz on 2017/9/25.
 */
public class Main3_1 {
     public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

            int n = in.nextInt();
            int des = in.nextInt();
             long[][] dp = new long[30][200];
            for (int i = 1; i <= 24; i ++)
                for (int j = 1; j <= 150; j ++) {
                    if (i == 1 && j <= 6)
                        dp[i][j] = 1;
                    for (int k = 1; k <= 6; k ++) {
                        if (j >= k)
                            dp[i][j] += dp[i - 1][j - k];
                    }
                }
            long res = 0;
            long total = 0;
            long fac = 0;

            for(int i = n; i <= n * 6; i++)
            {
                total += dp[n][i];
                if(des <= i)
                    res += dp[n][i];
            }
            if(res == total)
                System.out.println(1);
            else if(res == 0)
                System.out.println(0);
            else
            {
                fac = maxFac(res, total);
                System.out.println((res/fac) + "/" + (total/fac));
            }
        }

    public static long maxFac(long m, long n) {
        while (m % n != 0) {
            long temp = m % n;
            m = n;
            n = temp;
        }
        return n;
    }

}
