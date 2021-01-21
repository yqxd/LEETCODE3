//There are a total of n courses you have to take labelled from 0 to n - 1.
//
//        Some courses may have prerequisites, for example, if prerequisites[i] = [ai, bi] this means you must take the course bi before the course ai.
//
//        Given the total number of courses numCourses and a list of the prerequisite pairs, return the ordering of courses you should take to finish all courses.
//
//        If there are many valid answers, return any of them. If it is impossible to finish all courses, return an empty array.
//
//
//
//        Example 1:
//
//        Input: numCourses = 2, prerequisites = [[1,0]]
//        Output: [0,1]
//        Explanation: There are a total of 2 courses to take. To take course 1 you should have finished course 0. So the correct course order is [0,1].
//        Example 2:
//
//        Input: numCourses = 4, prerequisites = [[1,0],[2,0],[3,1],[3,2]]
//        Output: [0,2,1,3]
//        Explanation: There are a total of 4 courses to take. To take course 3 you should have finished both courses 1 and 2. Both courses 1 and 2 should be taken after you finished course 0.
//        So one correct course order is [0,1,2,3]. Another correct ordering is [0,2,1,3].
//        Example 3:
//
//        Input: numCourses = 1, prerequisites = []
//        Output: [0]
//
//
//        Constraints:
//
//        1 <= numCourses <= 2000
//        0 <= prerequisites.length <= numCourses * (numCourses - 1)
//        prerequisites[i].length == 2
//        0 <= ai, bi < numCourses
//ai != bi
//        All the pairs [ai, bi] are distinct.

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q210CourseScheduleII {
    public static void main(String[] args) {
        Q210CourseScheduleII A = new Q210CourseScheduleII();
        int[][] S = {{1, 0}, {1, 2}, {2, 3}};
    }
}

//    class Solution {
//        static int WHITE = 1;
//        static int GRAY = 2;
//        static int BLACK = 3;
//
//        boolean isPossible;
//        Map<Integer, Integer> color;
//        Map<Integer, List<Integer>> adjList;
//        List<Integer> topologicalOrder;
//
//        private void init(int numCourses) {
//            this.isPossible = true;
//            this.color = new HashMap<Integer, Integer>();
//            this.adjList = new HashMap<Integer, List<Integer>>();
//            this.topologicalOrder = new ArrayList<Integer>();
//
//            // By default all vertces are WHITE
//            for (int i = 0; i < numCourses; i++) {
//                this.color.put(i, WHITE);
//            }
//        }
//
//        private void dfs(int node) {
//
//            // Don't recurse further if we found a cycle already
//            if (!this.isPossible) {
//                return;
//            }
//
//            // Start the recursion
//            this.color.put(node, GRAY);
//
//            // Traverse on neighboring vertices
//            for (Integer neighbor : this.adjList.getOrDefault(node, new ArrayList<Integer>())) {
//                if (this.color.get(neighbor) == WHITE) {
//                    this.dfs(neighbor);
//                } else if (this.color.get(neighbor) == GRAY) {
//                    // An edge to a GRAY vertex represents a cycle
//                    this.isPossible = false;
//                }
//            }
//
//            // Recursion ends. We mark it as black
//            this.color.put(node, BLACK);
//            this.topologicalOrder.add(node);
//        }
//
//        public int[] findOrder(int numCourses, int[][] prerequisites) {
//
//            this.init(numCourses);
//
//            // Create the adjacency list representation of the graph
//            for (int i = 0; i < prerequisites.length; i++) {
//                int dest = prerequisites[i][0];
//                int src = prerequisites[i][1];
//                List<Integer> lst = adjList.getOrDefault(src, new ArrayList<Integer>());
//                lst.add(dest);
//                adjList.put(src, lst);
//            }
//
//            // If the node is unprocessed, then call dfs on it.
//            for (int i = 0; i < numCourses; i++) {
//                if (this.color.get(i) == WHITE) {
//                    this.dfs(i);
//                }
//            }
//
//            int[] order;
//            if (this.isPossible) {
//                order = new int[numCourses];
//                for (int i = 0; i < numCourses; i++) {
//                    order[i] = this.topologicalOrder.get(numCourses - i - 1);
//                }
//            } else {
//                order = new int[0];
//            }
//
//            return order;
//        }
//    }


//class Solution {
//
//    LinkedList<Integer> adj[];
//    Map<Integer, Integer> inDegree = new HashMap<>();
//    Stack<Integer> stack = new Stack<>();
//
//    public int[] findOrder(int numCourses, int[][] prerequisites) {
//
//        int[] result = new int[numCourses];
//        int r=0;
//        adj = new LinkedList[numCourses];
//        for(int i=0; i<numCourses; i++) {
//            adj[i] = new LinkedList<Integer>();
//            result[r++]=i;
//            inDegree.put(i,0);
//        }
//        if(prerequisites.length==0)
//            return result;
//        r=0;
//        for(int i=0; i<prerequisites.length; i++) {
//            adj[prerequisites[i][1]].add(prerequisites[i][0]);
//            inDegree.put(prerequisites[i][0],inDegree.get(prerequisites[i][0])+1);
//        }
//        for(Map.Entry<Integer,Integer> entry : inDegree.entrySet()){
//            if(entry.getValue()==0)
//                stack.push(entry.getKey());
//        }
//        int k=0;
//        //TC - O(V+E), Space - O(V+E)
//        while(!stack.isEmpty()) {
//            int v = stack.pop();
//            result[r++]=v;
//            k++;
//            Iterator<Integer> itr = adj[v].listIterator();
//            while(itr.hasNext()) {
//                int neighbor = itr.next();
//                inDegree.put(neighbor, inDegree.get(neighbor)-1);
//                if(inDegree.get(neighbor)==0) {
//                    stack.push(neighbor);
//                }
//            }
//        }
//        //if k is less than n then not a Directed acyclic graph, since topological sort works only for DAG
//        if(k<numCourses)
//            return new int[]{};
//        return result;
//
//    }
//}