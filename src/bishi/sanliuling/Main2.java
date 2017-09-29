package bishi.sanliuling;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by lpeiz on 2017/9/20.
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int t = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }

        Arrays.sort(arr);
        int max = Integer.MIN_VALUE;
        int cur = arr[0];
        int i = 0;
        int j = 0;

        while (i <= j && j < n) {
            if (cur < t) {
                if (j < n - 1) {
                    max = Math.max(max, cur + arr[n - 1]);
                    cur += arr[j];
                    j++;
                } else {
                    max = Math.max(max, (i > 0 ? cur + arr[i - 1] : cur));
                    j++;
                }
            } else {
                cur -= arr[i];
                i++;
            }
        }
        System.out.println(max);
    }
}

