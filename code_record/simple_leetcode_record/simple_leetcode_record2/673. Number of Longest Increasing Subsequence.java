������ַ����ĸ�������ԭ������ַ������ȵķ��������� ��¼һ���ǲ�������λ���б仯���� �оͱ�1  û�о�+1


674. Longest Continuous Increasing Subsequence
��������ĵ�����
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
���Ƿ�ֻ��һ���ַ���ͬ���ַ���  map���ʱ�� key��ȥ������ַ���ǰ�������ַ���ƴ�ɵ�string key ��index��char
677. Map Sum Pairs
����ʱ���Ը���<String,int> ��ѯʱ�ķ���������ĳ���ַ���ǰ׺��key val�Ե� val�ĺ�
����map  һ�������������ַ���  ��һ���ڱ�����ʱ��ÿ��(0,i)�Ӵ�����һ�� ȡ����value
678. Valid Parenthesis String
�ж�һ�������ַ����Ƿ���Ч�� �� �� * ����ƥ����������Ż��߿ա�  ��¼*�Ĵ��� ������ �����Ŷ���������ʱ����
������ʱ ��������ʣ��ĸ�����*�Ƿ�ƥ��


//�ݹ�
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
24 ����Ϸ  = - * /
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
�����ַֽ���������ַ���
public class Solution {
    public boolean isPossible(int[] nums) {
        Map<Integer, Integer> unused_freq = new HashMap<Integer, Integer>(), need_freq = new HashMap<Integer, Integer>();
        for(int i : nums)	unused_freq.put(i, unused_freq.containsKey(i)?1+unused_freq.get(i):1);

        for(int i : nums) {
            if(unused_freq.get(i) == 0)	continue; 	// �����������

            if(need_freq.containsKey(i) && need_freq.get(i)>0) {
                // �ӵ��Ѿ��еĶ���
                need_freq.put(i, need_freq.get(i)-1);
                need_freq.put(i+1, need_freq.containsKey(i+1)?need_freq.get(i+1)+1:1);
                unused_freq.put(i, unused_freq.get(i)-1);
            } else if(unused_freq.containsKey(i+1) && unused_freq.get(i+1)>0
                    && unused_freq.containsKey(i+2) && unused_freq.get(i+2)>0) {
                // �ӵ��µĶ���
                need_freq.put(i+3, need_freq.containsKey(i+3)?1+need_freq.get(i+3):1);
                unused_freq.put(i, unused_freq.get(i)-1);
                unused_freq.put(i+1, unused_freq.get(i+1)-1);
                unused_freq.put(i+2, unused_freq.get(i+2)-1);
            } else {
                // ������޴�����
                return false;
            }
        }

        return true;
    }
}

658. Find K Closest Elements
���Ѿ�������������ҵ�����x�����k����  ����Ҳ������

657. Judge Route Circle
public boolean judgeCircle(String moves) {
        moves=" " + moves + " ";
        return moves.split("L").length==moves.split("R").length && moves.split("U").length == moves.split("D").length;
        }


654. Maximum Binary Tree
�ݹ� һֱ����������

653. Two Sum IV - Input is a BST
�ڶ�������������û����������Ϊ����ֵ
set  ����

652. Find Duplicate Subtrees
�ҳ�������ͬ�� ������������󵥸��ڵ���ͬҲ��    ���� n����ͬ��Ҷ�ӽڵ�

��map��������� ��ÿ�������У�

650. 2 Keys Keyboard
���� ճ�� ��С�Ĳ����õ� Ŀ���ַ��� �����ٵĲ���
��ճ���ľ���
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
�ʸ��滻  trie��  �����еĴʸ�������Ȼ�����

647. Palindromic Substrings
������Ĵ��ĸ��� ��ֹλ�ò�ͬ����һ�� һ���ַ�Ҳ��
�����ַ���ÿ�α���ʱĿ��λ���ǻ��Ĵ����ģ�������ż����  i,i  i,i+1

645. Set Mismatch
2����

643. Maximum Average Subarray I
640. Solve the Equation
��һ������x�ĵ�ʽ��x ��Ҫ���ڶ���

