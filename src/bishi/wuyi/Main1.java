package bishi.wuyi;

import java.util.Scanner;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Created by lpeiz on 2017/9/18.
 */
public class Main1 {
    static class Thr implements Runnable {
        @Override
        public void run() {
            while( !q.isEmpty()){
                String s = q.poll();
                if(s.contains("u51")){
                    add();
                }
            }

        }
    }
    static int res = 0;
    static ConcurrentLinkedQueue<String> q = new ConcurrentLinkedQueue<>();
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        for( int i = 0; i < 200000; i++){
            q.add(in.next());
        }
        for( int i = 0; i < 3; i++){
            Thread t = new Thread(new Thr());
            t.start();
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(res);
    }
    public static synchronized void add(){
        res++;
    }
}
