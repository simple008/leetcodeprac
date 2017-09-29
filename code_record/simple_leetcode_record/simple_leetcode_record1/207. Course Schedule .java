/*Created by ${USER} on ${DATE}.
 *题意：
 *注意：
 *思路：
 *一刷：
 *二刷：
 *复杂度分析：
 *反思：
 */

There are a total of n courses you have to take, labeled from 0 to n - 1.

        Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]

        Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?

        For example:

        2, [[1,0]]
        There are a total of 2 courses to take. To take course 1 you should have finished course 0. So it is possible.

        2, [[1,0],[0,1]]
        There are a total of 2 courses to take. To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. So it is impossible.

        Note:
        The input prerequisites is a graph represented by a list of edges, not adjacency matrices. Read more about how a graph is represented.
        You may assume that there are no duplicate edges in the input prerequisites.

//第一次
public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(numCourses<=0) return false;
        if(prerequisites==null) return false;
        int []inDegree=new int[numCourses];

        for(int []edge:prerequisites)
            inDegree[edge[0]]++;
        List<Integer> res=new ArrayList<Integer>();
        Queue<Integer> queue=new LinkedList<>();
        for(int i=0;i<inDegree.length;i++){
            if(inDegree[i]==0)
                queue.offer(i);
        }

        while(!queue.isEmpty()){
            int source=queue.poll();
            res.add(source);
            for(int [] edge:prerequisites){
                if(edge[1]==source){
                    inDegree[edge[0]]--;
                    if(inDegree[edge[0]]==0)
                        queue.offer(edge[0]);
                }

            }
        }
        return res.size()==numCourses;

    }
}
//第二次
public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {   // Kahn's method
        if (numCourses <= 0 || prerequisites == null) return false;
        if (prerequisites.length == 0) return true;
        int[] inDegree = new int[numCourses];
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) graph.add(new ArrayList<Integer>());
        for (int i = 0; i < prerequisites.length; i++) {
            inDegree[prerequisites[i][0]]++;
            graph.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) q.offer(i);
        }

        List<Integer> res = new ArrayList<>();
        while (!q.isEmpty()) {
            int num = q.poll();
            res.add(num);
            for (int i : graph.get(num)) {
                inDegree[i]--;
                if (inDegree[i] == 0) {
                    q.offer(i);
                }
            }
        }
        return res.size() == numCourses;
    }
}


