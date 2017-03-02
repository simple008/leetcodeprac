/*Created by ${USER} on ${DATE}.
 *题意：生成杨辉三角
 *注意：
 *思路：
 *一刷：
 *二刷：两个列表嵌套循环
 *复杂度分析：
 *反思：
 */
//第一次
public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> row, pre = null;
        for (int i = 0; i < numRows; ++i) {
            row = new ArrayList<Integer>();
            for (int j = 0; j <= i; ++j)
                if (j == 0 || j == i)
                    row.add(1);
                else
                    row.add(pre.get(j - 1) + pre.get(j));
            pre = row;
            res.add(row);
        }
        return res;
    }
}

//第二次
public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list=new ArrayList<List<Integer>>();
        if(numRows==0) return list;
        list.add(Arrays.asList(1));
        for(int i=1;i<numRows;i++){
            List<Integer> li=new ArrayList<Integer>();
            for(int j=0;j<=i;j++){
                if(j==0||j==i) li.add(1);
                else
                    li.add(list.get(i-1).get(j-1)+list.get(i-1).get(j));
            }
            list.add(li);
        }
        return list;
    }
}