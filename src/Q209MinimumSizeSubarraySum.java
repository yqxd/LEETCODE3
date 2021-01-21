//Given an array of n positive integers and a positive integer s, find the minimal length of a contiguous subarray of which the sum ≥ s. If there isn't one, return 0 instead.
//
//        Example:
//
//        Input: s = 7, nums = [2,3,1,2,4,3]
//        Output: 2
//        Explanation: the subarray [4,3] has the minimal length under the problem constraint.
//        Follow up:
//        If you have figured out the O(n) solution, try coding another solution of which the time complexity is O(n log n).


public class Q209MinimumSizeSubarraySum {
    public int minSubArrayLen(int s, int[] nums) {
        int sum = 0;
        int tail = -1;
        int minLength = 2147483647;
        for (int head = 0; head < nums.length; head++) {
            while (sum < s) {
                tail += 1;
                if (tail == nums.length) {
                    if(minLength == 2147483647){
                        return 0;
                    }
                    return minLength;
                }
                sum += nums[tail];
            }
            if (tail - head + 1 < minLength) {
                minLength = tail - head + 1;
            }
            sum -= nums[head];
        }
        if(minLength == 2147483647){
            return 0;
        }
        return minLength;
    }

    public static void main(String[] args) {
        Q209MinimumSizeSubarraySum A = new Q209MinimumSizeSubarraySum();
        int[] num = {2, 3, 1, 4, 3, 7};
        System.out.println(A.minSubArrayLen(7, num));
    }
}
