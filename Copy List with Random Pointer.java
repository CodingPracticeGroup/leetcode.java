/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if (head==null)
            return null;
        RandomListNode copy;
        RandomListNode orig = head;
        while (orig!=null) {
            copy = new RandomListNode(orig.label);
            copy.next = orig.next;
            copy.random = orig.random;
            //
            orig.next = copy;
            //
            orig = copy.next;
        }
        orig = head;
        while (orig!=null) {
            copy = orig.next;
            if (copy.random != null)
                copy.random = copy.random.next;
            orig = copy.next;
        }
        orig = head;
        copy = head.next;
        RandomListNode ret = copy;
        while (orig!=null) {
            RandomListNode orig_next = copy.next;
            if (copy.next != null){
                RandomListNode copy_next = copy.next.next;
                copy.next = copy_next;
                copy = copy_next;
            }
            orig.next = orig_next;
            orig = orig_next;
        }
        return ret;
    }
}