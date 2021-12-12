package ua.edu.ucu.collections.immutable;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ImmutableArrayListTest {

    ImmutableArrayList arrayList;

    @BeforeEach
    void setUp() {
        arrayList = new ImmutableArrayList(new Object[] {10, 20, 30, 40});
    }


    @Test
    void testAdd() {
        assertArrayEquals(arrayList.add(50).toArray(), new Object[]{10, 20, 30, 40, 50});
        assertArrayEquals(arrayList.add(3,20).toArray(), new Object[]{10, 20, 30, 20, 40});
        assertThrows(IllegalArgumentException.class, () -> arrayList.clear().add(5,40 ));
    }

    @Test
    void testAddAll() {
        assertArrayEquals(arrayList.addAll(new Object[] {50, 40}).toArray(), new Object[]{10, 20, 30, 40, 50, 40});
        assertArrayEquals(arrayList.addAll(2, new Object[] {100, 200}).toArray(), new Object[]{10, 20, 100, 200, 30, 40});
        assertThrows(IllegalArgumentException.class, () -> arrayList.clear().addAll(5,
                new Object[]{10, 20, 100, 200, 30, 40} ));
    }

    @Test
    void get() {
        assertEquals(arrayList.get(2), 30);
        assertThrows(IllegalArgumentException.class, () -> arrayList.get(5));
    }

    @Test
    void remove() {
        assertArrayEquals(arrayList.remove(2).toArray(), new Object[]{10, 20, 40});
        assertThrows(IllegalArgumentException.class, () -> arrayList.remove(5));
    }

    @Test
    void set() {
        assertArrayEquals(arrayList.set(2, 1000).toArray(), new Object[]{10, 20, 1000, 40});
        assertThrows(IllegalArgumentException.class, () -> arrayList.set(15, 10));
    }

    @Test
    void indexOf() {
        assertEquals(arrayList.indexOf(20), 1);
    }

    @Test
    void size() {
        assertEquals(arrayList.size(), 4);
    }

    @Test
    void clear() {
        assertEquals(arrayList.clear().size(), 4);
        assertNull(arrayList.clear().get(1));
    }


    @Test
    void isEmpty() {
        assertTrue(new ImmutableArrayList().isEmpty());
    }

    @Test
    void toArray() {
        assertArrayEquals(arrayList.toArray(), new Object[]{10, 20, 30, 40});
    }
}