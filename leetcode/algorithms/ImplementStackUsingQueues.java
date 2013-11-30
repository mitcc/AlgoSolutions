/*
 * Implement the following operations of a stack using queues.
 * 
 * push(x) -- Push element x onto stack.
 * pop() -- Removes the element on top of the stack.
 * top() -- Get the top element.
 * empty() -- Return whether the stack is empty.
 * Notes:
 * You must use only standard operations of a queue -- which 
 * means only push to back, peek/pop from front, size, and is 
 * empty operations are valid.
 * Depending on your language, queue may not be supported 
 * natively. You may simulate a queue by using a list or deque 
 * (double-ended queue), as long as you use only standard 
 * operations of a queue.
 * You may assume that all operations are valid (for example, 
 * no pop or top operations will be called on an empty stack).
 */
public class ImplementStackUsingQueues {

    class MyStack {
        
        Queue<Integer> queue1 = new LinkedList<Integer>();
        Queue<Integer> queue2 = new LinkedList<Integer>();
        int size = 0;

        // Push element x onto stack.
        public void push(int x) {
            queue1.add(x);
            size++;
        }

        // Removes the element on top of the stack.
        public void pop() {
            for (int i = size; i > 1; i--) {
                queue2.offer(queue1.poll());
            }
            queue1 = queue2;
            queue2 = new LinkedList<Integer>();
            if (size > 0)
                size--;
        }

        // Get the top element.
        public int top() {
            if (size <= 0)
                return Integer.parseInt(null);
            for (int i = size; i > 1; i--) {
                queue2.offer(queue1.poll());
            }
            int topValue = queue1.poll();
            queue2.offer(topValue);
            queue1 = queue2;
            queue2 = new LinkedList<Integer>();
            return topValue;
        }

        // Return whether the stack is empty.
        public boolean empty() {
            return size == 0;
        }
    }

}
