/*Created by ${USER} on ${DATE}.
 *题意：找出所有从根节点到叶子节点的和等于给定值的路径
 *注意：
 *思路：
 *一刷：
 *二刷：
 *复杂度分析：
 *反思：为什么这个地方需要remove  而path sum I 不需要remove
 *      li 是引用变量 下层上层用的是同一个li  所以需要手动删除 把下一层加进来的 元素删掉
 *      第一次在递归调用的时候new 了一个新的list
 *      而整数 不需要值传递  当前的值还是上几行的那个值
 */
//第一次
public class Solution {
    List<List<Integer>> res=new ArrayList<List<Integer>>();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        preorder(root,sum,new ArrayList<Integer>());
        return res;
    }
    public void preorder(TreeNode root,int sum,List<Integer> temp){
        if(root==null) return ;
        temp.add(root.val);
        sum-=root.val;
        if(root.left==null&&root.right==null){
            if(sum==0)
                res.add(new ArrayList<Integer>(temp));
            return ;
        }
        preorder(root.left,sum,new ArrayList<Integer>(temp));
        preorder(root.right,sum,new ArrayList<Integer>(temp));
    }
}


//第二次
public class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> list=new ArrayList<List<Integer>>();
        getSum(root,sum,0,list,new ArrayList<Integer>());
        return list;
    }
    public void  getSum(TreeNode root,int sum,int cnt,List<List<Integer>> list,List<Integer> li){
        if(root==null) return ;
        cnt+=root.val;
        li.add(root.val);
        if(root.left==null&&root.right==null&&cnt==sum)
            list.add(new ArrayList<Integer>(li));

        getSum(root.left,sum,cnt,list,li);
        getSum(root.right,sum,cnt,list,li);
        li.remove(li.size()-1);                   //如果这个元素加入后符合要求了，那么这个值也没用了
    }
}