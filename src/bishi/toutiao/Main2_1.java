package bishi.toutiao;

import java.util.Scanner;

public class Main2_1 {
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
}
/*7 1
        6
        8
        12
        5
        67
        34
        4489

       12
435
762
13245
734
314
754
12
7
3424
76
72
454
175430025

        */
