/*Created by ${USER} on ${DATE}.
 *题意：简单题
 *注意：
 *思路：
 *一刷：
 *二刷：
 *复杂度分析：
 *反思：
 */
//第一次
public class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> list=new ArrayList<String>();
        int j=0;int i=0;
        while(i<nums.length){
            if(i<nums.length-1 &&(nums[i]==nums[i+1]-1))
                i++;
            else{
                if(j<i){
                    list.add(nums[j]+"->"+nums[i]);
                    i++;
                    j=i;}
                else {
                    list.add(String.valueOf(nums[i]));
                    i++;
                    j=i;
                }
            }
        }
        return list;
    }
}