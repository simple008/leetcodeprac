/*Created by ${USER} on ${DATE}.
 *题意：加油站问题，能否转圈
 *注意：
 *思路：现在的油能到下一站。如果到不了把现在置为起始位置的前一个。记录一个总的和判断是否可以到达
 *一刷：
 *二刷：
 *复杂度分析：
 *反思：
 */
//第一次
public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {

        int i=0;
        int left=0;
        int beg=0;
        int total=0;
        while(i<gas.length){
            left+=gas[i]-cost[i];
            total+=gas[i]-cost[i];//total为了验证整个数组是否gas>cost
            if(left<0){
                beg=i+1;
                left=0;
            }
            i++;
        }
        if(total>=0) return beg;
        else return -1;
    }
}

// 第二次
public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int start = -1;
        int sum = 0;
        int count = 0;
        int total = 0;
        for(int i = 0; i < gas.length; i++){
            total += gas[i]-cost[i];
            if(sum + gas[i] < count + cost[i]){
                start = i;
                sum = 0;
                count = 0;
            }else{
                sum += gas[i];
                count += cost[i];
            }

        }

        if(total < 0) return -1;
        else return ++start;

    }
}