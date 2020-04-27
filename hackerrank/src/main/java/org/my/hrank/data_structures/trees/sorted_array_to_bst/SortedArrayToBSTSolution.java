package org.my.hrank.data_structures.trees.sorted_array_to_bst;

public class SortedArrayToBSTSolution {


    public TreeNode sortedArrayToBST(int[] nums) {

        TreeNode root = findRoot(nums, 0, nums.length - 1);

        return root;
    }

    private TreeNode findRoot(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }

        int rootIdx = (left + right) / 2;
        TreeNode root = new TreeNode(nums[rootIdx]);
        root.left = findRoot(nums, left, rootIdx - 1);
        root.right = findRoot(nums, rootIdx + 1, right);
        return root;
    }

    public int inOrder(TreeNode root, int[] storage, int cnt) {
        if (root == null) {
            return cnt;
        }
        storage[cnt] = root.val;
        int next = cnt ;
        if (root.left != null) {
            next = inOrder(root.left, storage, cnt + 1);
        }
        if (root.right != null) {
            next = inOrder(root.right, storage, next + 1);
        }
        return next;
    }


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

}
