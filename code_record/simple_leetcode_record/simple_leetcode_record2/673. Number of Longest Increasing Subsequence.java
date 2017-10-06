最长递增字符串的个数，用原来求最长字符串长度的方法来做。 记录一下是不是最后的位置有变化就行 有就变1  没有就+1


674. Longest Continuous Increasing Subsequence
最长的连续的递增串
class Solution {
    public int findLengthOfLCIS(int[] nums) {
        if(nums == null || nums.length ==0) return 0;
        int max = 1;
        int len = 1;
        for(int i = 1; i<nums.length; i++){
            if(nums[i] > nums[i-1])
                len ++;
            else{
                max = Math.max(max, len);
                len =1;
            }
        }
        return Math.max(max,len);
    }
}
676. Implement Magic Dictionary
找是否只有一个字符不同的字符串  map存的时候 key是去掉这个字符的前后两个字符串拼成的string key 是index，char
677. Map Sum Pairs
插入时可以覆盖<String,int> 查询时的返回所有有某个字符串前缀的key val对的 val的和
两个map  一个存在整个的字符串  另一个在遍历的时候每个(0,i)子串都存一下 取和作value
678. Valid Parenthesis String
判断一个括号字符处是否有效。 （ ） * 可以匹配成左右括号或者空。  记录*的次数 当出现 右括号多余左括号时放入
最后结束时 看左括号剩余的个数跟*是否匹配


//递归
class Solution {
    public boolean checkValidString(String s) {
        return check(s, 0, 0);
    }

    private boolean check(String s, int start, int count) {
        if (count < 0) return false;

        for (int i = start; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                count++;
            }
            else if (c == ')') {
                if (count <= 0) return false;
                count--;
            }
            else if (c == '*') {
                return check(s, i + 1, count + 1) || check(s, i + 1, count - 1) || check(s, i + 1, count);
            }
        }

        return count == 0;
    }
}
679. 24 Game
24 点游戏  = - * /
class Solution {
    public boolean judgePoint24(int[] nums) {
        return f(new double[] {nums[0], nums[1], nums[2], nums[3]});
    }

