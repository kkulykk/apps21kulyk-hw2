package ua.edu.ucu.collections.immutable;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ImmutableLinkedListTest {

    ImmutableLinkedList linkedList;

    @BeforeEach
    void setUp() {
        linkedList = new ImmutableLinkedList(new Object[] {10, 20, 30, 40});
    }

    @Test
    void testAdd() {
        assertArrayEquals(linkedList.add(50).toArray(), new Object[]{10, 20, 30, 40, 50});
        assertArrayEquals(linkedList.add(3,20).toArray(), new Object[]{10, 20, 30, 20, 40});
        assertThrows(IllegalArgumentException.class, () -> linkedList.clear().add(5,40 ));
    }

    @Test
    void testAddAll() {
        assertArrayEquals(linkedList.addAll(new Object[] {50, 40}).toArray(), new Object[]{10, 20, 30, 40, 50, 40});
        assertArrayEquals(linkedList.addAll(2, new Object[] {100, 200}).toArray(), new Object[]{10, 20, 100, 200, 30, 40});
        assertThrows(IllegalArgumentException.class, () -> linkedList.clear().addAll(5,
                new Object[]{10, 20, 100, 200, 30, 40} ));
    }

    @Test
    void get() {
        assertEquals(linkedList.get(2), 30);
        assertThrows(IllegalArgumentException.class, () -> linkedList.get(5));
    }

    @Test
    void remove() {
        assertArrayEquals(linkedList.remove(2).toArray(), new Object[]{10, 20, 40});
        assertThrows(IllegalArgumentException.class, () -> linkedList.remove(5));
    }

    @Test
    void set() {
        assertArrayEquals(linkedList.set(2, 1000).toArray(), new Object[]{10, 20, 1000, 40});
        assertThrows(IllegalArgumentException.class, () -> linkedList.set(15, 10));
    }

    @Test
    void indexOf() {
        assertEquals(linkedList.indexOf(20), 1);
    }

    @Test
    void size() {
        assertEquals(linkedList.size(), 4);
    }

    @Test
    void clear() {
        assertEquals(linkedList.clear().size(), 4);
        assertNull(linkedList.clear().get(1));
    }

    @Test
    void isEmpty() {
        assertTrue( new ImmutableLinkedList().isEmpty());
    }

    @Test
    void toArray() {
        assertArrayEquals(linkedList.toArray(), new Object[]{10, 20, 30, 40});
    }

    @Test
    void addFirst() {
        assertArrayEquals(linkedList.addFirst(2).toArray(), new Object[]{2, 10, 20, 30, 40});
    }

    @Test
    void addLast() {
        assertArrayEquals(linkedList.addLast(2).toArray(), new Object[]{10, 20, 30, 40, 2});
    }

    @Test
    void getHead() {
        assertEquals(linkedList.getHead().getValue(), 10);
    }

    @Test
    void getTail() {
        assertEquals(linkedList.getTail().getValue(), 40);
    }

    @Test
    void getFirst() {
        assertEquals(linkedList.getFirst(), 10);
        ImmutableLinkedList list2 = new ImmutableLinkedList();
        assertThrows(IllegalArgumentException.class, list2::getFirst);
    }

    @Test
    void getLast() {
        assertEquals(linkedList.getLast(), 40);
        ImmutableLinkedList list2 = new ImmutableLinkedList();
        assertThrows(IllegalArgumentException.class, list2::getLast);
    }

    @Test
    void removeFirst() {
        assertEquals(linkedList.removeFirst().getFirst(), 20);
        ImmutableLinkedList list2 = new ImmutableLinkedList();
        assertThrows(IllegalArgumentException.class, list2::removeFirst);
    }

    @Test
    void removeLast() {
        assertEquals(linkedList.removeLast().getLast(), 30);
        ImmutableLinkedList list2 = new ImmutableLinkedList();
        assertThrows(IllegalArgumentException.class, list2::removeLast);
    }
}