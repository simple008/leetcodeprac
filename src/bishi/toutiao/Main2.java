/*
package bishi.toutiao;

import java.util.*;

public class Main2 {
    public static int maxResult = 0;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int[] nums = new int[n];

        for(int i = 0; i < n; i++){
            nums[i] = in.nextInt();
        }

        int[] sum = new int[n + 1];
        sum[0] = 0;
        int[][] arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            sum[i + 1] = sum[i] + nums[i];
            arr[i][i] = nums[i];
        }

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (i == j) {
                    arr[i][j] = nums[i];
                    maxResult = Math.max(maxResult, arr[i][j]*arr[i][j]);
                } else {
                    arr[i][j] = Math.min(arr[i][j - 1], nums[j]);
                }
                maxResult = Math.max(maxResult, (sum[j + 1] - sum[i]) * arr[i][j]);
            }
        }
        System.out.println(maxResult);
    }
}

 class Main0{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int []v = new int[n];
        for(int i = 0; i < n; i++){
            v[i] = in.nextInt();
        }
        long m=0;
        Long max = Long.MIN_VALUE;
        for(int i = 0; i < n; i++){
            {
                int min=v[i];
        long sum=0;
                for (int j = i; j < n ; j++)
                {
                    if (v[j]<min)
                    {
                        min= v[j];
                    }
                    sum+=v[j];
                    if(sum*min>max)
                        max=sum*min;
                    if(max >= m * min)
                        break;
                }
            }
        }
        System.out.println(max);
    }
}


import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] v = new int[n];
        long m = 0;
        for(int i = 0; i < n; i++){
            v[i] = sc.nextInt();
            m +=v[i];
        }
        long res = 1<<31;
        for (int i = 0; i < n; i++)
        {
            int min=v[i];
            long sum=0;
            for (int j = i; j < n ; j++)
            {
                if (v[j]<min)
                {
                    min= v[j];
                }
                sum+=v[j];
                if(sum*min>res)
                    res=sum*min;
                if(res >= m * min)
                    break;
            }
        }
        System.out.println(res);
    }
}*/
