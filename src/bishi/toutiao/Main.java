package bishi.toutiao;

import java.util.*;

class Interval {
      int start;
     int end;
     Interval() { start = 0; end = 0; }
     Interval(int s, int e) { start = s; end = e; }
 }
public class Main {
     class MyComparator implements Comparator<Interval> {
        @Override
        public int compare(Interval a,Interval b){
//            if(a.start != b.start)
            return b.start-a.start;

        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        List<Interval> list = new ArrayList<Interval>();
        int start = 0 ;
        int end = 0;
        Interval interval = new Interval(start, end);
        Main test = new Main();

        for(int i = 0; i < n; i++){
            start = in.nextInt();
            end = in.nextInt();
            interval.start = start;
            interval.end = end;
            list.add(interval);
        }
        int max = list.get(0).end;
        List<Interval> result = new ArrayList<Interval>();
        result.add(list.get(0));
        for(int i = 1; i < n;i++){
            if(list.get(i).end >= max){
                result.add(list.get(i));
                max = list.get(i).end;
            }
        }
        for(int i = result.size()-1; i >= 0;i--){
            System.out.print(result.get(i).start);
            System.out.print(" ");
            System.out.println(result.get(i).end);


        }
    }


}


/*
public class Solution {
    class MyComparator implements Comparator<Interval>{
        @Override
        public int compare(Interval a,Interval b){
            return a.start-b.start;
        }
    }
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        intervals.add(newInterval);
        Collections.sort(intervals,new MyComparator());
        List<Interval> list=new ArrayList<Interval>();
        if(intervals.size()==0) return list;
        list.add(intervals.get(0));
        for(Interval li:intervals){
            if(li.start>list.get(list.size()-1).end){
                list.add(li);
            }
            else{
                list.get(list.size()-1).end=Math.max(li.end,list.get(list.size()-1).end);
            }
        }
        return list;
    }
}
*/