    private boolean f(double[] a) {
        if (a.length == 1) {
            return a[0] == 24;
        }
        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                double[] b = new double[a.length - 1];
                for (int k = 0, l = 0; k < a.length; k++) {
                    if (k != i && k != j) {
                        b[l++] = a[k];
                    }
                }
                for (double k : compute(a[i], a[j])) {
                    b[a.length - 2] = k;
                    if (f(b)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private double[] compute(double a, double b) {
        return new double[] {a + b, a - b, b - a, a * b, a / b, b / a};
    }
}







659. Split Array into Consecutive Subsequences
把数字分解成连续的字符串
public class Solution {
    public boolean isPossible(int[] nums) {
        Map<Integer, Integer> unused_freq = new HashMap<Integer, Integer>(), need_freq = new HashMap<Integer, Integer>();
        for(int i : nums)	unused_freq.put(i, unused_freq.containsKey(i)?1+unused_freq.get(i):1);

        for(int i : nums) {
            if(unused_freq.get(i) == 0)	continue; 	// 这个数用完了

            if(need_freq.containsKey(i) && need_freq.get(i)>0) {
                // 加到已经有的队列
                need_freq.put(i, need_freq.get(i)-1);
                need_freq.put(i+1, need_freq.containsKey(i+1)?need_freq.get(i+1)+1:1);
                unused_freq.put(i, unused_freq.get(i)-1);
            } else if(unused_freq.containsKey(i+1) && unused_freq.get(i+1)>0
                    && unused_freq.containsKey(i+2) && unused_freq.get(i+2)>0) {
                // 加到新的队列
                need_freq.put(i+3, need_freq.containsKey(i+3)?1+need_freq.get(i+3):1);
                unused_freq.put(i, unused_freq.get(i)-1);
                unused_freq.put(i+1, unused_freq.get(i+1)-1);
                unused_freq.put(i+2, unused_freq.get(i+2)-1);
            } else {
                // 这个数无处容身
                return false;
            }
        }

        return true;
    }
}

658. Find K Closest Elements
在已经排序的数组中找到距离x最近的k个数  并且也是升序

657. Judge Route Circle
public boolean judgeCircle(String moves) {
        moves=" " + moves + " ";
        return moves.split("L").length==moves.split("R").length && moves.split("U").length == moves.split("D").length;
        }


654. Maximum Binary Tree
递归 一直找最大的数字

653. Two Sum IV - Input is a BST
在二叉搜索树中有没有两个数和为给定值
set  深搜

652. Find Duplicate Subtrees
找出所有相同的 子树，单个最后单个节点相同也是    比如 n个相同的叶子节点

用map存中序遍历 的每个子序列，

650. 2 Keys Keyboard
复制 粘贴 最小的步数得到 目标字符串 求最少的步数
能粘贴的就是
public int minSteps(int n) {
    int[] dp = new int[n+1];

        for (int i = 2; i <= n; i++) {
            dp[i] = i;
            for (int j = i-1; j > 1; j--) {
                if (i % j == 0) {
                    dp[i] = dp[j] + (i/j);
                    break;
                }
            }
        }
    return dp[n];
    }

649. Dota2 Senate

648. Replace Words
词根替换  trie树  把所有的词根建树，然后查找

647. Palindromic Substrings
计算回文串的个数 起止位置不同就算一个 一个字符也算
遍历字符串每次遍历时目标位置是回文串中心，区分奇偶长度  i,i  i,i+1

645. Set Mismatch
2遍历

643. Maximum Average Subarray I
640. Solve the Equation
解一个含有x的等式，x 需要等于多少

= 切分两侧，分别计算  一个变量存x的系数，另一个存正常的数字
public String solveEquation(String equation) {
        int[] res = evaluateExpression(equation.split("=")[0]),
        res2 = evaluateExpression(equation.split("=")[1]);
        res[0] -= res2[0];
        res[1] = res2[1] - res[1];
        if (res[0] == 0 && res[1] == 0) return "Infinite solutions";
        if (res[0] == 0) return "No solution";
        return "x=" + res[1]/res[0];
        }

public int[] evaluateExpression(String exp) {
        String[] tokens = exp.split("(?=[-+])");
        int[] res =  new int[2];
        for (String token : tokens) {
        if (token.equals("+x") || token.equals("x")) res[0] += 1;
        else if (token.equals("-x")) res[0] -= 1;
        else if (token.contains("x")) res[0] += Integer.parseInt(token.substring(0, token.indexOf("x")));
        else res[1] += Integer.parseInt(token);
        }
        return res;
        }


639. Decode Ways II

638. Shopping Offers
递归遍历， 每一种方案 如果可行 使用 然后继续循环。递归回溯 不行就回来
public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        HashMap<List<Integer>, Integer> map=new HashMap<List<Integer>, Integer>();
        return helper(price, special, needs, needs.size(), map);
        }

public int helper(List<Integer> price, List<List<Integer>> special,
        List<Integer> needs,int n,HashMap<List<Integer>, Integer> map){

            if(map.get(needs)!=null){
                return map.get(needs);
            }
            int minPrice=0;
            //下面是完全不用套餐的情况
            for(int i=0;i<n;i++){
                minPrice+=(needs.get(i)*price.get(i));
            }
            //下面是用套餐的情况
            for(List<Integer> taocan:special){
                boolean canUseThisTaocan=true;
                int thisPrice=0;
                for(int i=0;i<n;i++){
                    if(needs.get(i)<taocan.get(i)){//套餐里的内容超过我需要的数目了
                        canUseThisTaocan=false;
                        break;
                    }
            }

            if(canUseThisTaocan){
                List<Integer> needClone=new ArrayList<>(needs);
                for(int i=0;i<n;i++){
                     needClone.set(i, needClone.get(i)-taocan.get(i));
                }
                thisPrice=taocan.get(n)+helper(price, special, needClone, n, map);
                if(thisPrice<minPrice){
                    minPrice=thisPrice;
                    }
            }
            }
            map.put(needs, minPrice);
            return minPrice;
        }

637. Average of Levels in Binary Tree
每层节点的平均值     层次遍历 求均值


636. Exclusive Time of Functions
记录多个线程在单核cpu中交替运行的执行时间（不同线程有交叉）

633. Sum of Square Numbers
判断一个数能不能拆解成平方数的和
循环，暴力判断。left 0  right sqrt(n)

632. Smallest Range
求一个最小的范围 保证n的集合中都有数字落在这个范围内。
        优先队列 时刻保证 队列里有n个数（每个集合中都有一个数在里面） 范围就是最大值-最小值



629. K Inverse Pairs Array
1-n 的数字组合中 有k个逆序对的有多少个 数组
public static int kInversePairs(int n, int k) {
        int mod = 1000000007;
        if (k > n*(n-1)/2 || k < 0) return 0;
        if (k == 0 || k == n*(n-1)/2) return 1;
        long[][] dp = new long[n+1][k+1];
            dp[2][0] = 1;
            dp[2][1] = 1;
        for (int i = 3; i <= n; i++) {
            dp[i][0] = 1;
            for (int j = 1; j <= Math.min(k, i*(i-1)/2); j++) {
                dp[i][j] = dp[i][j-1] + dp[i-1][j];
                if (j >= i) dp[i][j] -= dp[i-1][j-i];
                    dp[i][j] = (dp[i][j]+mod) % mod;
        }
        }
        return (int) dp[n][k];
        }

628. Maximum Product of Three Numbers
给一个数组找到乘积最大的 三个数的乘积
有正负数
三个最大的整数 两个最小的负数 和一个最大的正数

623. Add One Row to Tree
在二叉树的某一层 加一行   层次遍历，控制行高

public class Solution {
    public TreeNode addOneRow(TreeNode root, int v, int d) {
        if (d == 0 || d == 1) {
            TreeNode newroot = new TreeNode(v);
            newroot.left = d == 1 ? root : null;
            newroot.right = d == 0 ? root : null;
            return newroot;
        }
        if (root != null && d >= 2) {
            root.left  = addOneRow(root.left,  v, d > 2 ? d - 1 : 1);
            root.right = addOneRow(root.right, v, d > 2 ? d - 1 : 0);
        }
        return root;
    }
}
或者 dfs 记depth 到这一层然后操作。 递归没问题，每个depth的节点都会遍历到


621. Task Scheduler
        Examples:
        AAAABBBEEFFGG 3
        here X represents a space gap:
        Frame: "AXXXAXXXAXXXA"
        insert 'B': "ABXXABXXABXXA" <--- 'B' has higher frequency than the other characters, insert it first.
        insert 'E': "ABEXABEXABXXA"
        insert 'F': "ABEFABEXABFXA" <--- each time try to fill the k-1 gaps as full or evenly as possible.
        insert 'G': "ABEFABEGABFGA"

public class Solution {
    public int leastInterval(char[] tasks, int n) {

        int[] c = new int[26];
        for(char t : tasks){
            c[t - 'A']++;
        }
        Arrays.sort(c);
        int i = 25;
        while(i >= 0 && c[i] == c[25]) i--;

        return Math.max(tasks.length, (c[25] - 1) * (n + 1) + 25 - i);
    }
}

617. Merge Two Binary Trees
merge 两棵二叉树，空的是空  非空 加和作为节点值
public class Solution {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) return null;

        int val = (t1 == null ? 0 : t1.val) + (t2 == null ? 0 : t2.val);
        TreeNode newNode = new TreeNode(val);

        newNode.left = mergeTrees(t1 == null ? null : t1.left, t2 == null ? null : t2.left);
        newNode.right = mergeTrees(t1 == null ? null : t1.right, t2 == null ? null : t2.right);

        return newNode;
    }
}

