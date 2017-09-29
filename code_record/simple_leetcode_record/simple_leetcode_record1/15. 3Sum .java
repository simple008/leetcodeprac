/*Created by ${USER} on ${DATE}.
 *题意：给一个数组找出所有三个数的 和为零 的所有组合，不能有重复的组合 但是原数组中有重复的数字
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
    public List<List<Integer>> threeSum(int[] nums) {

        Arrays.sort(nums);
        List<List<Integer>> list=new ArrayList<List<Integer>>();
        for(int i=0;i<nums.length-2;i++){
            int j=i+1;
            int k=nums.length-1;
            while(j<k){
                if(nums[i]+nums[j]+nums[k]<0){
                    j++;
                }else if(nums[i]+nums[j]+nums[k]>0){
                    k--;
                }else{
                    list.add(Arrays.asList(nums[i],nums[j],nums[k]));
                    while(j<k&&nums[k]==nums[k-1])
                        k--;
                    while(j<k&&(nums[j]==nums[j+1]))
                        j++;

                    j++;
                    k--;
                    while((i<nums.length-2)&&(nums[i]==nums[i+1]))
                        i++;

                }
            }
        }
        return list;
    }
}


//算法超时  这个算法是遍历
public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int i=0;
        List <List<Integer>> list=new ArrayList<List<Integer>>();
        if(nums.length<3) return list;
        while(i<nums.length-2){
            for (int j=i+1;j<nums.length-1;j++){
                for(int k=j+1;k<nums.length;k++){
                    if(nums[i]+nums[j]+nums[k]==0){
                        list.add(Arrays.asList(nums[i],nums[j],nums[k]));
                        while(j+1<nums.length-1&&nums[j]==nums[j+1])
                            j++;
                        while(nums[i]==nums[i+1]&&i<nums.length-2)
                            i++;
                        break;
                    }
                    else if(nums[i]+nums[j]+nums[k]>0){

                        break;
                    }
                }
            }
            i++;
        }
        return list;
    }
}

//第二次还是参考了第一次的方法
public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {

        Arrays.sort(nums);
        List<List<Integer>> list=new ArrayList<List<Integer>>();
        for(int i=0;i<nums.length-2;i++){
            int j=i+1;
            int k=nums.length-1;
            while(j<k){
                if(nums[i]+nums[j]+nums[k]<0){
                    j++;
                }else if(nums[i]+nums[j]+nums[k]>0){
                    k--;
                }else{
                    list.add(Arrays.asList(nums[i],nums[j],nums[k]));
                    while(j<k&&nums[k]==nums[k-1])
                        k--;
                    while(j<k&&(nums[j]==nums[j+1]))
                        j++;

                    j++;
                    k--;
                    while((i<nums.length-2)&&(nums[i]==nums[i+1]))
                        i++;

                }
            }
        }
        return list;
    }
}