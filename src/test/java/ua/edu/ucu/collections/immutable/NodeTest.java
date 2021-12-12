package ua.edu.ucu.collections.immutable;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NodeTest {

    Node nextNode;
    Node previousNode;

    @BeforeEach
    void setUp() {
        nextNode = new Node();
        previousNode = new Node();
        previousNode.setNext(nextNode);
        nextNode.setPrevious(previousNode);
        previousNode.setValue(0);
        nextNode.setValue(10);
    }

    @Test
    void testToString() {
        assertEquals(nextNode.toString(), "10");
    }

    @Test
    void getPrevious() {
        assertEquals(nextNode.getPrevious(), previousNode);
    }

    @Test
    void setPrevious() {
        previousNode.setPrevious(nextNode);
        assertEquals(previousNode.getPrevious(), nextNode);
    }

    @Test
    void getValue() {
        assertEquals(nextNode.getValue(), 10);
    }

    @Test
    void setValue() {
        nextNode.setValue(100);
        assertEquals(nextNode.toString(), "100");
    }

    @Test
    void getNext() {
        assertEquals(previousNode.getNext(), nextNode);
    }

    @Test
    void setNext() {
        nextNode.setNext(previousNode);
        assertEquals(nextNode.getNext(), previousNode);
    }
}