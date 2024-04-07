package deque;
import org.junit.Test;

import java.util.Comparator;

import static org.junit.Assert.*;

public class TestMaxArrayDeque {

    @Test
    public void testEmptyDequeMax() {
        MaxArrayDeque<Integer> deque = new MaxArrayDeque<>(new IntComparator());
        assertNull(deque.max());
        assertNull(deque.max(new IntComparator()));
    }

    @Test
    public void testSingleElementDequeMax() {
        MaxArrayDeque<Integer> deque = new MaxArrayDeque<>(new IntComparator());
        deque.addLast(5);
        assertEquals(5, deque.max().intValue());
        assertEquals(5, deque.max(new IntComparator()).intValue());
    }

    @Test
    public void testMultipleElementsDequeMax() {
        MaxArrayDeque<Integer> deque = new MaxArrayDeque<>(new IntComparator());
        deque.addLast(3);
        deque.addLast(8);
        deque.addLast(1);
        assertEquals(8, deque.max().intValue());
        assertEquals(8, deque.max(new IntComparator()).intValue());
    }

    @Test
    public void testMultipleElementsCustomComparatorMax() {
        MaxArrayDeque<String> deque = new MaxArrayDeque<>(new StringLengthComparator());
        deque.addLast("apple");  // Shorter
        deque.addLast("banana");  // Longer
        deque.addLast("cherry"); // Shorter
        assertEquals("banana", deque.max().toString());
        assertEquals("banana", deque.max(new StringLengthComparator()).toString());
    }

    @Test
    public void testMultipleEqualElementsDequeMax() {
        MaxArrayDeque<Integer> deque = new MaxArrayDeque<>(new IntComparator());
        deque.addLast(5);
        deque.addLast(5);
        deque.addLast(5);
        assertEquals(5, deque.max().intValue());
        assertEquals(5, deque.max(new IntComparator()).intValue());
    }

    private static class IntComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o1 - o2;
        }
    }
    private static class StringLengthComparator implements Comparator<String> {
        @Override
        public int compare(String o1, String o2) {
            if(o1.length() > o2.length()) {
                return 1;
            }
            if(o1.length() < o2.length()) {
                return -1;
            }
            return 0;
        }

    }

}