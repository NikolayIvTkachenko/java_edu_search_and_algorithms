package org.example.search_system_algorithms_v2;

import java.util.ArrayList;
import java.util.List;

public class ListNodeAppV1 {

    static void main() {

        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);

        node1.next = node2;
        node2.next = node3;
        node3.next = null;

        ListNode node0 = new ListNode(0, node1);
    }

    public static void profileArrayListAddEnd() {
        Timeable timeable = new Timeable();

        String title = "ArrayList add end";
        int startN = 4000;
        int endMillis = 1000;

    }

}
