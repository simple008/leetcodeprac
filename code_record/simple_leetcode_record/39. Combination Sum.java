/*Created by ${USER} on ${DATE}.
 *题意：给一个不含重复数字的数组和一个目标值，找出所有和等于目标值的组合 数字可以重复出现
 *注意：
 *思路：回溯，先将数组排序。不断找出target-candidates[i]   相当于遍历
 *一刷：
 *二刷：
 *复杂度分析：
 *反思：
 *
 *
 */
//第一次

//第二次
public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
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
                getCom(candidates,target-candidates[i],i,res,list);
                list.remove(list.size()-1);
            }
        }else if(target==0){
            res.add(new ArrayList<Integer>(list));

        }
    }
}