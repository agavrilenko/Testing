package org.my.hrank.data_structures.trees;

public class TreeUtils {

    public static TreeNode buildTree(int[] tree) {
        TreeNode root = new TreeNode(tree[1]);
        root.left = buildTree(2, tree);
        root.right = buildTree(3, tree);
        return root;
    }

    private static TreeNode buildTree(int idx, int[] tree) {

        TreeNode root = null;
        if (idx < tree.length) {
            if (tree[idx] == -1) {
                return null;
            }
            root = new TreeNode(tree[idx]);
            root.left = buildTree(2 * idx, tree);
            root.right = buildTree(2 * idx + 1, tree);
        }
        return root;
    }

}
