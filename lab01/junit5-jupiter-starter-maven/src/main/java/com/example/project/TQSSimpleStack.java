package com.example.project;

import java.util.ArrayList;

public class TQSSimpleStack<T> {
    private ArrayList<T> stack;

    public TQSSimpleStack(){ this.stack = new ArrayList<>(); }

    public void push(T n){ this.stack.add(n); }

    public T pop(){ return this.stack.remove(this.stack.size() - 1); }

    public T peek(){ return this.stack.get(this.stack.size() - 1); }

    public int size(){ return this.stack.size(); }

    public boolean isEmpty(){ return this.stack.size() == 0; }
}
