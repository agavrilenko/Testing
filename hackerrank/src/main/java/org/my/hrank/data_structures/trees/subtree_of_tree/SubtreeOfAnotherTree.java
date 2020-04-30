package org.my.hrank.data_structures.trees.subtree_of_tree;

import org.my.hrank.data_structures.trees.TreeNode;

import java.util.ArrayList;

public class SubtreeOfAnotherTree {
    public boolean isSubtree(TreeNode s, TreeNode t) {

        ArrayList<TreeNode> sStore = new ArrayList<>();

        traverseTree(s, t, sStore);
        for (int i = 0; i < sStore.size(); i++) {
            TreeNode cmn = sStore.get(i);
            boolean isSub = compare(cmn, t);
            if (isSub) {
                return true;
            }
        }

        return false;
    }

    private boolean compare(TreeNode cmn, TreeNode t) {

        if (cmn == null && t == null) {
            return true;
        }
        if (cmn != null && t == null || cmn == null && t != null) {
            return false;
        }
        if (cmn.val != t.val) {
            return false;
        }
        return compare(cmn.left, t.left) && compare(cmn.right, t.right);

    }

    private void traverseTree(TreeNode s, TreeNode t, ArrayList<TreeNode> sStore) {

        if (s == null) {
            return;
        }
        if (s.val == t.val) {
            sStore.add(s);
        }
        traverseTree(s.left, t, sStore);
        traverseTree(s.right, t, sStore);
    }
}
