package pl.grzesk075.sandbox.leetcode;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.Assertions.tuple;
import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.LinkedList;

import org.junit.Test;

public class ReverseLinkedListTest {

    @Test
    public void shouldRevertLinkedList() {
        final LinkedList<Integer> linkedList = new LinkedList<>(Arrays.asList(4, 3, 2, 1));
        ReverseLinkedList.solution(linkedList);
        assertEquals(Arrays.asList(1, 2, 3, 4), linkedList);
        assertThat(linkedList).as("check %d sized integer list", 4).containsExactly(1, 2, 3, 4);
        assertThat(linkedList).filteredOn(i -> i < 2).containsOnly(1);
//        // nested properties are supported
//        assertThat(fellowshipOfTheRing).filteredOn("race.name", "Man")
//                .containsOnly(aragorn, boromir);
        assertThat(linkedList).extracting("MAX_VALUE", "MIN_VALUE").containsOnly(tuple(2147483647, -2147483648));

        final LinkedList linkedList1 = new LinkedList(Arrays.asList(4));
        ReverseLinkedList.solution(linkedList1);
        assertEquals(Arrays.asList(4), linkedList1);
        assertThat(linkedList1).containsExactly(4);

        final LinkedList linkedList2 = new LinkedList(Arrays.asList(4,5));
        ReverseLinkedList.solution(linkedList2);
        assertEquals(Arrays.asList(5,4), linkedList2);
        assertThat(linkedList2).containsExactly(5, 4);

        final LinkedList linkedList3 = new LinkedList();
        ReverseLinkedList.solution(linkedList3);
        assertEquals(new LinkedList(), linkedList3);
        assertThat(linkedList3).isEmpty();
    }

    @Test
    public void shoudThrowNPE() {
        assertThatExceptionOfType(NullPointerException.class).isThrownBy(() -> {
            ReverseLinkedList.solution(null);
        });
    }

    @Test
    public void testException() {
        assertThatExceptionOfType(Exception.class).isThrownBy(() -> {
            throw new Exception("boom!");
        })
                .withMessage("%s!", "boom")
                .withMessageContaining("boom")
                .withNoCause();
    }
}