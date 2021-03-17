package com.example.project;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

import java.util.NoSuchElementException;

public class TQSSimpleStackTest {
    private static TQSSimpleStack<String> testStack;
    private static TQSSimpleStack<String> emptyStack;

    @BeforeEach
    public void setUp(){
        testStack = new TQSSimpleStack<>();
        emptyStack = new TQSSimpleStack<>();

        testStack.push("Aveiro");
        testStack.push("Braga");
        testStack.push("Coimbra");
    }

    @AfterEach
    public void clear() {
        testStack.clear();
    }

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
        assertEquals(3, testStack.size(), "The size is not the expected one!");
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
        testStack.push("Faro");
        int stackSize = testStack.size();
        assertEquals("Faro", testStack.peek(), "The peeked value is incorrect!");
        assertEquals(stackSize, testStack.size(), "The size is not the same after peeking!");
    }

    @Test
    @DisplayName("If the size is n, then after n pops, the stack is empty and has a size 0")
    public void emptyAfterPops() {
        pops(testStack, testStack.size());
        assertTrue(testStack.isEmpty(), "Stack should be empty, but it isn't!");
    }

    @Test
    @DisplayName("Popping from an empty stack does throw a NoSuchElementException")
    public void popFromEmpty() {
        assertThrows(NoSuchElementException.class, () -> {
            emptyStack.pop();
        });
    }

    @Test
    @DisplayName("Peeking into an empty stack does throw a NoSuchElementException")
    public void peekIntoEmpty() {
        assertThrows(NoSuchElementException.class, () -> {
            emptyStack.peek();
        });
    }

    @Test
    @DisplayName("For bounded stacks only, pushing onto a full stack does throw an IllegalStateException")
    public void pushFullStack() {
        testStack = new TQSSimpleStack<>(2);

        testStack.push("Aveiro");
        testStack.push("Coimbra");

        assertThrows(IllegalStateException.class, () -> {
            testStack.push("Braga");
        });
    }

    private void pops(TQSSimpleStack<String> stack, int n) {
        for (int i = 0; i < n; i++) {
            stack.pop();
        }
    }
}
