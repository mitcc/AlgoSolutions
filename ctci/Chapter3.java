public class Chapter3 {

    // 3.3
    public ArrayList<ArrayList<Integer>> setOfStacks(int[][] ope, int size) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if (ope == null || ope.length == 0) {
            return result;
        }
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < ope.length; ++i) {
            if (ope[i][0] == 1) {// push
                if (list.size() >= size) {
                    result.add(list);
                    list = new ArrayList<Integer>();
                }
                list.add(ope[i][1]);
            } else if (ope[i][0] == 2) {// pop
                if (list.size() == 0 && result.size() > 0) {
                    list = result.remove(result.size() - 1); 
                }
                if (list.size() > 0) {
                    list.remove(list.size() - 1);
                }
            }
        }
        if (list.size() > 0) {
            result.add(list);
        }
        return result;
    }

    // 3.5
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

    // 3.6
    public ArrayList<Integer> twoStacksSort(int[] numbers) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (numbers == null || numbers.length == 0) {
            return result;
        }
        Stack<Integer> stack1 = new Stack<Integer>();
        Stack<Integer> stack2 = new Stack<Integer>();
        for (int number : numbers) {
            stack2.push(number);
        }
        while (!stack2.isEmpty()) {
            int x = stack2.pop();
            if (stack1.isEmpty() || stack1.peek() <= x) {
                stack1.push(x);
            } else {
                while (!stack1.isEmpty() && stack1.peek() > x) {
                    stack2.push(stack1.pop());
                }
                stack1.push(x);
            }
        }
        while (!stack1.isEmpty()) {
            result.add(stack1.pop());
        }
        return result;
    }

}
