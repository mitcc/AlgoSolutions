/*
 * The structure of Segment Tree is a binary tree which each node has two 
 * attributes start and end denote an segment / interval.

start and end are both integers, they should be assigned in following rules:

The root's start and end is given by build method.
The left child of node A has start=A.left, end=(A.left + A.right) / 2.
The right child of node A has start=(A.left + A.right) / 2 + 1, end=A.right.
if start equals to end, there will be no children for this node.
Implement a build method with a given array, so that we can create a 
corresponding segment tree with every node value represent the corresponding 
interval max value in the array, return the root of this segment tree.

Example
Given [3,2,1,4]. The segment tree will be:

                 [0,  3] (max = 4)
                  /            \
        [0,  1] (max = 3)     [2, 3]  (max = 4)
        /        \               /             \
[0, 0](max = 3)  [1, 1](max = 2)[2, 2](max = 1) [3, 3] (max = 4)
Clarification
Segment Tree (a.k.a Interval Tree) is an advanced data structure which can 
support queries like:

which of these intervals contain a given point
which of these points are in a given interval
 */
/**
 * Definition of SegmentTreeNode:
 * public class SegmentTreeNode {
 *     public int start, end, max;
 *     public SegmentTreeNode left, right;
 *     public SegmentTreeNode(int start, int end, int max) {
 *         this.start = start;
 *         this.end = end;
 *         this.max = max
 *         this.left = this.right = null;
 *     }
 * }
 */
public class SegmentTreeBuildII {

    /**
     *@param A: a list of integer
     *@return: The root of Segment Tree
     */
    public SegmentTreeNode build(int[] A) {
        return build(A, 0, A.length - 1);
    }

    public SegmentTreeNode build(int[] A, int start, int end) {
        SegmentTreeNode root = start > end ? null : 
            new SegmentTreeNode(start, end, A[start]);
        if (start < end) {
            SegmentTreeNode left = build(A, start, (start + end) / 2);
            SegmentTreeNode right = build(A, (start + end) / 2 + 1, end);
            root.left = left;
            root.right = right;
            root.max = Math.max(left.max, right.max);
        }
        return root;
    }

}
