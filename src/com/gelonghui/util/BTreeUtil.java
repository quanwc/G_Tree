package com.gelonghui.util;

import com.gelonghui.entity.BTree;

import java.util.LinkedList;
import java.util.Queue;

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
     * 按层遍历：
     *      辅助队列
     *
     *      从上到下按层遍历，本质上是广度优先遍历，（也称宽度优先遍历？）
     *
     */
    public static void levelPrint(BTree root) {
        if (root == null) {
            return;
        }

        // 队列
        Queue<BTree> queue = new LinkedList<BTree>();

        //将根节点先入队
        if(root!=null){
            queue.offer(root);
        }

        BTree current = null;
        while(!queue.isEmpty()){

            current = queue.poll(); // 队首元素出队

            System.out.println(current.getData()); // 输出

            if(current.getLeft()!=null){ //如果左节点不为null，左节点入队
                queue.offer(current.getLeft());
            }

            if(current.getRight()!=null){ //如果右节点不为null，右节点入队
                queue.offer(current.getRight());
            }
        }

    }

}
