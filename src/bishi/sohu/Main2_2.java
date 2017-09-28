package bishi.sohu;

/**
 * Created by lpeiz on 2017/8/28.
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;




//zwl
public class Main2_2 {
    static int []nums = new int[10000];
    static int m;
    static int n;
    static int [] result=new int [100000];
    static List<Integer> list;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        m = in.nextInt();
        for (int i = 0; i < m; i++) {
            nums[i] = in.nextInt();
        }

        f1();
        f2();
        for(int i = 0; i<n; i++){
            if(result[i]!=list.get(i)){
                System.out.println(i);
                System.out.println("false");
            }
           /* System.out.print("resutl:"+result[i] +"    ");
            System.out.println("list:"+list.get(i));*/
        }

    }
    public static void f1(){
        if (m > 0) {
            int cur = 0;
            int nextIndex = 1;
            int len = nums[cur];
            int curLen = 0;
            for (int i = 0; i < n; ) {
                if (curLen < len) {
                    result[i] = nums[cur];
//                    System.out.println(result[i]);
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

        }
    }
    public static void f2(){

        list = new ArrayList<Integer>();

        for(int i = 0; i<nums[0]; i++){
            list.add(nums[0]);
        }

        int j = list.size() ==1 ? nums[1]:list.get(1);

        int q=1;
        while(list.size() < n) {
            for (int i = 0; i < j; i++) {
                list.add(nums[q % m]);
            }
            q++;
            j = list.get(q);
        }
     /*   for(int i= 0; i< list.size(); i++){
            System.out.println(list.get(i));
        }*/
    }
}


