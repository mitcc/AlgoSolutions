/*
Implement the following operations of a stack using queues.

push(x) -- Push element x onto stack.
pop() -- Removes the element on top of the stack.
top() -- Get the top element.
empty() -- Return whether the stack is empty.
Notes:
You must use only standard operations of a queue -- which means only push to
back, peek/pop from front, size, and is empty operations are valid.
Depending on your language, queue may not be supported natively. You may
simulate a queue by using a list or deque (double-ended queue), as long as you
use only standard operations of a queue.
You may assume that all operations are valid (for example, no pop or top
operations will be called on an empty stack).
 */
public class ImplementStackUsingQueues {
}

class MyStack {

    private int size;
    private int top;
    private Queue<Integer> queue0;
    private Queue<Integer> queue1;

    /** Initialize your data structure here. */
    public MyStack() {
        size = 0;
        queue0 = new LinkedList<Integer>();
        queue1 = new LinkedList<Integer>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        queue0.offer(x);
        size++;
        top = x;
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        for (int i = 0; i < size - 1; ++i) {
            top = queue0.poll();
            queue1.offer(top);
        }
        int result = queue0.poll();
        size--;
        queue0 = queue1;
        queue1 = new LinkedList<Integer>();
        return result;
    }

    /** Get the top element. */
    public int top() {
        return top;
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return size == 0;
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
