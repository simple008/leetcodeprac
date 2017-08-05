package codejam;

/**
 * Created by lpeiz on 2017/7/15.
 */
import java.util.*;
import java.io.*;
public class Main {
    class TeCa{
        public TeCa(){}
        int start;
        int frequency;
        int duration;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int cityNum = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
        int time;
        int deadLine;
        TeCa[] demo = new TeCa[cityNum-1];
        for (int i = 1; i <= 2; ++i) {
            time = in.nextInt();
            deadLine = in.nextInt();
//            System.out.println("Case #" + i + ": " + (n + m) + " " + (n * m));
        }
        int i = 0;
        while(in.hasNext()){
            demo[i].start = in.nextInt();
            demo[i].frequency = in.nextInt();
            demo[i].duration = in.nextInt();
        }

    }
}

