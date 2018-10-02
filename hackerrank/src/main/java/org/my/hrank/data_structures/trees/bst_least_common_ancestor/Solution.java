package org.my.hrank.data_structures.trees.bst_least_common_ancestor;

import java.util.LinkedList;
import java.util.Scanner;

class Node {
    Node left;
    Node right;
    int data;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }

    @Override
    public String toString() {
        return "AbstractNode{" +
                "data=" + data +
                '}';
    }
}

class Solution {
    /*
class AbstractNode
    int data;
    AbstractNode left;
    AbstractNode right;
*/
    public static Node lca(Node root, int v1, int v2) {

        LinkedList<Node> firstPath = new LinkedList<>();
        findPath(root, v1, firstPath);
        LinkedList<Node> secondPath = new LinkedList<>();
        findPath(root, v2, secondPath);

        int idx = firstPath.size() > secondPath.size() ? secondPath.size() : firstPath.size();
        if (idx == 0) {
            return new Node(-1);
        }
        Node first = firstPath.removeFirst();
        Node second = secondPath.removeFirst();
        idx--;
        while (idx >= 0) {
            if (first.data == second.data && idx > 0) {
                if (firstPath.peekFirst().data != secondPath.peekFirst().data) {
                    return first;
                }
            }
            if (first.data == second.data && idx == 0) {
                return first;
            }
            first = firstPath.removeFirst();
            second = secondPath.removeFirst();
            idx--;

        }
        return first;
    }

    private static void findPath(Node root, int v1, LinkedList<Node> path) {
        path.add(root);
        if (v1 < root.data && root.left != null) {
            findPath(root.left, v1, path);
        } else if (v1 > root.data && root.right != null) {
            findPath(root.right, v1, path);
        }
    }

    public static Node insert(Node root, int data) {
        if (root == null) {
            return new Node(data);
        } else {
            Node cur;
            if (data <= root.data) {
                cur = insert(root.left, data);
                root.left = cur;
            } else {
                cur = insert(root.right, data);
                root.right = cur;
            }
            return root;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        Node root = null;
        while (t-- > 0) {
            int data = scan.nextInt();
            root = insert(root, data);
        }
        int v1 = scan.nextInt();
        int v2 = scan.nextInt();
        scan.close();
        Node ans = lca(root, v1, v2);
        System.out.println(ans.data);
    }
}