= �з����࣬�ֱ����  һ��������x��ϵ������һ��������������
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
�ݹ������ ÿһ�ַ��� ������� ʹ�� Ȼ�����ѭ�����ݹ���� ���оͻ���
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
            //��������ȫ�����ײ͵����
            for(int i=0;i<n;i++){
                minPrice+=(needs.get(i)*price.get(i));
            }
            //���������ײ͵����
            for(List<Integer> taocan:special){
                boolean canUseThisTaocan=true;
                int thisPrice=0;
                for(int i=0;i<n;i++){
                    if(needs.get(i)<taocan.get(i)){//�ײ�������ݳ�������Ҫ����Ŀ��
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
ÿ��ڵ��ƽ��ֵ     ��α��� ���ֵ


636. Exclusive Time of Functions
��¼����߳��ڵ���cpu�н������е�ִ��ʱ�䣨��ͬ�߳��н��棩

633. Sum of Square Numbers
�ж�һ�����ܲ��ܲ���ƽ�����ĺ�
ѭ���������жϡ�left 0  right sqrt(n)

632. Smallest Range
��һ����С�ķ�Χ ��֤n�ļ����ж����������������Χ�ڡ�
        ���ȶ��� ʱ�̱�֤ ��������n������ÿ�������ж���һ���������棩 ��Χ�������ֵ-��Сֵ



629. K Inverse Pairs Array
1-n ����������� ��k������Ե��ж��ٸ� ����
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
��һ�������ҵ��˻����� �������ĳ˻�
��������
������������ ������С�ĸ��� ��һ����������

623. Add One Row to Tree
�ڶ�������ĳһ�� ��һ��   ��α����������и�

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
���� dfs ��depth ����һ��Ȼ������� �ݹ�û���⣬ÿ��depth�Ľڵ㶼�������


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
merge ���ö��������յ��ǿ�  �ǿ� �Ӻ���Ϊ�ڵ�ֵ
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
����һ������ �ж��ж��ٸ��ϸ����������Ϸ�ʽ

609. Find Duplicate File in System
���ظ����ļ�   hash

606. Construct String from Binary Tree
�ݹ�  �������������˳��  ������
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
����û���㹻���0  û��1 ���� һά����

���Լ���ÿ�� �ж��ٸ�������0

600. Non-negative Integers without Consecutive Ones
�����ڲ����ڸ������ķǸ������Ķ����Ʊ���� �м�������û��������1
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
Let a[i] be the number of binary strings of length i which do not contain any two consecutive 1��s
        and which end in 0. Similarly, let b[i] be the number of such strings which end in 1.
        We can append either 0 or 1 to a string ending in 0,
        but we can only append 0 to a string ending in 1. This yields the recurrence relation:

        a[i] = a[i - 1] + b[i - 1]
        b[i] = a[i - 1]


599. Minimum Index Sum of Two Lists
easy

598. Range Addition II
����������Χ��Χ���ظ���������λ���м��� ���Ƿ�Χ����00 ��ʼ��һ������
����С�ĸ��Ǿ��εĳ���Ϳ����ˡ�

594. Longest Harmonious Subsequence
�ҳ�һ�������Сֵֻ��һ���������  ��ÿ�����ֵ�Ƶ�ʶ������ ����

593. Valid Square
����4����������ж����ĸ����ܷ񹹳�һ��������
1. ���򡣼��㳤�ȡ�
2. ���������֮��ľ��룬�ж��ǲ���ֻ���������볤�ȴ��ڣ�����û��0

592. Fraction Addition and Subtraction
�����ַ������ʽ ������ʽ�Ľ��  �Է�������ʽ���

        591. Tag Validator


587. Erect the Fence
���� �����е�����Χ����





583. Delete Operation for Two Strings
ɾ�����ٴ� �������ַ�����ͬ
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
�������е���һ�������� ʹ�������鶼����
����ָ��  һ��һ��  ���l��max ָ�뷢������˵�� ��lǰ�� �б�l�����С����   r��minͬ����������ǲ��Ϲ��
�ҵ������С�ķ�Χ

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
���� һ����  ��һ������ �����ж������ڸ����������Ƴ�����ķ���
û��
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

