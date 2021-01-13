import java.util.*;

public class Q207CourseSchedule {
    public void canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List> result = new HashMap<>();
        for (int[] prerequisite : prerequisites) {
            if (result.containsKey(prerequisite[0])) {
                result.get(prerequisite[0]).add(prerequisite[1]);
            } else {
                result.put(prerequisite[0], Collections.singletonList(new int[]{prerequisite[1]}));
            }
        }
        while (!result.isEmpty()){
            
        }
    }

    public static void main(String[] args) {
        Q207CourseSchedule A = new Q207CourseSchedule();

    }
}
