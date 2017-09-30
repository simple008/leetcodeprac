/*Created by ${USER} on ${DATE}.
 *题意：
 *注意：
 *思路：map easy提
 *一刷：
 *二刷：
 *复杂度分析：
 *反思：
 */

Given an array of integers and an integer k,
        find out whether there are two distinct indices i and j in the array such that nums[i] = nums[j]
        and the absolute difference between i and j is at most k.



//第一次
public class Solution {
    //
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer,Integer> map=new HashMap<>();
        for (int i=0;i<nums.length;i++){
            if(!map.containsKey(nums[i]))
            {map.put(nums[i],i);}
            else if(i-map.get(nums[i])<=k)
            {return true;}
            else map.put(nums[i],i);
        }
        return false;
    }
}
//第二次
public class Solution{
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet<Integer>();
        for(int i = 0; i < nums.length; i++){
            if(i > k) set.remove(nums[i-k-1]);
            if(!set.add(nums[i])) return true;
        }
        return false;
    }
}

