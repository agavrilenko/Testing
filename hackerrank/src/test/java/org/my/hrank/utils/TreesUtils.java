package org.my.hrank.utils;

import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicInteger;

public class TreesUtils {


    public static Integer[] traverseTree(AbstractNode root) {
        LinkedList<Integer> print = new LinkedList<>();
        if (root == null) {
            return new Integer[]{-1};
        }
        print.add(root.getData());
        printNodes(root.getLeft(), print);
        printNodes(root.getRight(), print);
        return print.toArray(new Integer[0]);
    }

    private static void printNodes(AbstractNode root, LinkedList<Integer> print) {
        if (root == null || root.getData() == -1) {
            return;
        }
        print.add(root.getData());
        AbstractNode left = root.getLeft();
        if (left != null && left.getData() != -1) {
            printNodes(left, print);
        }
        AbstractNode right = root.getRight();
        if (right != null && right.getData() != -1) {
            printNodes(right, print);
        }
    }

    public static <T extends AbstractNode> AbstractNode buildTree(int[][] indexes, Class<T> type, AbstractNode root) throws IllegalAccessException, InstantiationException {

        AbstractNode left = type.newInstance();
        AtomicInteger idx = new AtomicInteger(0);
        left.setData(indexes[idx.get()][0]);
        root.setLeft(left);
        AbstractNode right = type.newInstance();
        right.setData(indexes[idx.getAndIncrement()][1]);
        root.setRight(right);

        while (idx.get() < indexes.length) {
            AbstractNode rootLeft = root.getLeft();
            if (rootLeft != null && rootLeft.getData() != -1) {
                buildSubTree(indexes, rootLeft, idx, type);
            }
            AbstractNode rootRight = root.getRight();
            if (rootRight != null && rootRight.getData() != -1) {
                buildSubTree(indexes, rootRight, idx, type);
            }
        }
        return root;
    }

    private static <T extends AbstractNode> void buildSubTree(int[][] indexes, AbstractNode root, AtomicInteger idx, Class<T> type) throws IllegalAccessException, InstantiationException {

        if (idx.get() == indexes.length) {
            return;
        }
        if (root.getLeft() == null && root.getRight() == null) {
            AbstractNode left = type.newInstance();
            left.setData(indexes[idx.get()][0]);
            root.setLeft(left);
            AbstractNode right = type.newInstance();
            right.setData(indexes[idx.get()][1]);
            root.setRight(right);
            idx.incrementAndGet();
            return;
        }
        if (root.getLeft() != null && root.getLeft().getData() != -1) {
            buildSubTree(indexes, root.getLeft(), idx, type);
        }
        if (root.getRight() != null && root.getRight().getData() != -1) {
            buildSubTree(indexes, root.getRight(), idx, type);
        }
    }

}
