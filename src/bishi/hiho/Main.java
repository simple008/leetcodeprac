package bishi.hiho;

/**
 * Created by lpeiz on 2017/3/31.
 */

        import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String n = in.nextLine();


        int m = in.nextInt();
        int a = 0;
        String s = "";
        System.out.printf("%d: %s", a, s);
    }
    public void mysort(int[] intArray, int[] intArray1, int low, int high){

        if(low >= high) return;
        int left = low;
        int right = high;
        int temp = intArray[low];
        while(left < right){
            while(intArray[right] >= temp && right > left) right--;
            if(left < right){
                intArray[left] = intArray[right];
                left++;
            }
            while(intArray[left] <= temp && left < right) left++;
            if(left < right){
                intArray[right] = intArray[left];
                right--;
            }

        }

    }
}
