/*Created by ${USER} on ${DATE}.
 *题意：数组中有重复数字，产生所有排列组合
 *注意：
 *思路：
 *一刷：
 *二刷：
 *复杂度分析：
 *反思：
 */




//第一次
public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(nums==null || nums.length==0) return res;
        boolean[] used = new boolean[nums.length];
        List<Integer> list = new ArrayList<Integer>();
        Arrays.sort(nums);
        dfs(nums, used, list, res);
        return res;
    }

    public void dfs(int[] nums, boolean[] used, List<Integer> list, List<List<Integer>> res){
        if(list.size()==nums.length){
            res.add(new ArrayList<Integer>(list));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(used[i]) continue;
            if(i>0 &&nums[i-1]==nums[i] && !used[i-1]) continue;
            used[i]=true;
            list.add(nums[i]);
            dfs(nums,used,list,res);
            used[i]=false;
            list.remove(list.size()-1);
        }
    }
}
//
public class Solution {
    public List<List<Integer>> permuteUnique(int[] num) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        Arrays.sort(num);
        int i=0;
        do
        {
            List<Integer> list=new ArrayList<Integer>();
            for(int n:num){
                list.add(n);
            }
            ans.add(list);
        } while(nextPermutation(num));
        return ans;
    }


    public boolean nextPermutation(int[] num) {
        // find the last adjacent two element that is in ascending order
        int i = num.length - 1;
        while (i > 0 && num[i - 1] >= num[i]) {
            i--;
        }

        // if the sequence is already in descending order, reverse the whole sequence
        if (i == 0) {
            reverse(num, 0, num.length - 1);
            return false;
        }

        // find the last element that is larger than num[i-1]
        int j = num.length - 1;
        while (j >= i && num[i - 1] >= num[j]) {
            j--;
        }

        // exchange num[i-1] and num[j]
        int tmp = num[i - 1];
        num[i - 1] = num[j];
        num[j] = tmp;

        // reverse the sequence after i-1
        reverse(num, i, num.length - 1);
        return true;
    }


    public void reverse(int[] num, int start, int end) {
        int l = start;
        int r = end;
        while (l < r) {
            int tmp = num[l];
            num[l] = num[r];
            num[r] = tmp;
            l++;
            r--;
        }
    }
}
//第二次  用visited 来记录是否被访问过，如果i和i-1相等同时visited[i-1]==0 说明i-1 已经访问过了同时不在现在的序列中，说明是会重复的，如果在这个序列中就不会重复
    1,2,2
    public List<List<Integer>> permuteUnique(int[] num) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        ArrayList<Integer> list = new ArrayList<Integer>();
        int[] visited = new int[num.length];
        Arrays.sort(num);
        helper(result, list, visited, num);
        return result;
    }
    public void helper(List<List<Integer>> result, List<Integer> list, int[] visited, int[] num) {
        if(list.size() == num.length)
            result.add(new ArrayList<Integer>(list));
        for(int i = 0; i < num.length; i++) {
            if (visited[i] == 1 || (i != 0 && num[i] == num[i - 1] && visited[i - 1] == 0))
                continue;
            visited[i] = 1;
            list.add(num[i]);
            helper(result, list, visited, num);
            list.remove(list.size() - 1);
            visited[i] = 0;
        }
    }

