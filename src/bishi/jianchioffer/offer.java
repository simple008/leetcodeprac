package bishi.jianchioffer;

 import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class offer {
    class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }
    public static void main(String[] args) {

        maxInWindows(new int[] {2,3,4,2,6,2,5,1},3);
    }

    public int[] multiply(int[] A) {
        if(A ==null || A.length == 0 ) return A;
        int[] res = new int [A.length];
        res[0] = 1;
        for(int i =1; i < A.length; i++){
            res[i] = A[i-1] * res[i-1];
        }
        int temp = A[A.length-1];
        for(int i = res.length -2; i >= 0; i--){
            res[i] = res[i] * temp;
            temp *= A[i+1];
        }
        return res;
    }



    //二叉树镜像
    boolean isSymmetrical(TreeNode pRoot)
    {
        if(pRoot == null) return true;
        if(pRoot.left == null && pRoot.right ==null) return true;
        if(pRoot.left.val != pRoot.right.val){
            return false;
        }
        return isSymmetrical(pRoot.left, pRoot.right);
    }
    boolean isSymmetrical(TreeNode node1, TreeNode node2){
        if(node1 ==null && node2 == null) return true;
        if(node1 == null || node2 == null) return false;
        if(node1.val == node2.val)
            return isSymmetrical(node1.left,node2.right) && isSymmetrical(node1.right, node2.left);
        else
            return false;
    }





    //滑动窗口最大值
    public static ArrayList<Integer> maxInWindows(int [] num, int size)
    {
        ArrayList<Integer> res = new ArrayList<Integer>();
        Deque<Integer> queue = new LinkedList<Integer>();

        for(int i = 0; i < size; i++){
            while( !queue.isEmpty() && num[queue.getLast()] <= num[i])
                queue.removeLast();

            queue.addLast(i);
        }

        for(int i = size; i < num.length; i++){
            res.add(num[queue.getFirst()]);

            while(!queue.isEmpty() && num[i] >= num[queue.getLast()]){
                queue.removeLast();
            }
            if(!queue.isEmpty()&&queue.getFirst() <= i -size)
                queue.removeFirst();

            queue.addLast(i);
        }
        res.add(queue.getFirst());
        return res;
    }
}