611. Valid Triangle Number
给定一个数组 判断有多少个合格的三角形组合方式

609. Find Duplicate File in System
找重复的文件   hash

606. Construct String from Binary Tree
递归  按照先序遍历的顺序  加括号
class Solution {
    public String tree2str(TreeNode t) {
        if(t == null) return "";
        StringBuilder res = new StringBuilder();
        preorder(t,res);
        return res.toString();
    }
    public void preorder(TreeNode t, StringBuilder sb){
        if(t!=null){
            sb.append(t.val);
            if(t.left !=null || t.right != null){
                sb.append('(');
                preorder(t.left, sb);
                sb.append(')');
                if(t.right != null){
                    sb.append('(');
                    preorder(t.right, sb);
                    sb.append(')');
                }
            }
        }
    }
}

605. Can Place Flowers
找有没有足够多的0  没有1 相邻 一维数组

可以计算每段 有多少个连续的0

600. Non-negative Integers without Consecutive Ones
计算在不大于给定数的非负整数的二进制表达中 有几个数字没有连续的1
public class Solution {
    public int findIntegers(int  ) {
        StringBuilder sb = new StringBuilder(Integer.toBinaryString(num)).reverse();
        int n = sb.length();

        int a[] = new int[n];
        int b[] = new int[n];
        a[0] = b[] = 1;
        for (int i = 1; i < n; i++) {
            a[i] = a[i - 1] + b[i - 1];
            b[i] = a[i - 1];
        }

        int result = a[n - 1] + b[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            if (sb.charAt(i) == '1' && sb.charAt(i + 1) == '1') break;
            if (sb.charAt(i) == '0' && sb.charAt(i + 1) == '0') result -= b[i];
        }

        return result;
    }
}
Let a[i] be the number of binary strings of length i which do not contain any two consecutive 1’s
        and which end in 0. Similarly, let b[i] be the number of such strings which end in 1.
        We can append either 0 or 1 to a string ending in 0,
        but we can only append 0 to a string ending in 1. This yields the recurrence relation:

        a[i] = a[i - 1] + b[i - 1]
        b[i] = a[i - 1]


