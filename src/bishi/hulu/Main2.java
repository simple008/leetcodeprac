package bishi.hulu;

/**
 * Created by lpeiz on 2017/9/21.
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long m, n;
        m = sc.nextLong();
        n = sc.nextLong();
        //	System.out.println(m);
        //	System.out.println(n);
        String str = String.valueOf(m);
        int len = str.length();
        //	System.out.println(len);
        List<Long> dp = new ArrayList<Long>();
        List<Long> map = new ArrayList<Long>();
        dp.add((long) 1);
        long w = 1;
        for(int i = 1; i < len; i ++) {
            w *= 10;
            dp.add(dp.get(i - 1) + w);
        }
        String s = str;
        map.add((long) 1);
        w = 1;
        for(int i = 1; i < len; i ++) {
            s = s.substring(0, s.length() - 1);
            w *= 10;
            map.add(dp.get(i - 1) + (m - w * Long.parseLong(s)) + 1);
        }
        String ans = "";
        int compare = 0;
        for(int i = 0; i < len; i ++) {
            for(int j = (i == 0 ? 1 : 0); j < 10; j ++) {
                if(n == 1) {
                    ans += j;
                    i = len;
                    break;
                }
                int c = compare;
                if(c == 0) {
                    if(str.charAt(i) - '0' > j) {
                        c = -1;
                    } else if(str.charAt(i) - '0' < j) {
                        c = 1;
                    }
                }
                if(c == -1) {
                    if(n - dp.get(len - i - 1) > 0) {
                        n -= dp.get(len - i - 1);
                    } else {
                        ans += j;
                        n --;
                        compare = c;
                        break;
                    }
                } else if(c == 0) {
                    if(n - map.get(len - i - 1) > 0) {
                        n -= map.get(len - i - 1);
                    } else {
                        ans += j;
                        n --;
                        compare = c;
                        break;
                    }
                } else {
                    if(n - dp.get(len - i - 2) > 0) {
                        n -= dp.get(len - i -2);
                    } else {
                        ans += j;
                        n --;
                        compare = c;
                        break;
                    }
                }
            }
        }
        System.out.println(ans);
    }

}
