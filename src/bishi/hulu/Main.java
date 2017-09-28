package bishi.hulu;

import java.util.Scanner;

/**
 * Created by lpeiz on 2017/9/21.
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int [][] arr = new int[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                arr[i][j] = in.nextInt();
            }
        }

        for(int i = 0; i < n; i++){
            int index = arr[i][0];
            int start = 0;
            int count = index;
            boolean flag = false;
            for(int j = 0; j < n; j++){
                if(!flag && arr[i][j] != 0){
                    index = arr[i][j];
                    flag = true;
                }
                if(arr[i][j] == index || arr[i][j] == 0){
                    count+=arr[i][j];
                    if(j-start == 5){
                        if(count == 4 * index){
                            System.out.println(index);
                        }else{
                            count-=arr[i][start];
                            start++;
                        }
                    }
                }else{
                    index = arr[i][j];
                    start = j;
                    count = index;
                }
            }
        }

        for(int i = 0; i < n; i++){
            int index = arr[0][i];
            int start = 0;
            int count = index;
            for(int j = 1; j < n; j++){
                if(arr[j][i] == index || arr[j][i] == 0){
                    count+=arr[j][i];
                    if(i-start == 5){
                        if(count == 4 * index){
                            System.out.println(index);
                        }else{
                            count-=arr[j][start];
                            start++;
                        }
                    }
                }else{
                    index = arr[j][i];
                    start = i;
                    count = index;
                }
            }
        }

    }
}


/*
if(arr[0][0] == 0 && arr[0][1] != 2)
        System.out.println(1);
        else
        System.out.println(2);*/
