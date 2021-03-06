package LinkedList.Advanced.Others;

import Library.Leetcode.ListNode;

/*
Write a program to find the node at which the intersection of two singly linked lists begins.


For example, the following two linked lists:

        A:          a1 → a2
                            ↘
                            c1 → c2 → c3
                            ↗
        B:     b1 → b2 → b3
begin to intersect at node c1.


Notes:

        If the two linked lists have no intersection at all, return null.
        The linked lists must retain their original structure after the function returns.
        You may assume there are no cycles anywhere in the entire linked structure.
        Your code should preferably run in O(n) time and use only O(1) memory.
*/
public class FindIntersectionOfTwoLists {
    public static ListNode intersection(ListNode a, ListNode b) {
        int aLength = getLength(a);
        int bLength = getLength(b);

        if (aLength > bLength) {
            for (int i = 0; i < aLength - bLength; i++) {
                a = a.next;
            }
        } else if (aLength < bLength) {
            for (int i = 0; i < bLength - aLength; i++) {
                b = b.next;
            }
        }

        while (a != b && a != null && b != null) {
            a = a.next;
            b = b.next;
        }
        return a;
    }

    private static int getLength(ListNode cur) {
        int length = 0;
        while (cur != null) {
            length++;
            cur = cur.next;
        }
        return length;
    }
}
