package javaDemo;

import java.util.Comparator;
import java.util.TreeMap;

/**
 * Created by lpeiz on 2017/7/30.
 */
public class TreeMapTest {
    public static void main(String[] args) {


    TreeMap<String, String> amap = new TreeMap<String, String>(new Comparator<String>() {
        public int compare(String s1, String s2) {
            return s2.compareTo(s1);
        }

    });
        amap.put("3", "b");
    amap.put("1","a");
    amap.put("2", "b");
        System.out.println(amap);
}
}
