/*Created by ${USER} on ${DATE}.
 *题意：把数组的各类子集加到集合中，类似上一题 不需要判断 列表的大小直接加
 *注意：
 *思路：每调用一次回溯方法就把当前列表加进去，for循环遍历，递归调用之后弹出最后一个元素
 *一刷：
 *二刷：
 *复杂度分析：
 *反思：
 */

//第一次
public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(list, new ArrayList<>(), nums, 0);
        return list;
    }

    private void backtrack(List<List<Integer>> list , List<Integer> tempList, int [] nums, int start){
        list.add(new ArrayList<>(tempList));
        for(int i = start; i < nums.length; i++){
            tempList.add(nums[i]);
            backtrack(list, tempList, nums, i + 1);
            tempList.remove(tempList.size() - 1);
        }
    }
}


//第二次   同上一题 判断条件 不需要了，每次调用方法都把当前列表加进去
public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list=new ArrayList<List<Integer>>();
        if(nums.length==0) return list;
        List<Integer> li=new ArrayList<Integer>();
        getSub(nums,0,list,new ArrayList<Integer>());
        return list;
    }
    public void getSub(int []nums,int index,List<List<Integer>> list,List<Integer> li){
        list.add(new ArrayList<Integer>(li));
        for(int i=index;i<nums.length;i++){
            li.add(nums[i]);
            getSub(nums,i+1,list,li);
            li.remove(li.size()-1);
        }
    }
}
