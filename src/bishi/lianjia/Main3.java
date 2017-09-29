package bishi.lianjia;

import java.util.Scanner;
import java.util.TreeSet;

/**
 * Created by lpeiz on 2017/8/19.
 */
public class Main3 {
    public static void main(String[] args) {
        TreeSet<Integer> set =new TreeSet<>();
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        for(int i = 0; i < n; i++){
            set.add(in.nextInt());
        }
        for(int num : set){
            System.out.println(num);
        }
    }
}