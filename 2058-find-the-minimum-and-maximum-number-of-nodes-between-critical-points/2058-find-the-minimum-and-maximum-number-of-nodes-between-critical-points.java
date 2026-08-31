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
class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        int firstCriticalIndex = -1;
        int previousCriticalIndex = -1;

        int minDistance = Integer.MAX_VALUE;

        int index = 1;

        ListNode previous = head;
        ListNode current = head.next;

        while (current.next != null) {

            ListNode next = current.next;

            boolean isMaximum =
                current.val > previous.val &&
                current.val > next.val;

            boolean isMinimum =
                current.val < previous.val &&
                current.val < next.val;

            if (isMaximum || isMinimum) {

                if (firstCriticalIndex == -1) {

                    firstCriticalIndex = index;

                } else {

                    int distance = index - previousCriticalIndex;

                    minDistance = Math.min(minDistance, distance);
                }

                previousCriticalIndex = index;
            }

            previous = current;
            current = next;
            index++;
        }

        if (firstCriticalIndex == previousCriticalIndex) {
            return new int[]{-1, -1};
        }

        int maxDistance =
            previousCriticalIndex - firstCriticalIndex;


        return new int[]{minDistance, maxDistance};
    }
}