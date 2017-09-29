/*Created by ${USER} on ${DATE}.
 *题意：在一个已经排好序的集合里插入一个新的集合 并合并重复范围
 *注意：
 *思路：1.按照上一题的思路，
 *     2.作比较，先比较新集合的start和前一个集合的end的大小  分几种情况讨论 需要合并的情况下去最值
 *     3.最后不要忘记 把剩余的都拿出来
 *一刷：
 *二刷： 按照56题的思路 把新的集合插进去 然后重新排序 做整理
 *复杂度分析：
 *反思：
 *
 *
 */
//第一次
public class Solution {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> ret=new ArrayList<Interval>();
        int i=0;
        for(i=0;i<intervals.size();i++){
            if(newInterval.start>intervals.get(i).end)
                ret.add(intervals.get(i));
            else if(newInterval.end<intervals.get(i).start)
                break;
            else{
                newInterval.start=Math.min(newInterval.start,intervals.get(i).start);
                newInterval.end=Math.max(newInterval.end,intervals.get(i).end);
            }
        }
        ret.add(newInterval);
        for(;i<intervals.size();i++)
            ret.add(intervals.get(i));
        return ret;
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
