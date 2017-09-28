package bishi.hulu;

import java.util.*;

/**
 * Created by lpeiz on 2017/9/21.
 */



public class Main1 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int start = in.nextInt();
        List<LinkedList<Integer>> ans = new LinkedList<LinkedList<Integer>>();
        in.nextLine();
        for (int i = 1; i <= n; i++) {
            String s = in.nextLine();
            String[] ss = s.split(" ");
//            ArrayList<Integer> temp = new ArrayList<Integer>();
            LinkedList<Integer> temp = new LinkedList<>();
            for (int j = 0; j < ss.length; j++) {
                temp.add(Integer.valueOf(ss[j]));
            }
            ans.add(temp);
        }
        LinkedList<Integer> trace = new LinkedList<>();
        List<Integer> res = new LinkedList<Integer>();


        if (ans.get(start - 1) != null) {
            for (int i = ans.get(start - 1).size() - 1; i >= 0; i--) {
                trace.push(ans.get(start - 1).get(i));
            }
        }

        Stack<Integer> route = new Stack<Integer>(); // 当前的路径
        Stack<Integer> record = new Stack<Integer>(); //用于最后弹栈
        Stack<Integer> num = new Stack<Integer>(); //存储第几个当前是第几个函数
        LinkedList<Integer> cur = new LinkedList<Integer>();
        route.push(start);
        record.push(start);
        num.push(start);

        int node;
        while (!route.isEmpty()) {
            cur = ans.get(start - 1);
            node = cur.getFirst();

            route.push(node);
            record.push(node);
            num.push(start - 1);
            if (node == -1) {
                out(record);
            } else if (node == 0) {
                while (route.peek() != start - 1) {
                    route.pop();
                    num.pop();
                }
            } else {
                start = node;
            }
        }

        boolean flag = true;

        while (!trace.isEmpty() && flag) {
            int next = trace.pop();
            res.add(next);
            if (next == 0) {
                System.out.println("R");
                return;
            } else if (next == -1) {
                flag = false;
            } else {
                if (ans.get(next - 1) != null) {
                    for (int i = ans.get(next - 1).size() - 1; i >= 0; i--) {
                        trace.push(ans.get(next - 1).get(i));
                    }
                }
            }
        }
        if (!flag) {
            while (!trace.isEmpty()) {
                res.add(trace.poll());
            }
            for (int i = 0; i < trace.size(); i++) {
                System.out.print(res.get(i) + " ");
            }

        }
    }

    public static void out(Stack<Integer> record) {
        while (!record.isEmpty()) {
            System.out.println(record.pop());
        }
    }

    public void main() {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<List<Integer>> panel = new ArrayList<List<Integer>>();
        int cnt1 = 0, cnt2 = 0;
        for (int i = 0; i < n; i++) {
            String str = sc.nextLine();
            System.out.println(str);
            List<Integer> list = new ArrayList<Integer>();
            for (int j = 0; j < n; j++) {
                int x = sc.nextInt();
                if (x == 1) cnt1++;
                else if (x == 2) cnt2++;
                list.add(x);
            }
            panel.add(list);
        }
        if (cnt1 != cnt2) {
            System.out.println(-1);
        } else {
            System.out.println(dfs(panel, n, cnt1 + cnt2, true));
        }

    }

    private static int dfs(List<List<Integer>> panel, int n, int cnt, boolean b) {
        if (cnt > n * n) return 0;
        if (b) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    int ele = panel.get(i).get(j);
                    if (ele != 0) {
                        panel.get(i).set(j, 1);
                        if (canWin(panel, i, j, n)) return 1;
                    }
                }
                boolean white = true;
                for (int j = 0; j < n; j++) {
                    int ele = panel.get(i).get(j);
                    if (ele != 0) {
                        panel.get(i).set(j, 1);
                        if (dfs(panel, n, cnt + 1, !b) != 2) {
                            white = false;
                            panel.get(i).set(j, 0);
                            break;
                        }
                        panel.get(i).set(j, 0);
                    }
                }
                if (white) return 2;
            }
        } else {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    int ele = panel.get(i).get(j);
                    if (ele != 0) {
                        panel.get(i).set(j, 2);
                        if (canWin(panel, i, j, n)) return 2;
                    }
                }
                boolean black = true;
                for (int j = 0; j < n; j++) {
                    int ele = panel.get(i).get(j);
                    if (ele != 0) {
                        panel.get(i).set(j, 2);
                        if (dfs(panel, n, cnt + 1, !b) != 1) {
                            black = false;
                            panel.get(i).set(j, 0);
                            break;
                        }
                        panel.get(i).set(j, 0);
                    }
                }
                if (black) return 2;
            }

        }
        return 0;
    }

    private static boolean canWin(List<List<Integer>> panel, int i, int j, int n) {
        int d1 = 1, d2 = 1, d3 = 1, d4 = 1;
        int c = panel.get(i).get(j);
        for (int k = j + 1; k < n; k++) {
            if (panel.get(i).get(k) != c) break;
            d1++;
        }
        for (int k = j - 1; k >= 0; k--) {
            if (panel.get(i).get(k) != c) break;
            d1++;
        }
        if (d1 >= 5) return true;
        for (int k = i + 1; k < n; k++) {
            if (panel.get(k).get(j) != c) break;
            d2++;
        }
        for (int k = i - 1; k >= 0; k--) {
            if (panel.get(k).get(j) != c) break;
            d2++;
        }
        if (d2 >= 5) return true;
        for (int k = j + 1, r = i + 1; k < n && r < n; k++, r++) {
            if (panel.get(r).get(k) != c) break;
            d3++;
        }
        for (int k = j - 1, r = i - 1; k >= 0 && r >= 0; k--, r--) {
            if (panel.get(r).get(k) != c) break;
            d3++;
        }
        if (d3 >= 5) return true;
        for (int k = j - 1, r = i + 1; k >= 0 && r < n; k--, r++) {
            if (panel.get(r).get(k) != c) break;
            d4++;
        }
        for (int k = j + 1, r = i - 1; k < n && r >= 0; k++, r--) {
            if (panel.get(r).get(k) != c) break;
            d4++;
        }
        if (d4 >= 5) return true;
        return false;
    }
}