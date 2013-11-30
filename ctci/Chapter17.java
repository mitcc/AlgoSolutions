/*
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}*/
/*
public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;
    public TreeNode(int val) {
        this.val = val;
    }
}*/
public class Chapter17 {

    // 17.1
    public int[] exchangeAB(int[] AB) {
        // write code here
        AB[0] ^= AB[1];
        AB[1] ^= AB[0];
        AB[0] ^= AB[1];
        return AB;
    }

    // 17.2
    public boolean checkWon(int[][] board) {
        if (board == null || board.length != 3) {
            return false;
        }
        if (board[0][0] + board[1][1] + board[2][2] == 3 
                || board[0][2] + board[1][1] + board[2][0] == 3) {
            return true;
        }
        for (int i = 0; i < 2; ++i) {
            if (board[i][0] + board[i][1] + board[i][2] == 3 
                    || board[0][i] + board[1][i] + board[2][i] == 3) {
                return true;
            }
        }
        return false;
    }

    // 17.3
    public int getFactorSuffixZero(int n) {
        int result = 0;
        while (n > 0) {
            n /= 5;
            result += n;
        }
        return result;
    }

    // 17.4
    public int getMax(int a, int b) {
        int sign = (a - b) >> 31;
        return a + sign * (a - b);
    }

    public int getMax(int a, int b) {
        // a + b + |a - b| 最大值的两倍，同理a + b - |a - b|是最小值的两倍
        return (a + b + Math.abs(a - b)) / 2;
    }

    public int getMax(int a, int b) {
        b = a - b;
        a -= b & (b >> 31);
        return a;
    }

    // 17.8
    public int getMaxSum(int[] A, int n) {
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0, curSum = 0; i < A.length; ++i) {
            curSum += A[i];
            maxSum = Math.max(maxSum, curSum);
            curSum = Math.max(curSum, 0);
        }
        return maxSum;
    }

    // 17.9
    public int getFrequency(String[] article, int n, String word) {
        // write code here
        int count = 0;
        for (String s : article) {
            count += s.equals(word) ? 1 : 0;
        }
        return count;
    }

    // 17.12
    public int countPairs(int[] A, int n, int sum) {
        if (A == null || A.length == 0 || A.length == 1) {
            return 0;
        }
        int count = 0;
        Arrays.sort(A);
        int i = 0;
        int j = A.length - 1;
        while (i < j) {
            if (A[i] + A[j] < sum) {
                i++;
            } else if (A[i] + A[j] > sum) {
                j--;
            } else {
                if (A[i] == A[j]) {
                    count += (j - i + 1) * (j - i) / 2;
                    break;
                } else {
                    int iHigh = i + 1;
                    for (; iHigh <= j && A[iHigh] == A[i]; ++iHigh);
                    int jLow = j - 1;
                    for (; jLow >= i && A[jLow] == A[j]; --jLow);
                    count += (iHigh - i) * (j - jLow);
                    i = iHigh;
                    j = jLow;
                }
            }
        }
        return count;
    }

    // 17.13
    // iterate
    public ListNode treeToList(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while (root != null || !stack.isEmpty()) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                root = stack.pop();
                cur.next = new ListNode(root.val);
                cur = cur.next;
                root = root.right;
            }
        }
        return dummy.next;
    }

    // recursion
    public ListNode treeToList(TreeNode root) {
        if (root == null) {
            return null;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = treeToList(root.left);
        ListNode cur = dummy;
        while (cur.next != null) {
            cur = cur.next;
        }
        cur.next = new ListNode(root.val);
        cur = cur.next;
        cur.next = treeToList(root.right);
        return dummy.next;
    }

}
