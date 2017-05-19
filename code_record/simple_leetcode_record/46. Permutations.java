/*Created by ${USER} on ${DATE}.
 *题意：给定一个数组 产出所有的排列
 *注意：
 *思路：两种方式，一规律插入 插到各个可以插入的位置  二 回溯
 *一刷： 插入  注意各个列表之间的关系
 *二刷：回溯
 *复杂度分析：
 *反思：
 *
 *
 */
//第一次 不断insert下一个元素
public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list=new ArrayList<List<Integer>>();
        if(nums.length==0) return list;

        list.add(Arrays.asList(nums[0]));
        for(int i=1;i<nums.length;i++){
            List<List<Integer>> list_new=new ArrayList<List<Integer>>();
            for(int j=0;j<=i;j++){
                for(List<Integer> li:list){
                    List<Integer> list_tem=new ArrayList<Integer>(li);
                    list_tem.add(j,nums[i]);
                    list_new.add(list_tem);
                }
            }
            list=list_new;
        }
        return list;
    }
}
//第二次 回溯 去重 每次都遍历一遍数组 判断现在的元素是否已经添加到列表里了
public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        if(nums==null||nums.length==0)
            return res;
        Arrays.sort(nums);
        List<Integer> onePer=new ArrayList<Integer>();
        permute(res,onePer,nums);
        return res;
    }
    public void permute(List<List<Integer>> res,List<Integer> onePer,int []nums){
        if(onePer.size()==nums.length){
            res.add(new ArrayList<Integer>(onePer));
            return ;
        }
        for(int i=0;i<nums.length;i++){
            if(onePer.contains(nums[i]))
                continue;
            onePer.add(nums[i]);
            permute(res,onePer,nums);
            onePer.remove(onePer.size()-1);
        }
    }
}

public class Solution {
    public List<List<Integer>> permute(int[] num) {

        List<List<Integer>> list =new ArrayList<List<Integer>>();
        if(num==null || num.length==0) return list;
        boolean[] visited = new boolean[num.length];
        List<Integer> tmp=new ArrayList<Integer>();
        Arrays.sort(num);
        helper(num,visited,tmp,list);
        return list;
    }
    public void helper(int[] num,boolean[] visited,List<Integer> tmp,List<List<Integer>> list){
        if(tmp.size()==num.length){
            list.add(new ArrayList<Integer>(tmp));
            return ;
        }
        for(int i = 0;i<num.length;i++){
            if(visited[i]) continue;
            /*if(i>0&&num[i]==num[i-1]&&visited[i-1]==false)
                continue;*/
            tmp.add(num[i]);
            visited[i]=true;
            helper(num,visited,tmp,list);
            visited[i]=false;
            tmp.remove(tmp.size()-1);
        }
    }
}