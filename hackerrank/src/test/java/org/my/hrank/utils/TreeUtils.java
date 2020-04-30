package org.my.hrank.utils;

import org.my.hrank.data_structures.trees.TreeNode;

public class TreeUtils {

    public static TreeNode buildTree(int[] tree) {
        int aux[] = new int[tree.length + 1];
        aux[0] = -1;
        System.arraycopy(tree, 0, aux, 1, tree.length);
        TreeNode root = new TreeNode(aux[1]);
        root.left = buildTree(2, aux);
        root.right = buildTree(3, aux);
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
