/*Created by ${USER} on ${DATE}.
 *题意：从1-9 中去k个数  和为n    求这种组合数
 *注意：
 *思路：dfs 从1开始 递归找
 *一刷：
 *二刷：
 *复杂度分析：
 *反思：
 */
//第一次
public class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result=new ArrayList<List<Integer>>();
        List<Integer> list=new ArrayList<Integer>();
        getCombination(result,new ArrayList<Integer>(),1,n,k);
        return result;
    }
    public void getCombination(List<List<Integer>> result,List<Integer> list,int start,int n,int k){
        if(n<0||k<0) return ;
        if(k==0&&n==0)  result.add(new ArrayList<Integer>(list));
        for(int i=start;i<=9;i++){
            list.add(i);
            getCombination(result,list,i+1,n-i,k-1);
            list.remove(list.size()-1);
        }
    }
}


//第二次
public class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result=new ArrayList<List<Integer>>();
        List<Integer> list=new ArrayList<Integer>();
        getCombination(result,new ArrayList<Integer>(),1,n,k);
        return result;
    }
    public void getCombination(List<List<Integer>> result,List<Integer> list,int start,int n,int k){
        if((n==0&&k!=0)||(n!=0&&k==0)||n*k<0) return ;
        if(k==0&&n==0)  result.add(new ArrayList<Integer>(list));

        for(int i=start;i<=9;i++){
            list.add(i);
            getCombination(result,list,i+1,n-i,k-1);
            list.remove(list.size()-1);
        }
    }
}

