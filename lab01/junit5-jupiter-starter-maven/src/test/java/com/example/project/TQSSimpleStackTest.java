package com.example.project;

import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class TQSSimpleStackTest {
    private TQSSimpleStack<String> testStack;
    private TQSSimpleStack<String> emptyStack;

    @BeforeEach
    void setUp(){
        testStack = new TQSSimpleStack<>();
        emptyStack = new TQSSimpleStack<>();

        testStack.push("Aveiro");
        testStack.push("Braga");
        testStack.push("Coimbra");
    }

    @Test
    void isEmpty(){ assertTrue(emptyStack.isEmpty(), "Empty stack should report empty!"); }

    @Test
    void pop(){
        assertEquals("Coimbra", testStack.pop());
        assertEquals(2, testStack.size());
    }

    void peek(){
        assertEquals("Coimbra", testStack.peek());
        assertEquals(3, testStack.size());
    }

    void size(){
        assertEquals(3, testStack.size());
        testStack.pop();
        assertEquals(2, testStack.size());
    }

    void push(){
        testStack.push("Porto");
        assertEquals("Porto", testStack.peek());
        assertEquals(4, testStack.size());
    }
}
