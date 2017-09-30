/*Created by ${USER} on ${DATE}.
 *题意：判断是否存在 i j ，使num[i] num[j]之间差距在t  i j 在k之内
 *注意：
 *思路：
 *一刷：
 *二刷：
 *复杂度分析：
 *反思：
 */
Given an array of integers, find out whether there are two distinct indices i and j in the
        array such that the absolute difference between nums[i] and nums[j] is at most t
        and the absolute difference between i and j is at most k.
//第一次
public class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        int n = nums.length;
        int[] indexs = new int[n];
        for(int i = 0; i < n; i++){
            indexs[i] = i;
        }
        quicksort(nums, indexs, 0, n - 1);

        for(int i = 0; i < n; i++){
            int start = nums[i];
            int sindex = indexs[i];
            for(int j = i + 1; j < n; j++){
                int end = nums[j];
                int eindex = indexs[j];
                long diff = (long)end - (long)start;
                if(diff > t){
                    break;
                }
                if(Math.abs(eindex - sindex) <= k){
                    return true;
                }
            }
        }

        return false;
    }

    private void quicksort(int[] nums, int[] indexs, int start, int end){
        if(start >= end){
            return;
        }
        int mid = start + (end - start)/2;
        int pivot = nums[mid];
        int i = start;
        int j = end;
        while(i <= j){
            while(nums[i] < pivot){
                i++;
            }
            while(nums[j] > pivot){
                j--;
            }
            if(i <= j){
                if(nums[i] != nums[j]){
                    swap(nums, indexs, i, j);
                }
                i++;
                j--;
            }
        }
        quicksort(nums, indexs, start, i - 1);
        quicksort(nums, indexs, i, end);
    }

    private void swap(int[] nums, int[] indexs, int i, int j){
        int value = nums[i];
        nums[i] = nums[j];
        nums[j] = value;
        int index = indexs[i];
        indexs[i] = indexs[j];
        indexs[j] = index;
    }}

// 第二次
public class Solution {
    TreeNode root = null;
    boolean flag = false;

    /**
     * I think a lot time, but I still can deal with it in my way.
     * So I see this hint tags: binary search tree, so I try below method to solve.
     * <p>
     * <strong>result of test:</strong><br/>
     * 31 / 31 test cases passed
     * Status: Accepted
     * Runtime: 10 - 12ms, bit 97.65 - 97.27%
     *
     * @param nums
     * @param k
     * @param t
     * @return
     */
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {

        for (int i = 0; i < nums.length; i++) {
            if (i > k) {
                root = delete(root, nums[i - k - 1]);
            }
            root = insert(root, nums[i], t);
            if (flag) return true;
        }

        return false;
    }


    public TreeNode insert(TreeNode root, int num, int t) {
        if (root == null) {
            TreeNode curNode = new TreeNode(num);
            return curNode;
        }

        if (Math.abs((long) (root.val - num)) <= t) {
            flag = true;
            return root;
        }

        if (root.val < num) {
            root.right = insert(root.right, num, t);
        } else if (root.val > num) {
            root.left = insert(root.left, num, t);
        }

        return root;
    }

    public TreeNode delete(TreeNode root, int num) {
        if (root == null) return null;

        if (root.val < num) {
            root.right = delete(root.right, num);
        } else if (root.val > num) {
            root.left = delete(root.left, num);
        } else {
            if (root.left == null || root.right == null) {
                return root.left == null ? root.right : root.left;
            } else {
                //this sense that left and right is none null
                //this is a easy method to deal with it.
                //that exchange the root val with the min or max node
                root.val = findMin(root.right).val;
                root.right = delete(root.right, root.val);
            }
        }

        return root;
    }

    public TreeNode findMin(TreeNode node) {
        if (node == null) return null;
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    class TreeNode {
        /**
         * 数节点值
         */
        public int val;
        /**
         * 左子树
         */
        public TreeNode left;
        /**
         * 右子树
         */
        public TreeNode right;

        public TreeNode(int x) {
            val = x;
        }
    }
}