599. Minimum Index Sum of Two Lists
easy

598. Range Addition II
给定几个范围求范围内重复次数最多的位置有几个 覆盖范围都从00 开始画一个矩形
求最小的覆盖矩形的长宽就可以了。

594. Longest Harmonious Subsequence
找出一个最大最小值只差一的最长子序列  把每个数字的频率都搞出来 遍历

593. Valid Square
给定4个点的坐标判断这四个点能否构成一个正方形
1. 排序。计算长度。
2. 计算各个点之间的距离，判断是不是只有两个距离长度存在，并且没有0

592. Fraction Addition and Subtraction
分数字符串表达式 计算表达式的结果  以分数的形式表达

        591. Tag Validator


587. Erect the Fence
划线 把所有的树都围起来





583. Delete Operation for Two Strings
删除多少次 让两个字符串相同
class Solution {
    public int minDistance(String word1, String word2) {
        if(word1 == null || word2 ==null) return word1 == null? word2.length():word1.length();
        int len1 = word1.length();
        int len2 = word2.length();

        int[][] dp = new int [len1+1][len2+1];
        for(int i = 0; i < len1+1; i++){
            dp[i][0] = i;
        }
        for(int i = 0; i < len2+1; i++){
            dp[0][i] = i;
        }

        for(int i = 1; i < len1+1; i++){
            for(int j = 1; j < len2+1; j++){
                if(word1.charAt(i-1) == word2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }else{
                    dp[i][j] = Math.min(dp[i][j-1], dp[i-1][j]) +1;
                }
            }
        }
        return dp[len1][len2];
    }
}


581. Shortest Unsorted Continuous Subarray
在数组中调整一个子数组 使整个数组都有序
两个指针  一左一右  如果l和max 指针发生交换说明 在l前面 有比l这个数小的数   r和min同理，这种情况是不合规的
找到这个最小的范围

public int findUnsortedSubarray(int[] nums) {
        int i = 0, j = -1, max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;

        for (int l = 0, r = nums.length - 1; r >= 0; l++, r--) {
        max = Math.max(max, nums[l]);
        if (nums[l] != max) j = l;

        min = Math.min(min, nums[r]);
        if (nums[r] != min) i = r;
        }

        return (j - i + 1);
        }


 576. Out of Boundary Paths
给定 一个球  和一个次数 计算有多少种在给定次数内移出矩阵的方法
没懂
public class Solution {
    public int findPaths(int m, int n, int N, int i, int j) {
        if (N <= 0) return 0;

        final int MOD = 1000000007;
        int[][] count = new int[m][n];
        count[i][j] = 1;
        int result = 0;

        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        for (int step = 0; step < N; step++) {
            int[][] temp = new int[m][n];
            for (int r = 0; r < m; r++) {
                for (int c = 0; c < n; c++) {
                    for (int[] d : dirs) {

                        int nr = r + d[0];
                        int nc = c + d[1];

                        if (nr < 0 || nr >= m || nc < 0 || nc >= n) {
                            result = (result + count[r][c]) % MOD;
                        }
                        else {
                            temp[nr][nc] = (temp[nr][nc] + count[r][c]) % MOD;
                        }

                    }
                }
            }
            count = temp;
        }

        return result;
    }
}

