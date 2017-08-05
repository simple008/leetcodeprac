package practice;

import java.util.Scanner;

/**
 * Created by lpeiz on 2017/3/18.
 */
public class third {
    public static void main(String[]args){
        Scanner in =new Scanner(System.in);
        int num=in.nextInt();
        int res[]=new int[2];
        for(int i=0;i<num;i++){
            int len =in.nextInt();
            int [] cas=new int[len];
            for(int j=0;j<len;j++){
                cas[j]=in.nextInt();
            }
            res=getMax(cas);
            System.out.println("Case #"+num+":"+res[0]+" "+res[1]);
        }
     /* third he=new third();
//        int []test={4,7,2,9,5,2};
        int []test={140,649,340,982,105,86,56,610,340,879};
        getMax(test);*/

    }
    public  static int [] getMax(int arr []) {

        int res[] = new int[2];
        if (arr.length == 0) return res;
        int len = arr.length;
        int left = 0;
        int right = len - 1;
        int total_A = 0;
        int total_B = 0;
        while (left < right) {
            if (arr[left] < arr[right]) {
                total_A += arr[right];
                --right;
            } else {
                total_A += arr[left];
                ++left;
            }
            if (arr[left] < arr[right]) {
                total_B += arr[right];
                --right;
            } else {
                total_B += arr[left];
                ++left;
            }
        }
        res[0] = total_A;
        res[1] = total_B;
//        System.out.println(total_A);
//        System.out.println(total_B);
        return res;
    }

}
