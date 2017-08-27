/*Created by ${USER} on ${DATE}.
 *题意：数组数字代表矩形高度，求最大矩形面积
 *注意：
 *思路：维护一个栈，如果栈为空或者当前元素比栈顶元素大（peek）将当前元素的索引入栈，如果<= 栈顶元素（while)，
 * 弹出栈顶元素，将这一段矩形面积算出来作比较， while循环继续比较栈顶元素，找到这个元素能影响到的最多的位置记录这个max
 *
 *一刷：如果当前元素比栈顶元素小那么它的最优组合中就一定有栈顶这个元素。如果大那就不用了并不care栈顶元素
 *二刷：
 *复杂度分析：
 *反思：
 */
//第一次
public class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack=new Stack<>();
        int max=0;
        for(int i=0;i<=heights.length;i++){
            int curt = (i == heights.length) ? -1 : heights[i];
            while(!stack.isEmpty()&&curt <=heights[stack.peek()]){
                int h=heights[stack.pop()];
                int w=stack.isEmpty()?i:i-stack.peek()-1;
                max=Math.max(max,h*w);
            }
            stack.push(i);
        }
        return max;
    }
}

//第二次

