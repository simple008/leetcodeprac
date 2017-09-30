/*Created by ${USER} on ${DATE}.
 *题意：数组中有数字出现三分之一 求这个数
 *注意：
 *思路：两个变量 a b   time1  time2  如果跟a b都不相等 那么time1 time2 都减1   最后统计一下 a b 出现的次数 判断一下 ab是不是相等如【0，0，0】
 *一刷：
 *二刷：
 *复杂度分析：
 *反思：
 */
//第一次
public class Solution {
    public List<Integer> majorityElement(int[] nums) {

        List<Integer> list=new ArrayList<Integer>();
        if(nums==null||nums.length==0) return list;
        int len=nums.length;
        int a=0;
        int b=0;
        int cnt1=0;
        int cnt2=0;
        for(int n:nums){
            if(n==a){
                cnt1++;

            }
            else if(n==b){
                cnt2++;

            }
            else if(cnt1==0){
                cnt1++;
                a=n;
            }
            else if(cnt2==0){
                cnt2++;
                b=n;
            }
            else {
                cnt1--;
                cnt2--;
            }
        }
        cnt1=cnt2=0;
        for(int n:nums){
            if(n==a) cnt1++;
            if(n==b) cnt2++;
        }
        if(cnt1>len/3) list.add(a);
        if(a==b) return list;   //注意两个数相等的情况
        if(cnt2>len/3) list.add(b);
        return list;
    }
}
//第二次
class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> list = new ArrayList<Integer>();
        if(nums.length  == 0) return res;
        int a = 0;int time1 = 0;
        int b = 0;int time2 = 0;

        for(int n:nums){
            if (n == a){
                time1++;
            }else if(n == b){
                time2++;
            }else if(time1 == 0){
                a = n;
                time1++;
            }else if(time2 == 0){
                b =n;
                time2++;
            }else{
                time1--;
                time2--;
            }
        }
        time1 = 0;
        time2=0;
        for(int n :nums)
            if(n == a)
                time1++;
        for(int n :nums)
            if(n == b)
                time2++;

        if(time1 >nums.length/3)
            res.add(a);
        if(a == b) return res;
        if(time2 > nums.length/3)
            res.add(b);
        return res;
    }
}