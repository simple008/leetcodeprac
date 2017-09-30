/*Created by ${USER} on ${DATE}.
 *题意：坐标系中给定两个正方形求 总面积 考虑覆盖情况
 *注意：
 *思路：按第一种方式 算就可以了  算个整的 除去覆盖的
 *一刷：
 *二刷：
 *复杂度分析：
 *反思：
 */
//第一次
public class Solution {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int a=C-E;
        int b=G-A;
        // int c=H-B;
        // int d=D-F;
        int sy=(C-A)*(D-B)+(G-E)*(H-F);
        int length=Math.min(C,G)-Math.max(A,E);
        int height=Math.min(D,H)-Math.max(B,F);
        if (A >= G || B >= H || C <= E || D <= F) return sy;
        else return sy-length*height;
    }
}
//第二次
public class Solution {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int left = Math.max(A,E), right = Math.max(Math.min(C,G), left);
        int bottom = Math.max(B,F), top = Math.max(Math.min(D,H), bottom);
        return (C-A)*(D-B) - (right-left)*(top-bottom) + (G-E)*(H-F);
    }
}