/*
 * Implement the following operations of a queue using stacks.

 * push(x) -- Push element x to the back of queue.
 * pop() -- Removes the element from in front of queue.
 * peek() -- Get the front element.
 * empty() -- Return whether the queue is empty.
 * Notes:
 * You must use only standard operations of a stack -- which 
 * means only push to top, peek/pop from top, size, and is 
 * empty operations are valid.
 * Depending on your language, stack may not be supported 
 * natively. You may simulate a stack by using a list or deque 
 * (double-ended queue), as long as you use only standard 
 * operations of a stack.
 * You may assume that all operations are valid (for example, 
 * no pop or peek operations will be called on an empty queue).
 */
public class ImplementQueueUsingStacks {

    class MyQueue {

        Stack<Integer> stack0 = new Stack<Integer>();
        Stack<Integer> stack1 = new Stack<Integer>();
        private int size = 0;

        // Push element x to the back of queue.
        public void push(int x) {
            stack0.push(x);
            size++;
        }

        // Removes the element from in front of queue.
        public void pop() {
            while (!stack0.isEmpty()) {
                stack1.push(stack0.pop());
            }
            stack1.pop();
            size--;
            while (!stack1.isEmpty()) {
                stack0.push(stack1.pop());
            }
        }

        // Get the front element.
        public int peek() {
            while (!stack0.isEmpty()) {
                stack1.push(stack0.pop());
            }
            int top = stack1.peek();
            while (!stack1.isEmpty()) {
                stack0.push(stack1.pop());
            }
            return top;
        }

        // Return whether the queue is empty.
        public boolean empty() {
            return size == 0;
        }

    }

}
