/**
 * 33. Search in Rotated Sorted Array
 * https://leetcode.com/problems/search-in-rotated-sorted-array/
 */

class Solution {
    public int search(int[] nums, int target) {
        int len = nums.length;
        if (len == 1) {
            return nums[0] == target ? 0 : -1;
        }

        int rotationIndex = findRotationIndex(nums);

        // if array is not rotated, search in the entire array
        if (rotationIndex == 0) {
            return binarySearch(nums, target, 0, len - 1);
        } else if (target < nums[0]) {
            // search in the right side
            return binarySearch(nums, target, rotationIndex, len - 1);
        } else {
            // search in the left side
            return binarySearch(nums, target, 0, rotationIndex - 1);
        }
    }

    private int findRotationIndex(int[] nums) {
        int len = nums.length;
        if (nums[0] < nums[len - 1]) {
            return 0;
        }

        int lo = 0;
        int hi = len - 1;
        while (lo <= hi) {
            int mi = (lo + hi) / 2;

            if (nums[mi] > nums[mi + 1]) {
                return mi + 1;
            } else if (nums[lo] > nums[mi]) {
                hi = mi - 1;
            } else {
                lo = mi + 1;
            }
        }

        return 0;
    }

    // return index of target. If not found, returns -1
    private int binarySearch(int[] nums, int target, int lo, int hi) {
        while (lo <= hi) {
            int mi = lo + (hi - lo) / 2;

            if (nums[mi] == target) {
                return mi;
            } else if (nums[mi] > target) {
                hi = mi - 1;
            } else {
                lo = mi + 1;
            }
        }

        return -1;
    }
}