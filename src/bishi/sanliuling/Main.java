package bishi.sanliuling;

import java.util.Scanner;

/**
 * Created by lpeiz on 2017/9/20.
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] bar = new int[n + 1];
        for(int i = 1; i < n+1; i++){
            bar[i] = in.nextInt();
        }
        int times = in.nextInt();
        for(int i = 0; i < times; i++){
            result(in.nextInt(), in.nextInt(),bar);
        }

    }
    public static void result(int l, int r, int[] bar){
        int cnt = 0;
        int result= 0 ;
        for(int i = l + 1; i <= r; i++){
            if(bar[i] >= bar[i-1]){
                cnt++;
            }else{
                cnt =0;
            }
            if(cnt >= 2){
                result++;
            }
        }
        System.out.println(result);
    }
}
