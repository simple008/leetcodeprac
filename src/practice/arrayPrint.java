package practice;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by lpeiz on 2017/4/20.
 */
public class arrayPrint {
    public static void main(String[]args){
        int [] a ={1,2,3,4,5,6,6};
        Arrays.toString(a);
        System.out.println(Arrays.toString(a).charAt(0));
        HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
        map.put(1,2);
        map.put(4,12);
        map.put(3,3);
        map.put(10,12);
        map.put(2,3);
        for(int cnt:map.keySet()){
            for(int i = 0; i<map.get(cnt);i++){
                System.out.print(cnt + ",");
            }
        }
    }
}
