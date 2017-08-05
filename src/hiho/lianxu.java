package hiho;

/**
 * Created by lpeiz on 2017/4/11.
 */

import java.util.Scanner;

/**
 * Created by lpeiz on 2017/3/31.
 */

public class lianxu {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String nn = in.nextLine();


        int m = in.nextInt();
        int n = 0;
        String s = "";
        System.out.printf("%d: %s", n, s);
        int index = 2;
        int sum =1;
        while(n > index){
            sum*=index;
            n -= index;
            index++;
        }

        sum  = sum*(index)/(index-n);
    }
}
