package org.my.hrank.data_structures.trees.path_sum;

import org.my.hrank.data_structures.trees.TreeNode;

import java.util.concurrent.atomic.AtomicInteger;

public class PathToSum {

    public int pathSum(TreeNode root, int sum) {

        AtomicInteger cnt = new AtomicInteger(0);

        checkSum(root, sum, cnt);
        return cnt.get();
    }

    private void checkSum(TreeNode root, int sum, AtomicInteger cnt) {
        if (root == null) {
            return;
        }
        validateFromRoot(root, sum, 0, cnt);
        checkSum(root.left, sum, cnt);
        checkSum(root.right, sum, cnt);
    }

    private void validateFromRoot(TreeNode root, int sum, int currentSum, AtomicInteger cnt) {

        if (root == null) {
            return;
        }
        if (currentSum + root.val == sum) {
            cnt.incrementAndGet();
        }
        validateFromRoot(root.left, sum, currentSum + root.val, cnt);
        validateFromRoot(root.right, sum, currentSum + root.val, cnt);
    }
}
