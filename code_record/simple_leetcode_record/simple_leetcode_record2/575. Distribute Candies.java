575. Distribute Candies
���ǹ� easy

572. Subtree of Another Tree
�ж�һ����  �ǲ�����һ���������������߱���
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
�жϵ�һ���ַ����� ��ĳһ����ϻ᲻��������ַ���2��
�ҳ������ַ�����ĳһ���и����ַ��ĸ����ǲ��Ǹ���һ������ͬ
����û��һ���ж�һ�� ����
2. ��������
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
 2n�����ֳ�n�� ÿ�������� ��ÿ�������Сֵ�ĺ� ���
no sense

560. Subarray Sum Equals K
�ж��ٸ�������ĺ�Ϊk   hashmap ע�������ϵķ�ʽ

557. Reverse Words in a String III

556. Next Greater Element III
��һ������Ծ�����

554. Brick Wall
�ҷ�����һ��λ��

553. Optimal Division
������ ������Ľ�����
������˷�

        551. Student Attendance Record I
���� ��¼
���� indexOf lastindexOf  contains LLL
        552. Student Attendance Record II
��������  ͳ�ƻ񽱵�����ж��������
��άdp
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
����������Ȧ   ��һά�������ѾͿ���
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
��άdp

543. Diameter of Binary Tree
��һ������root�ڵ���������·��
������ÿ�ξ�һ��depth


542. 01 Matrix
01�����м������ÿ���ڵ������0 �ľ��� ÿ����λ����1����
BFS  ��0�Ľڵ㶼�ŵ������Ȼ�����γ���  ȥ���� ��Χ���ĸ�Ԫ�أ����û���ʹ���+1 ���� �����β

        541. Reverse String II
��ת�ַ�����ÿ2k���ַ���ǰk��
��װһ������
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
log(n) ʱ��

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
HH:MM ������ʱ��֮�����Сʱ��
24*60 ת�������� ���� ���

538. Convert BST to Greater Tree

�ȱ���һ�� �����ܺ�  Ȼ��  ������߿�ʼ����  ���ϼ���ʣ���ֵ
�����Ҹ��� ���� һ�߱���һ�߼���� Ȼ�������

537. Complex Number Multiplication
�����ļ���
��������
���� ��־�����


535. Encode and Decode TinyURL
�з������Ը�

534. Design TinyURL
���tinyUrl������
        1.hash function:
        ��long_url��md5/sha1��ϣ
        md5��һ��stringת����128λ����������һ����32λʮ��������(16byte)��ʾ��
        http://site.douban.com/chuan -> c93a360dc7f3eb093ab6e304db516653
        sha1��һ��stringת����160λ����������һ����40λʮ��������(20byte)��ʾ��
        http://site.douban.com/chuan -> dff85871a72c73c3eae09e39ffe97aea63047094
        �������㷨���Ա�֤��ϣֵ�ֲ�����������ǳ�ͻ�ǲ��ɱ���ģ��κ�һ����ϣ�㷨�����ɱ����г�ͻ��
        �ŵ㣺�򵥣����Ը���long_urlֱ�����ɣ�����һ��url��һ��charռ�����ֽڣ�ƽ������Ϊ30�Ļ���ԭurlռ��С60byte,hash֮��Ҫ16byte�����ǿ���ȡmd5��ǰ6λ,�����͸���ʡ��
        ȱ�㣺���Ա�֤��ϣ�㷨û�г�ͻ
        �����ͻ������1.��(long_url + timestamp)����ϣ��2.��ͻ�Ļ�������(timestamp��䣬�������µ�hash)
        ���ϣ���������ʱ�����У����ǣ���url�����˼���1 billion��ʱ�򣬳�ͻ��ǳ��࣬Ч�ʷǳ��͡�

        2.base62:
        ����λ��short_url������һ��62������(0-9,a-z,A-Z)�����Ա�ʾ62^6=570�ڸ�������������������ҳ����trillion���𣬼�һ�����������6λ�㹻��
        ÿ��short_url��Ӧһ��ʮ������������������Ϳ�����sql���ݿ��е�����id����auto_increment_id��

ע�� base62  base64 λ����


532. K-diff Pairs in an Array
hashMap  map.entrySet
        for (Map.Entry<Integer, Integer> entry : map.entrySet())
entry.getKey

        530. Minimum Absolute Difference in BST
BST����С��ֵ   ��һ��prev
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
ɨ��  ��һ��λ��֮�� ��ʾɨ��ͼ

 526. Beautiful Arrangement
��i��λ���ϵ��� �ܱ�i ����
����i�ܱ���i��λ���ϵ�������
���� ����
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
01���飬�����һ�������� 01������ͬ













