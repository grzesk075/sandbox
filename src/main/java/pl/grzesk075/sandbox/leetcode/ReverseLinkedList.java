package pl.grzesk075.sandbox.leetcode;

import java.util.LinkedList;

public class ReverseLinkedList {
    public static void solution(final LinkedList linkedList) {
        for (int i = 0; i < linkedList.size() - 1; i++) {
            linkedList.add(i, linkedList.removeLast());
        }
    }
}
