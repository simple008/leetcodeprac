/*Created by ${USER} on ${DATE}.
 *题意：生成 1-n 中k个数的各种组合
 *注意： 子list在加到母list时一定要new   list.add(new ArrayList<Integer>(li))  list是引用 否则会变空
 *思路：回溯， 用子列表的长度控制结束， 结束之后弹出当前列表的最后一个元素 进行下一次递归回溯
 *一刷：
 *二刷：for 循环 从1开始遍历，直到当前列表的大小==k 加入结果集，返回结果
 *复杂度分析：
 *反思： list.remove(list.size()-1)    removeLast()  是链表的方法不是列表的
 */


//第一次
public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> combs=new ArrayList<List<Integer>>();
        combine(combs,new ArrayList<Integer>(),1,n,k);
        return combs;
    }
    public static void combine(List<List<Integer>> combs,List<Integer> comb,int start,int n,int k){
        if(k==0){
            combs.add(new ArrayList<Integer>(comb));
            return;
        }
        for(int i=start;i<=n;i++){
            comb.add(i);
            combine(combs,comb,i+1,n,k-1);
            comb.remove(comb.size()-1);
        }
    }
}
//第二次   回溯

public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> list=new ArrayList<List<Integer>>();
        if(k==0) return list;
        List<Integer> li=new ArrayList<Integer>();
        getCom(n,k,1,list,li);
        return list;
    }
    public void getCom(int n,int k,int index,List<List<Integer>> list,List<Integer> li){
        if(li.size()==k){
            list.add(new ArrayList<Integer>(li));
            return ;
        }
        for(int i=index;i<=n;i++){
            li.add(i);
            getCom(n,k,i+1,list,li);
            li.remove(li.size()-1);
        }
    }
}

public void getCom(List<List<Integer>> result, List<Integer> list, int n, int k, int index){
    if(list.size()==k){
        result.add(new ArrayList<Integer>(list));
        return ;
    }
    for(int i = index; i<=n; i++){
        list.add(i);
        getCom(result, list, n, k, i+1);
        list.remove(list.size()-1);
    }
}