/*Created by ${USER} on ${DATE}.
 *题意：含有重复数字的 子集合问题。
 *注意：
 *思路：每调用一次递归方法就把现在的临时列表加进去，从空集合开始。
 *      处理重复问题，用start来控制，如果当前遍历的i是第一次遍历那么不会重复，
 *      122 在生成到第二个2时，start也是当前索引位置，不会重复，生成12 时 这个2如果是start位置的2没问题，如果是第二个2
 *      这时的索引位置已经不是start了 comtinue
 *
 *一刷：
 *二刷：
 *复杂度分析：
 *反思：
 */

//第一次
public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> list =new ArrayList<List<Integer>>();
        if(nums.length==0) return list;
        Arrays.sort(nums);
        backtrack(list,new ArrayList<>(),nums,0);
        return list;
    }
    public List<Integer> backtrack(List<List<Integer>> list,List<Integer> listtem,int [] nums,int start){
        list.add(new ArrayList<>(listtem));
        for(int i=start;i<nums.length;i++){
            if(i>start&&nums[i-1]==nums[i]) continue;
            listtem.add(nums[i]);
            backtrack(list,listtem,nums,i+1);
            listtem.remove(listtem.size()-1);
        }
        return listtem;
    }
}

public (List<List>> resutl , List<> ,int start, int nums, )

list.add

for(int i=start;i<nums.length;i++){
        if(i> start num[i-1]==num[i])
        li.add(addnum[i])
        backa(i=+1,)
        list.remo*(size-1)
        }