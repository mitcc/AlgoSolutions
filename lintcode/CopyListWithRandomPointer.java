/*
 * A linked list is given such that each node contains an additional 
 * random pointer which could point to any node in the list or null.

Return a deep copy of the list.

Example
Challenge
Could you solve it with O(1) space?
 */
/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class CopyListWithRandomPointer {

    /**
     * @param head: The head of linked list with a random pointer.
     * @return: A new head of a deep copy of the list.
     */
    // O(n) time, O(1) space.
    public RandomListNode copyRandomList(RandomListNode head) {
        RandomListNode cur = head;
        while (cur != null) {
            RandomListNode next = cur.next;
            cur.next = new RandomListNode(cur.label);
            cur.next.next = next;
            cur = next;
        }
        cur = head;
        while (cur != null) {
            if (cur.random != null) {
                cur.next.random = cur.random.next;
            }
            cur = cur.next.next;
        }
        RandomListNode copy = head == null ? null : head.next;
        cur = head;
        while (cur != null) {
            RandomListNode next = cur.next;
            cur.next = next == null ? null : next.next;
            cur = next;
        }
        return copy;
    }

/*******************************************************************/

    // O(n) time, O(n) space.
    public RandomListNode copyRandomList(RandomListNode head) {
        RandomListNode dummy = new RandomListNode(0);
        RandomListNode cur1 = head;
        RandomListNode cur2 = dummy;
        Map<RandomListNode, RandomListNode> map = 
            new HashMap<RandomListNode, RandomListNode>();
        while (cur1 != null) {
            RandomListNode node = new RandomListNode(cur1.label);
            map.put(cur1, node);
            cur2.next = node;
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        cur1 = head;
        cur2 = dummy.next;
        while (cur1 != null) {
            cur2.random = map.get(cur1.random);
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        return dummy.next;
    }

}
