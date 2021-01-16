//There are a total of numCourses courses you have to take, labeled from 0 to numCourses-1.
//
//        Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]
//
//        Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?
//
//
//
//        Example 1:
//
//        Input: numCourses = 2, prerequisites = [[1,0]]
//        Output: true
//        Explanation: There are a total of 2 courses to take.
//        To take course 1 you should have finished course 0. So it is possible.
//        Example 2:
//
//        Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
//        Output: false
//        Explanation: There are a total of 2 courses to take.
//        To take course 1 you should have finished course 0, and to take course 0 you should
//        also have finished course 1. So it is impossible.
//
//
//        Constraints:
//
//        The input prerequisites is a graph represented by a list of edges, not adjacency matrices. Read more about how a graph is represented.
//        You may assume that there are no duplicate edges in the input prerequisites.
//        1 <= numCourses <= 10^5

import java.util.*;

public class Q207CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<int[]> requisites = new ArrayList<int[]>(Arrays.asList(prerequisites));
        int[] courses = new int[numCourses];
        int depth_now = 0;
        int failure;
        while (!requisites.isEmpty()) {
            failure = 1;
            ArrayList<Integer> DeleteCourses = new ArrayList<>();
            depth_now += 1;
            for (int[] requiste : requisites) {
                courses[requiste[0]] = depth_now;
            }
            for (int i = 0; i < courses.length; i++) {
                if (courses[i] == depth_now - 1) {
                    failure = 0;
                    DeleteCourses.add(i);
                }
            }
            if (failure == 1) {
                return false;
            }
            for (int i = requisites.size() - 1; i >= 0; i--) {
                if (DeleteCourses.contains(requisites.get(i)[1])) {
                    requisites.remove(i);
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Q207CourseSchedule A = new Q207CourseSchedule();
        int S[][] = {{1, 0}, {1, 2}, {0, 1}};
        System.out.println(A.canFinish(3, S));
    }
}
