package bishi.hiho;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by lpeiz on 2017/3/31.
 */
public class sequence {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        int count=0;
        HashMap map=new HashMap();
        ArrayList list=new ArrayList();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                count++;
            }
            else count--;
        }
        int diff=Math.abs(count);
        for(int i=0;i<s.length();i++){
            if(count>0){


            }else if (count<0){

            }else System.out.println(0+""+0);

        }
    }
    public void dfs(){

    }

}
