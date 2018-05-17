package com.gelonghui.service.create;

import com.gelonghui.entity.BTree;

/**
 * 要求：
 *      输入某二叉树的前序遍历和中序遍历的结果，重建出该二叉树。
 *      假设输入的前序遍历和中序遍历的结果中都不包含重复的数字。
 *
 * 实现：
 *
 * 例子：
 *      前序遍历序列：{1, 2, 4, 7, 3, 5, 6, 8}
 *      中序遍历序列：{4, 7, 2, 1, 5, 3, 8, 6}
 *
 * Created by quanwenchao
 * 2018/5/17 20:27:35
 */
public class ConstructTree {


    /**
     * 递归构建二叉树
     * @return
     */
    public static BTree constructTree(Integer[] startPreOrder, Integer endPreOrder, Integer[] startInOrder, Integer endInOrder) {

        // step1：前序遍历序列第一个数字是树的根节点
        Integer rootValue = startPreOrder[0];
        BTree root = new BTree();
        root.setData(rootValue);
        root.setLeft(null);
        root.setRight(null);

        // step2：在中序遍历序列中找到根节点
        Integer rootInOrder = startInOrder[0];
        while (rootInOrder <= endInOrder && startInOrder[rootInOrder] != rootValue) {
            ++rootInOrder;
        }

        //Integer leftLength = rootInOrder - startInOrder;
        Integer leftLength = rootInOrder - 0;

        //Integer leftPreOrderEnd = startPreOrder + leftLength;
        Integer leftPreOrderEnd = 0 + leftLength;

        if (leftLength > 0) {
            // 构建左子树
            root.setLeft(constructTree(startPreOrder, leftPreOrderEnd, startInOrder, rootInOrder -1));
        }

        //if (leftLength < endPreOrder - startPreOrder) {
        //    root.setRight(constructTree(leftPreOrderEnd+1, endPreOrder, rootInOrder + 1, endInOrder));
        //}

        return root;
    }



    public static void main(String[] args) {

        Integer[] preOrder = new Integer[]{1, 2, 4, 7, 3, 5, 6, 8};
        Integer[] inOrder = new Integer[]{4, 7, 2, 1, 5, 3, 8, 6};


    }
}
