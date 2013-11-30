/*
public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}

public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}

public class UndirectedGraphNode {
    int label = 0;
    UndirectedGraphNode left = null;
    UndirectedGraphNode right = null;
    ArrayList<UndirectedGraphNode> neighbors = new ArrayList<UndirectedGraphNode>();

    public UndirectedGraphNode(int label) {
        this.label = label;
    }
}
*/
public class Chapter4 {

    // 4.1
    public boolean isBalance(TreeNode root) {
        return checkDepth(root) != -1;
    }

    public int checkDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = checkDepth(root.left);
        if (left == -1) {
            return -1;
        }
        int right = checkDepth(root.right);
        if (right == -1 || Math.abs(left - right) > 1) {
            return -1;
        }
        return 1 + Math.max(left, right);
    }

    // 4.3
    public int buildMinimalBST(int[] vals) {
        if (vals == null || vals.length == 0) {
            return 0;
        }
        int h = 1;
        for (; (2 << h - 1) < vals.length; ++h);
        return h;
    }

    // 4.4
    public ListNode getTreeLevel(TreeNode root, int dep) {
        ListNode dummy = new ListNode(0);
        if (root == null || dep <= 0) {
            return dummy.next;
        }
        List<TreeNode> prevLevel = new ArrayList<TreeNode>();
        List<TreeNode> curLevel = new ArrayList<TreeNode>();
        prevLevel.add(root);
        while (prevLevel.size() > 0 && dep > 1) {
            for (TreeNode node : prevLevel) {
                if (node.left != null) {
                    curLevel.add(node.left);
                }
                if (node.right != null) {
                    curLevel.add(node.right);
                }
            }
            prevLevel = curLevel;
            curLevel = new ArrayList<TreeNode>();
            dep--;
        }
        ListNode cur = dummy;
        for (TreeNode node : prevLevel) {
            cur.next = new ListNode(node.val);
            cur = cur.next;
        }
        return dummy.next;
    }

    // 4.5
    public boolean checkBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (root.left != null) {
            TreeNode cur = root.left;
            while (cur.right != null) {
                cur = cur.right;
            }
            if (root.val <= cur.val) {
                return false;
            }
        }
        if (root.right != null) {
            TreeNode cur = root.right;
            while (cur.left != null) {
                cur = cur.left;
            }
            if (root.val >= cur.val) {
                return false;
            }
        }
        return checkBST(root.left) && checkBST(root.right);
    }

/*******************************************************************/

    public boolean checkBST(TreeNode root) {
        return checkBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean checkBST(TreeNode root, long min, long max) {
        if (root == null) {
            return true;
        }
        return min < root.val && root.val < max 
            && checkBST(root.left, min, root.val) 
            && checkBST(root.right, root.val, max);
    }

    // 4.6
    public int findSucc(TreeNode root, int p) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode cur = root;
        boolean isPVisited = false;
        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                TreeNode node = stack.pop();
                if (isPVisited) {
                    return node.val;
                } else if (node.val == p) {
                    isPVisited = true;
                }
                cur = node.right;
            }
        }
        return -1;
    }

    // 4.7
    // iteration
    public int getLCA(int a, int b) {
        if (a <= 0 || b <= 0) {
            throw new IllegalArgumentException("illegal input: " + a + ", " + b);
        }
        while (a != b) {
            if (a > b) {
                a /= 2;
            } else {
                b /= 2;
            }
        }
        return a;
    }

    // recursion
    public int getLCA(int a, int b) {
        if (a <= 0 || b <= 0) {
            throw new IllegalArgumentException("illegal input: " + a + ", " + b);
        }
        if (a == b) {
            return a;
        } else if (a > b) {
            return getLCA(a / 2, b);
        } else {
            return getLCA(a, b / 2);
        }
    }

    // 4.9
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        ArrayList<ArrayList<Integer>> result 
            = new ArrayList<ArrayList<Integer>>();
        dfs(root, target, result, new ArrayList<Integer>());
        return result;
    }

    public void dfs(TreeNode root, int target, 
            ArrayList<ArrayList<Integer>> result, ArrayList<Integer> list) {
        if (root == null) {
            return;
        }
        list.add(root.val);
        if (root.left == null && root.right == null && target == root.val) {
            result.add(list);
        }
        dfs(root.left, target - root.val, result, new ArrayList<Integer>(list));
        dfs(root.right, target - root.val, result, new ArrayList<Integer>(list));
    }

}
