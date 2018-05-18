package com.gelonghui.util;

import com.gelonghui.entity.BTree;

/**
 * 二叉树的工具类
 * Created by quanwenchao
 * 2018/5/15 9:55:28
 */
public class BTreeUtil {

    /**
     * 前序遍历（递归）：
     *      访根、访左、访右
     */
    public static void preOrderRecurse(BTree root) {
        if (root != null) {
            System.out.print(root.getData() + " ");
            preOrderRecurse(root.getLeft());
            preOrderRecurse(root.getRight());
        }
    }

    /**
     * 前序遍历（非递归）
     */
    public static void preOrder(BTree root) {

    }

    /**
     * 中序遍历（递归）：
     *      访左、访根、访右
     */
    public static void inOrderRecurse(BTree root) {
        if (root != null) {
            inOrderRecurse(root.getLeft());
            System.out.print(root.getData() + " ");
            inOrderRecurse(root.getRight());
        }
    }

    /**
     * 中序遍历（非递归）
     */
    public static void inOrder(BTree root) {

    }

    /**
     * 后序遍历（递归）：
     *      访左、访右、访根
     */
    public static void postOrderRecurse(BTree root) {
        if (root != null) {
            postOrderRecurse(root.getLeft());
            postOrderRecurse(root.getRight());
            System.out.print(root.getData() + " ");
        }
    }

    /**
     * 后序遍历（非递归）
     */
    public static void postOrder(BTree root) {

    }

    /**
     * 按层遍历
     */
    public static void levelPrint(BTree root) {

    }

}
