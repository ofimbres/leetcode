/**
 * 45. Jump Game II
 * https://leetcode.com/problems/jump-game-ii/
 */

class Solution {

    /**
     * Approach 1. Greedy
     * Time: O(N), Space: O(1)
     *
     * Implicit BFS solution:
     * * i == curEnd means you visited all the items on the current level.
     * * Incrementing jumps++ is like incrementing the leven you are on.
     * * curEnd = farthest is like getting the queue size (level size) for
     *   the next level you are traversing.
     */
    public int jump(int[] nums) {
        int farthest = 0;
        int curEnd = 0;
        int jumps = 0;

        for (int i = 0; i < nums.length - 1; ++i) {
            farthest = Math.max(farthest, i + nums[i]);
            if (i == curEnd) {
                jumps++;
                currEnd = farthest;
            }
        }
        return jumps;
    }

    /**
     * Approach 2. Recursion + Memoization
     * Time: O(N^2), Space: O(N)
     */
    /*public int jump(int[] nums) {
        Map<Integer, Integer> memo = new HashMap<Integer, Integer>();
        return jump(0, nums, memo);
    }

    private int jump(int pos, int[] nums, Map<Integer, Integer> memo) {
        if (pos >= nums.length - 1) {
            return 0;
        }

        if (memo.containsKey(pos)) {
            return memo.get(pos);
        }

        int minSteps = 100000;
        for (int i = 1; i <= nums[pos]; ++i) {
            minSteps = Math.min(minSteps, jump(pos + i, nums, memo) + 1);
        }

        memo.put(pos, minSteps);
        return minSteps;
    }*/

    /**
     * Approach 3. Tabulation
     * Time: O(N^2), Space: O(N)
     */
    /*public int jump(int[] nums) {
        int len = nums.length;
        int[] stepsToGoal = new int[len];
        for (int i = 1; i < len; ++i) {
            stepsToGoal[i] = 100000;
        }

        for (int i = 0; i < len - 1; ++i) {
            int maxSteps = Math.min(i + nums[i], len - 1);
            for (int j = i; j <= maxSteps; j++) {
                stepsToGoal[j] = Math.min(stepsToGoal[j], stepsToGoal[i] + 1);
            }
        }

        return stepsToGoal[len - 1];
    }*/
}