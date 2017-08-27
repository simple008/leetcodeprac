/*Created by ${USER} on ${DATE}.
 *题意：格雷码 生成
 *注意：
 *思路：00 01 --11 10 --110 111 101 100
 *一刷：
 *二刷：
 *复杂度分析：
 *反思：
 */
//第一次
public class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> li=new ArrayList<Integer>();
        Stack<Integer> stack=new Stack<Integer>();

        if(n==1){
            li.add(0);
            li.add(1);
            return li;
        }
        // List<Integer> lastli=new List<Integer>();
        for(Integer nn:grayCode(n-1)){
            li.add(nn);
            stack.push(nn);
        }
        while(!stack.isEmpty()){
            li.add(1<<n-1+stack.pop());
        }


        return li;
    }
}

