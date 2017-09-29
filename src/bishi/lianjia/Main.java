package bishi.lianjia;

import java.util.Scanner;

/**
 * Created by lpeiz on 2017/8/19.
 */
public class Main {
    public static void main(String[] args) {
        Scanner in  = new Scanner (System.in);
        int[] apple = new int [10];
        for(int i = 0; i < 10; i++){
            apple[i] = in.nextInt();
        }
        int height = in.nextInt();
        int cnt = 0;

        for(int i = 0; i < 10; i++){
            if(apple[i] <= height + 30){
                cnt++;
            }
        }
        System.out.println(cnt);
    }


}
