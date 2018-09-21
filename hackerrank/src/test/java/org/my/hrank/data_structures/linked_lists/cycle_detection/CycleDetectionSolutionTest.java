package org.my.hrank.data_structures.linked_lists.cycle_detection;

import org.junit.Assert;
import org.junit.Test;
import org.my.hrank.data_structures.linked_lists.cycle_detection.Solution.SinglyLinkedList;

public class CycleDetectionSolutionTest {
    @Test
    public void testNoCycles() {
        SinglyLinkedList list = new SinglyLinkedList();
        list.insertNode(1);
        list.insertNode(2);
        list.insertNode(3);

        Assert.assertFalse(Solution.hasCycle(list.head));

    }

    @Test
    public void testWithCycles() {
        SinglyLinkedList list = new SinglyLinkedList();
        list.insertNode(1);
        list.insertNode(2);
        list.insertNode(3);
        list.tail.next = list.head;

        Assert.assertTrue(Solution.hasCycle(list.head));

    }

    @Test
    public void testWithCycles1() {
        SinglyLinkedList list = new SinglyLinkedList();
        list.insertNode(1);
        list.insertNode(2);
        list.insertNode(3);
        list.insertNode(3);
        list.insertNode(3);
        list.tail.next = list.head.next.next;

        Assert.assertTrue(Solution.hasCycle(list.head));

    }

    @Test
    public void testWithCycles2() {
        SinglyLinkedList list = new SinglyLinkedList();
        list.insertNode(1);
        list.insertNode(-1);
        list.insertNode(1);
        list.insertNode(1);

        Assert.assertFalse(Solution.hasCycle(list.head));

    }

    @Test
    public void testWithCycles3() {
        SinglyLinkedList list = new SinglyLinkedList();
        list.insertNode(1);
        list.insertNode(1);
        list.insertNode(3);
        list.insertNode(1);
        list.insertNode(2);
        list.insertNode(3);
        list.head.next.next.next = list.head.next;

        Assert.assertTrue(Solution.hasCycle(list.head));

    }

    @Test
    public void testWith_EmptyListCycles() {
        SinglyLinkedList list = new SinglyLinkedList();

        Assert.assertFalse(Solution.hasCycle(list.head));

    }

}