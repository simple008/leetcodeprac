package bishi.wuyi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by lpeiz on 2017/9/18.
 */
public class Main {
    static class xp{
        int num = 0;
        int vote = 0;
        public xp(int num, int vote){
            this.num = num;
            this.vote = vote;
        }
        public void setNum(){
            num++;
        }
        public void setVote(Integer vote){
            this.vote += vote;
        }
    }
    public static void main(String[] args) {
        Scanner in  = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<Integer>();
        int ii  =0;
        while(in.hasNext()){
            list.add(in.nextInt());
            ii++;
            if(ii==14) break;
        }
        int len = list.size();
        int index = len /2 - 1;
        HashMap<Integer, xp> map  = new HashMap<>();
        int max = 0;
        int candidate = 0 ;
        xp xp =new xp(0,0);
        for(int i = 0; i <= index; i++ ){
            int can = list.get(i);
            if(!map.containsKey(can)){
                map.put(can,new xp(1,list.get(i+index+1)));
                if(list.get(i+index+1) > max){
                    candidate = can;
//                    max = map.get(can);
                    max = list.get(i+index+1);
                }
//                max = Math.max(max, list.get(i+index+1));
            }else{
                xp = map.get(can);
                xp.setNum();
                xp.setVote(list.get(i+index+1));
                map.put(can, xp);
                if(map.get(can).vote > max){
                    candidate = can;
                    max = map.get(list.get(i)).vote;
                }else if(map.get(can).vote == max){
                    candidate = map.get(candidate).num > map.get(can).num ? candidate : can;
                }
//                max = Math.max(max, map.get(list.get(i)));
            }
        }
        System.out.println(candidate);
    }
}
