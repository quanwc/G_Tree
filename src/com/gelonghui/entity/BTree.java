package com.gelonghui.entity;

/**
 * 二叉树实体类
 * Created by quanwenchao
 * 2018/5/15 09:48:43
 */
public class BTree {
    /** 数值域 */
    private Integer data;
    /** 左孩子 */
    private BTree left;
    /** 右孩子 */
    private BTree right;

    /**
     * 无参构造
     */
    public BTree() {

    }

    public BTree(Integer data) {
        this.data = data;
    }

    /**
     * 有参构造
     */
    public BTree(Integer data, BTree left, BTree right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    public Integer getData() {
        return data;
    }

    public void setData(Integer data) {
        this.data = data;
    }

    public BTree getLeft() {
        return left;
    }

    public void setLeft(BTree left) {
        this.left = left;
    }

    public BTree getRight() {
        return right;
    }

    public void setRight(BTree right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "BTree{" +
                "data=" + data +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}
