/*Created by ${USER} on ${DATE}.
 *题意：找出数组中4个数字的组合  其和等于给定的目标值
 *注意：
 *思路：
 *一刷：仿照3sum的思路，多套一层循环
 *二刷：
 *复杂度分析：
 *反思：
 *
 *
 */
//第一次
public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> list=new ArrayList<List<Integer>>();
        if(nums.length<4) return list;
        for(int i=0;i<nums.length-3;i++){
            for(int j=i+1;j<nums.length-1;j++){
                int k=j+1,l=nums.length-1;
                while(k<l){
                    if(nums[i]+nums[j]+nums[k]+nums[l]<target){
                        k++;
                        continue;
                    }
                    else if (nums[i]+nums[j]+nums[k]+nums[l]>target){
                        l--;
                        continue;
                    }
                    else
                    {
                        list.add(Arrays.asList(nums[i],nums[j],nums[k],nums[l]));
                        while(k<l&&(nums[l]==nums[l-1]))
                            l--;
                        while(k<l&&(nums[k]==nums[k+1]))
                            k++;

                        l--;
                        k++;
                        // j++;
                    }
                }
                while(j<nums.length-2&&(nums[j]==nums[j+1]))
                    j++;
            }
            while(i<nums.length-3&&nums[i]==nums[i+1])
                i++;
        }
        return list;
    }
}
//第二次 同第一次

public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> list=new ArrayList<List<Integer>>();
        if(nums.length==0||nums.length<4)
            return list;
        for(int i=0;i<nums.length-3;i++){
            for(int j=i+1;j<nums.length-2;j++){
                int k=j+1;
                int l=nums.length-1;
                while(k<l){
                    int sum=nums[i]+nums[j]+nums[k]+nums[l];
                    if(sum>target){
                        while(k<l&&nums[l]==nums[l-1])
                            l--;
                        l--;
                    }
                    else if(sum<target){
                        while(k<l&&nums[k]==nums[k+1])
                            k++;
                        k++;
                    }
                    else {
                        list.add(Arrays.asList(nums[i],nums[j],nums[k],nums[l]));
                        while(k<l&&nums[k]==nums[k+1])
                            k++;
                        k++;                           //注意两次操作 一次在while循环内 避免重复情况，一次是进行下一次组合的查找
                        while(k<l&&nums[l]==nums[l-1])
                            l--;
                        l--;
                    }
                }
                while(j<nums.length-2&&nums[j]==nums[j+1])
                    j++;
            }
            while(i<nums.length-3&&nums[i]==nums[i+1])
                i++;
        }
        return list;
    }
}