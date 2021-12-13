package ua.edu.ucu.collections.immutable;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class NodeTest {

    Node nextNode;
    Node previousNode;

    @BeforeEach
    public void setUp() {
        nextNode = new Node();
        previousNode = new Node();
        previousNode.setNext(nextNode);
        nextNode.setPrevious(previousNode);
        previousNode.setValue(0);
        nextNode.setValue(10);
    }

    @Test
    public void testToString() {
        assertEquals(nextNode.toString(), "10");
    }

    @Test
    public void getPrevious() {
        assertEquals(nextNode.getPrevious(), previousNode);
    }

    @Test
    public void setPrevious() {
        previousNode.setPrevious(nextNode);
        assertEquals(previousNode.getPrevious(), nextNode);
    }

    @Test
    public void getValue() {
        assertEquals(nextNode.getValue(), 10);
    }

    @Test
    public void setValue() {
        nextNode.setValue(100);
        assertEquals(nextNode.toString(), "100");
    }

    @Test
    public void getNext() {
        assertEquals(previousNode.getNext(), nextNode);
    }

    @Test
    public void setNext() {
        nextNode.setNext(previousNode);
        assertEquals(nextNode.getNext(), previousNode);
    }
}