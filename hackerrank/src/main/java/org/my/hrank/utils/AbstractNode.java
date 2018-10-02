package org.my.hrank.utils;

public interface AbstractNode {
    AbstractNode getLeft();

    AbstractNode getRight();

    <T extends AbstractNode> void setLeft(T left);

    <T extends AbstractNode> void setRight(T right);

    int getData();

    void setData(int data);
}
