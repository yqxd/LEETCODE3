//Given an array of integers, find if the array contains any duplicates.
//
//        Your function should return true if any value appears at least twice in the array, and it should return false if every element is distinct.
//
//        Example 1:
//
//        Input: [1,2,3,1]
//        Output: true
//        Example 2:
//
//        Input: [1,2,3,4]
//        Output: false
//        Example 3:
//
//        Input: [1,1,1,3,3,4,3,2,4,2]
//        Output: true

import java.util.*;

public class ContainsDuplicate217 {
    public static void main(String[] args) {
        ContainsDuplicate217 A = new ContainsDuplicate217();
        int[] B = {1,2,3,4,5,6};
        System.out.println(A.containsDuplicate(B));
    }

    private boolean containsDuplicate(int[] nums) {
        Map<Integer, Integer> M = new HashMap<>();
        for (int num : nums) {
            if (M.containsKey(num)) {
                return true;
            } else {
                M.put(num, 1);
            }
        }
        return false;
    }
}
