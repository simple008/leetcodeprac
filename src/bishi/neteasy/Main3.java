package bishi.neteasy;

import java.util.Scanner;

/**
 * Created by lpeiz on 2017/9/25.
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int res = in.nextInt();
        if(n < 1) return ;
        System.out.println(printProbability(n, res));

    }

    public static String printProbability(int number, int res) {

        int g_maxValue = 6;
        int[][] probabilities = new int[2][];
        probabilities[0] = new int[g_maxValue * number + 1];
        probabilities[1] = new int[g_maxValue * number + 1];
        int flag = 0;
        for (int i = 1; i <= g_maxValue; i++)
            probabilities[0][i] = 1;
        for (int k = 2; k <= number; ++k) {
            for (int i = 0; i < k; ++i)
                probabilities[1 - flag][i] = 0;
            for (int i = k; i <= g_maxValue * k; ++i) {
                probabilities[1 - flag][i] = 0;
                for (int j = 1; j <= i && j <= g_maxValue; ++j)
                    probabilities[1 - flag][i] += probabilities[flag][i - j];
            }
            flag = 1 - flag;
        }
        long total = (long)Math.pow(g_maxValue, number);
        long sum = 0;
        for (int i = number; i < res; i++) {
            sum += probabilities[flag][i];

            double ratio = (double) probabilities[flag][i] / total;
            System.out.println(flag);
            System.out.println(i);
            System.out.println(total);
            System.out.println(ratio);
        }
        if(sum == 0) return "0";
        if(sum == total ) return "1";
        long fac = maxFac(sum,total);
        /*System.out.println(sum);
        System.out.println(total);
        System.out.println(fac);*/
        sum = sum/fac;
        total = total/fac;

        return String.valueOf(total-sum)+"/"+String.valueOf(total);
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
