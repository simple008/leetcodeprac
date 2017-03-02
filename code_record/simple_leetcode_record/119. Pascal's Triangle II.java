/*Created by ${USER} on ${DATE}.
 *题意：
 *注意：
 *思路：
 *一刷：列表从后往前生成，
 *二刷：
 *复杂度分析：
 *反思：
 */
//第一次
public class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList<Integer>();
        for(int i = 0;i<rowIndex+1;i++) {
            res.add(1);
            for(int j=i-1;j>0;j--) {
                res.set(j, res.get(j-1)+res.get(j));
            }
        }
        return res;
    }
}


//第二次
public class Solution {
    public List<Integer> getRow(int numRows) {
        List<List<Integer>> list=new ArrayList<List<Integer>>();
        list.add(Arrays.asList(1));
        for(int i=1;i<=numRows;i++){
            List<Integer> li=new ArrayList<Integer>();
            for(int j=0;j<=i;j++){
                if(j==0||j==i) li.add(1);
                else
                    li.add(list.get(i-1).get(j-1)+list.get(i-1).get(j));
            }
            list.add(li);
        }
        return list.get(numRows);
    }
}