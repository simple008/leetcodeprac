package bishi.sohu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();

        int[] nums = new int[m];
        for(int i = 0; i < m; i++){
            nums[i] = in.nextInt();
        }
        List<Integer> list = new ArrayList<Integer>();
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
        for(int i= 0; i< list.size(); i++){
            System.out.println(list.get(i));
        }
    }
}
