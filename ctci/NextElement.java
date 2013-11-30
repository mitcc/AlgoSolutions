public class NextElement {

    public int[] findNext(int[] A, int n) {
        if (A == null || A.length == 0) {
            return null;
        }
        int[] result = new int[A.length];
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = A.length - 1; i >= 0; --i) {
            while (stack.size() > 0 && A[i] >= stack.peek()) {
                stack.pop();
            }
            result[i] = stack.size() == 0 ? -1 : stack.peek();
            stack.push(A[i]);
        }
        return result;
    }

    public int[] findNext2(int[] A, int n) {
        if (A == null || A.length == 0) {
            return null;
        }
        int[] result = new int[A.length];
        Arrays.fill(result, -1);
        for (int i = 0; i < A.length; ++i) {
            for (int j = i + 1; j < A.length; ++j) {
                if (A[i] < A[j]) {
                    if (result[i] == -1) {
                        result[i] = A[j];
                    } else {
                        result[i] = Math.min(result[i], A[j]);
                    }
                }
            }
        }
        return result;
    }

}
