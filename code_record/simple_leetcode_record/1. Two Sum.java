/*Created by ${USER} on ${DATE}.
 *题意：给定一个数组，找到两个数组中的值其和等于给定的一个值。
 *注意：1.数组无序，2.数组内的值可能重复  3.小心同一个值用了两次 比如3,2,4 不能是3 3 这个情况
 *思路：先用一个hash把所有的值都存下来O(n),再遍历一遍数组target-nums[i]是否存在hash中，即使一个数字重复两次hash中会存最后出现的
 * 位置，遍历时先遇到靠前的数字 是可以求解的  如3,3,1  6 注意 3,2，4, 这种情况要排除两个三
 *一刷：
 *二刷：
 *复杂度分析：he
 *反思：O(N)复杂度要考虑 借助其他的数据结构，如果采用类似 将数组排序后两个指针前后移动找到结果的方法显然不太合适，不能确定
 *
 *
 */

public class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map=new HashMap<>();
        for (int i=0;i<nums.length;i++)
        {
            map.put(nums[i],i);
        }
        for(int i=0;i<nums.length;i++)
        {
            int com=target-nums[i];
            if(map.containsKey(com)&&map.get(com)!=i)
            {return new int []{i,map.get(com)};

            }
        }

        throw new IllegalArgumentException("No two sum solution");
    }
}

/*

 */

public class Solution {
    public int[] twoSum(int[] nums, int target) {
        if(nums==null||nums.length<2) return new int[]{};
        HashMap<Integer,Integer> map=new HashMap<>();
        int start=0,end=0;
        for (int i = 0; i < nums.length; i++){
            map.put(nums[i],i);
        }
        for (start = 0; start<nums.length; start++){
            if(map.containsKey(target-nums[start])&&start!=map.get(target-nums[start])){
                end=map.get(target-nums[start]);
                break;
            }
        }
        return new int[]{start,end};
    }
}