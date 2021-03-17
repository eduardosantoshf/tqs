package com.example.project;

import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
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

    /*
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
    */

    @Test
    @DisplayName("Stack is empty on construction")
    public void emptyOnConstruction() {
        assertTrue(emptyStack.isEmpty(), "Stack must be empty on construction!");
    }

    @Test
    @DisplayName("Stack has size 0 on construction")
    public void SizeZeroOnConstruction() {
        assertTrue(emptyStack.size() == 0, "Stack must have size 0 on construction!");
    }

    @Test
    @DisplayName("After n pushes to an empty stack, n > 0, the stack is not empty and its size is n")
    public void sizeAfterPushes() {
        assertEquals(3, testStack.size(), "The sixe is not the expected one!");
    }

    @Test
    @DisplayName("If one pushes x then pops, the value popped is x")
    public void pushThenPop() {
        testStack.push("Porto");
        assertEquals("Porto", testStack.pop(), "The popped value is incorrect!");
    }

    @Test
    @DisplayName("If one pushes x then peeks, the value returned is x, but the size stays the same")
    public void pushThenPeek() {
        int stackSize = testStack.size();
        testStack.push("Faro");
        assertEquals("Faro", testStack.peek(), "The peeked value is incorrect!");
        assertEquals(stackSize, testStack.size(), "The size is not the same after peeking!");
    }

    @Test
    @DisplayName("If the size is n, then after n pops, the stack is empty and has a size 0")
    public void emptyAfterPops() {
        
    }
}
