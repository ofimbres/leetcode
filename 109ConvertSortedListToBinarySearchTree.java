/**
 * 109. Convert Sorted List to Binary Search Tree
 * https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {

    /**
     * Approach 1. Recursion + Conversion to Array
     * Time: O(N), Space: O(N)
     */
    public TreeNode sortedListToBST(ListNode head) {
        List<Integer> list = mapListToValues(head);
        return convertListToBST(0, list.size() - 1, list);
    }

    private List<Integer> mapListToValues(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        return list;
    }

    private TreeNode convertListToBST(int start, int end, List<Integer> list) {
        if (start > end) {
            return null;
        }

        int mid = (start + end) / 2;

        TreeNode root = new TreeNode(list.get(mid));
        root.left = convertListToBST(start, mid - 1, list);
        root.right = convertListToBST(mid + 1, end, list);

        return root;
    }

    /**
     * Approach 2. Recursion
     * Time: O(N log N), Space: O(log N)
     */
    /*public TreeNode sortedListToBST(ListNode head) {
        // if the head doesn't exist, then the linked list is empty
        if (head == null) {
            return null;
        }

        ListNode mid = findMiddleElement(head);
        TreeNode root = new TreeNode(mid.val);

        // base case when there is just one element in the linked list.
        if (head == mid) {
            return root;
        }

        root.left = sortedListToBST(head);
        root.right = sortedListToBST(mid.next);
        return root;
    }

    private ListNode findMiddleElement(ListNode head) {
        ListNode prev = null;
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        // handling the case when slow pointer was equal to head
        if (prev != null) {
            prev.next = null;
        }

        return slow;
    }*/

    /**
     * Approach 3. Inorder Simulation
     * Time: O(N), Space: O(log N)
     */
    /*private ListNode head;

    public TreeNode sortedListToBST(ListNode head) {
        int size = findSize(head);

        this.head = head;

        return convertListToBST(0, size - 1);
    }

    private TreeNode convertListToBST(int start, int end) {
        // invalid case
        if (start > end) {
            return null;
        }

        int mid = (start + end) / 2;

        // first step of simulated inorder traversal. Recursively form
        // the left half
        TreeNode left = convertListToBST(start, mid - 1);

        // once left half is traversed, process the current node
        TreeNode root = new TreeNode(head.val);

        // maintain the invariance in the algorithm
        head = head.next;

        // recurse on the right hand side and form BST out of them
        root.left = left;
        root.right = convertListToBST(mid + 1, end);
        return root;
    }

    private int findSize(ListNode head) {
        int count = 0;

        while (head != null) {
            head = head.next;
            count++;
        }

        return count;
    }*/
}