/*Created by ${USER} on ${DATE}.
 *题意：
 *注意：
 *思路：
 *一刷：
 *二刷：
 *复杂度分析：
 *反思：
 *
 *
 */

//第一次

public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result=new ArrayList<List<Integer>>();

        getResult(result,new ArrayList<Integer>(),candidates,target,0);
        return result;
    }

    private void getResult(List<List<Integer>> result, List<Integer> cur, int candidates[], int target, int start){
        if(target>0){
            for(int i=start;i<candidates.length&&candidates[i]<=target;i++){
                cur.add(candidates[i]);
                getResult(result,cur,candidates,target-candidates[i],i);
                cur.remove(cur.size()-1);
            }
        }
        else if (target==0){
            result.add(new ArrayList<Integer>(cur));
        }

    }
}

//