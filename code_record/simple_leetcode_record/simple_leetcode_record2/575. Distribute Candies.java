575. Distribute Candies
分糖果 easy

572. Subtree of Another Tree
判断一个树  是不是另一颗数的子树（或者本身）
        if (s == null) return false;
        if (isSame(s, t)) return true;
        return isSubtree(s.left, t) || isSubtree(s.right, t);
        }

private boolean isSame(TreeNode s, TreeNode t) {
        if (s == null && t == null) return true;
        if (s == null || t == null) return false;

        if (s.val != t.val) return false;

        return isSame(s.left, t.left) && isSame(s.right, t.right);



567. Permutation in String
判断第一个字符串的 的某一种组合会不会出现在字符串2中
找出后面字符串的某一段中各个字符的个数是不是跟第一个串相同
可以没来一次判断一次 暴力
2. 滑动窗口
public boolean checkInclusion(String s1, String s2) {
    int[] count = new int[128];
    for(int i = 0; i < s1.length(); i++)
        count[s1.charAt(i)]--;
    for(int l = 0, r = 0; r < s2.length(); r++) {
        if (++count[s2.charAt(r)] > 0)
            while(--count[s2.charAt(l++)] != 0) { /* do nothing */}
        else if ((r - l + 1) == s1.length()) return true;
        }
    return s1.length() == 0;
    }



public class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length()>s2.length()) return false;
        int[] alphabets = new int[26];
        int len =s1.length();
        for(char ch : s1.toCharArray()){
            alphabets[ch-'a']++;
        }
        int cnt =len;
        char[] sArr = s2.toCharArray();

        int start =0;
        int end =0;
        while(end<sArr.length){
            if(alphabets[sArr[end++]-'a']-->0) cnt--;
            while(cnt==0){
                // System.out.println(end+","+start);
                if(end-start == len) return true;
                if(alphabets[sArr[start++]-'a']++==0) cnt++;
            }

        }

        return false;

    }

}

564. Find the Closest Palindrome

563. Binary Tree Tilt
public class Solution {
    int result = 0;

    public int findTilt(TreeNode root) {
        postOrder(root);
        return result;
    }

    private int postOrder(TreeNode root) {
        if (root == null) return 0;

        int left = postOrder(root.left);
        int right = postOrder(root.right);

        result += Math.abs(left - right);

        return left + right + root.val;
    }
}

561. Array Partition I
 2n个数分成n组 每组两个数 让每个组的最小值的和 最大
no sense

560. Subarray Sum Equals K
有多少个子数组的和为k   hashmap 注意多种组合的方式

557. Reverse Words in a String III

556. Next Greater Element III
找一个逆序对就行了

554. Brick Wall
找缝最多的一个位置

553. Optimal Division
加括号 让相除的结果最大
除法变乘法

        551. Student Attendance Record I
遍历 记录
或者 indexOf lastindexOf  contains LLL
        552. Student Attendance Record II
给定天数  统计获奖的情况有多少种组合
三维dp
public int checkRecord(int n) {
final int MOD = 1000000007;
        int[][][] f = new int[n + 1][2][3];

        f[0] = new int[][]{{1, 1, 1}, {1, 1, 1}};
        for (int i = 1; i <= n; i++)
        for (int j = 0; j < 2; j++)
        for (int k = 0; k < 3; k++) {
        int val = f[i - 1][j][2]; // ...P  f[i][j][k] += f[i-1][j][2] + if(j>0) xxx if(k>0)...
        if (j > 0) val = (val + f[i - 1][j - 1][2]) % MOD; // ...A
        if (k > 0) val = (val + f[i - 1][j][k - 1]) % MOD; // ...L
        f[i][j][k] = val;
        }
        return f[n][1][2];
        }

547. Friend Circles
矩阵找朋友圈   用一维数组来搜就可以
public class Solution {
    public void dfs(int[][] M, int[] visited, int i) {
        for (int j = 0; j < M.length; j++) {
            if (M[i][j] == 1 && visited[j] == 0) {
                visited[j] = 1;
                dfs(M, visited, j);
            }
        }
    }
    public int findCircleNum(int[][] M) {
        int[] visited = new int[M.length];
        int count = 0;
        for (int i = 0; i < M.length; i++) {
            if (visited[i] == 0) {
                dfs(M, visited, i);
                count++;
            }
        }
        return count;
    }
}

546. Remove Boxes
        http://blog.csdn.net/lizhb5/article/details/70161489
三维dp

543. Diameter of Binary Tree
求不一定经过root节点的最长二叉树路径
遍历，每次就一个depth


