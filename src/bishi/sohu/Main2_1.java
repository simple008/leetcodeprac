package bishi.sohu;

import java.util.Scanner;

//zwl
public class Main2_1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] nums = new int[m];
        for (int i = 0; i < m; i++) {
            nums[i] = in.nextInt();
        }
        if (m > 0) {
            int cur = 0;
            int nextIndex = 1;
            int len = nums[cur];
            int curLen = 0;
            int[] result = new int[n];
            for (int i = 0; i < n; ) {
                if (curLen < len) {
                    result[i] = nums[cur];
                    curLen++;
                    i++;
                } else {
                    curLen = 0;
                    cur = (cur + 1) % m;
                    if (nextIndex == i) {
                        len = nums[cur];
                    } else {
                        len = result[nextIndex];
                    }

                    nextIndex++;
                }
            }
            for(int i = 0; i<m;i++){
                System.out.println(result[i]);
            }
        }
    }
}
