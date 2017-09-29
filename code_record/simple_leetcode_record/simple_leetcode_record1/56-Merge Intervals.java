/*Created by ${USER} on ${DATE}.
 *题意：合并相同范围的集合  集合的开始和结束可以获取
 *注意：
 *思路：比较当前集合的开始元素跟上一个集合的结束元素的大小 小就直接加进去，大拎出来做比较改变上一个集合
 *一刷：先排序后比较遍历
 *二刷：
 *复杂度分析：
 *反思：
 *比较器的写法还是不行
 *
 *//
//第一次
/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    class MyComparator implements Comparator<Interval>{
        @Override
        public int compare(Interval a,Interval b){
            return a.start-b.start;
        }
    }
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> ans=new ArrayList<Interval>();
        if(intervals.size()==0) return intervals;

        Collections.sort(intervals,new MyComparator());

        int start=intervals.get(0).start;
        int end=intervals.get(0).end;
        for(int i=1;i<intervals.size();i++){
            Interval inter=intervals.get(i);
            if(inter.start>end){
                ans.add(new Interval(start,end));
                start=inter.start;
                end=inter.end;
            }
            else{
                end=Math.max(end,inter.end);
            }
        }
        ans.add(new Interval(start,end));
        return ans;
    }

}

//第二次
public class Solution {
    class MyComparator implements Comparator<Interval>{
        @Override
        public int compare(Interval a,Interval b){
            return a.start-b.start;
        }
    }
    public List<Interval> merge(List<Interval> intervals) {
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