542. 01 Matrix
01矩阵中计算距离每个节点最近的0 的距离 每个单位算作1距离
BFS  把0的节点都放到队列里，然后依次出队  去遍历 周围的四个元素，如果没访问过就+1 并且 放入队尾

        541. Reverse String II
反转字符串中每2k个字符的前k个
封装一个函数
public class Solution {
    public String reverseStr(String s, int k) {
        char[] arr = s.toCharArray();
        int n = arr.length;
        int i = 0;
        while(i < n) {
            int j = Math.min(i + k - 1, n - 1);
            swap(arr, i, j);
            i += 2 * k;
        }
        return String.valueOf(arr);
    }
    private void swap(char[] arr, int l, int r) {
        while (l < r) {
            char temp = arr[l];
            arr[l++] = arr[r];
            arr[r--] = temp;
        }
    }
}


540. Single Element in a Sorted Array
log(n) 时间

public class Solution {
    public int singleNonDuplicate(int[] nums) {
        // binary search
        int n=nums.length, lo=0, hi=n/2;
        while (lo < hi) {
            int m = (lo + hi) / 2;
            if (nums[2*m]!=nums[2*m+1]) hi = m;
            else lo = m+1;
        }
        return nums[2*lo];
    }
}

539. Minimum Time Difference
HH:MM 找两个时间之间的最小时差
24*60 转换成数组 排序 检查

538. Convert BST to Greater Tree

先遍历一遍 计算总和  然后  从最左边开始遍历  不断加上剩余的值
或者右根左 遍历 一边遍历一边计算和 然后加起来

537. Complex Number Multiplication
复数的计算
两个复数
解析 拆分就行了


535. Encode and Decode TinyURL
有方法可以搞

534. Design TinyURL
设计tinyUrl的生成
        1.hash function:
        把long_url用md5/sha1哈希
        md5把一个string转化成128位二进制数，一般用32位十六进制数(16byte)表示：
        http://site.douban.com/chuan -> c93a360dc7f3eb093ab6e304db516653
        sha1把一个string转化成160位二进制数，一般用40位十六进制数(20byte)表示：
        http://site.douban.com/chuan -> dff85871a72c73c3eae09e39ffe97aea63047094
        这两个算法可以保证哈希值分布很随机，但是冲突是不可避免的，任何一个哈希算法都不可避免有冲突。
        优点：简单，可以根据long_url直接生成；假设一个url中一个char占两个字节，平均长度为30的话，原url占大小60byte,hash之后要16byte。我们可以取md5的前6位,这样就更节省。
        缺点：难以保证哈希算法没有冲突
        解决冲突方案：1.拿(long_url + timestamp)来哈希；2.冲突的话，重试(timestamp会变，会生成新的hash)
        综上，流量不多时，可行；但是，当url超过了假设1 billion的时候，冲突会非常多，效率非常低。

        2.base62:
        将六位的short_url看做是一个62进制数(0-9,a-z,A-Z)，可以表示62^6=570亿个数。整个互联网的网页数在trillion级别，即一万亿这个级别。6位足够。
        每个short_url对应一个十进制整数，这个整数就可以是sql数据库中的自增id，即auto_increment_id。

注意 base62  base64 位编码


532. K-diff Pairs in an Array
hashMap  map.entrySet
        for (Map.Entry<Integer, Integer> entry : map.entrySet())
entry.getKey

        530. Minimum Absolute Difference in BST
BST的最小差值   记一个prev
public class Solution {
    int min = Integer.MAX_VALUE;
    Integer prev = null;

    public int getMinimumDifference(TreeNode root) {
        if (root == null) return min;

        getMinimumDifference(root.left);

        if (prev != null) {
            min = Math.min(min, root.val - prev);
        }
        prev = root.val;

        getMinimumDifference(root.right);

        return min;
    }

}

529. Minesweeper
扫雷  点一个位置之后 显示扫雷图

 526. Beautiful Arrangement
第i个位置上的数 能被i 整除
或者i能被第i个位置上的数整除
回溯 遍历
public class Solution {
    int count = 0;

    public int countArrangement(int N) {
        if (N == 0) return 0;
        helper(N, 1, new int[N + 1]);
        return count;
    }

    private void helper(int N, int pos, int[] used) {
        if (pos > N) {
            count++;
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (used[i] == 0 && (i % pos == 0 || pos % i == 0)) {
                used[i] = 1;
                helper(N, pos + 1, used);
                used[i] = 0;
            }
        }
    }
}



525. Contiguous Array
01数组，找最长的一个子数组 01个数相同













