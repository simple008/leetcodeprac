/*Created by ${USER} on ${DATE}.
 *题意：类似上一题，数组中有重复数字出现，但是数字不能重复出现在结果集合中  调整 参数变成i+1
 *注意：
 *思路：改一个参数 最后判断一下是否包含list 因为 1 1 2  这样1，2 集合可能出现两次
 *一刷：
 *二刷：
 *复杂度分析：
 *反思：
 *
 */
//基本一样的思路

public class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res=new ArrayList<List<Integer>>();
        getCom(candidates,target,0,res,new ArrayList<Integer>());
        return res;
    }
    public void getCom(int [] candidates,int target,int start,List<List<Integer>> res,List<Integer> list){
        // List<Integer> list=new ArrayList<Integer>();

        if(target>0){
            for(int i=start;i<candidates.length&&candidates[i]<=target;i++){
                list.add(candidates[i]);
                getCom(candidates,target-candidates[i],i+1,res,list);
                list.remove(list.size()-1);
            }
        }else if(target==0){
            if(!res.contains(list))
                res.add(new ArrayList<Integer>(list));
        }
    }
}