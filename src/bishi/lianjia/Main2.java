package bishi.lianjia;

import java.util.Scanner;

/**
 * Created by lpeiz on 2017/8/19.
 */
public class Main2 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int len = in.nextInt();
        int[] arr = new int [len+1];

        for(int i = 1; i < len+1; i++){
            arr[i] = in.nextInt() + arr[i-1];
        }
        int n = in.nextInt();
        for(int i = 0; i < n; i++){
            System.out.println(select(arr,in.nextInt()));
        }
    }
    public static int select(int[] arr, int height){
        for(int i = 1; i < arr.length; i++){
            if(arr[i-1] < height && arr[i] >= height){
                return i;
            }
        }
        return 0;
    }
}
