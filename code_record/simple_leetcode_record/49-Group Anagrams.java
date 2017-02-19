/*Created by ${USER} on ${DATE}.
 *题意：
 *思路： 把字符串转为字符数组排序，这样就把乱序的字符串变成了有序的，再把有序的数组转为字符串，再以此为键存到hash中进行比较操作。
 *map的遍历方式
 *一刷：
 *二刷：
 *复杂度分析：
 *反思：
 * 在判断部分用一下的代码一直报错，提示no suitable constructor found for ArrayList(String)
 *
 * if(map.containsKey(sp)){
       map.get(sp).add(s);
       }
   List<String> li=new ArrayList<String>(s); //map.put(sp,new ArrayList<String>(s));
   map.put(sp,li);

 */

//第一次
public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs.length==0||strs==null) return new ArrayList<List<String>>();
        HashMap<String,List<String>> map=new HashMap<>();
        // List<List<String>> list=new ArrayList<List<Integer>>();
        for(String s:strs){
            char [] a=s.toCharArray();
            Arrays.sort(a);
            String str=String.valueOf(a);
            // List<String> ll=new ArrayList<String>();
            if(!map.containsKey(str)){
                map.put(str,new ArrayList<>());
            }
            map.get(str).add(s);

        }
        return new ArrayList<List<String>>(map.values());
    }
}
//第二次

