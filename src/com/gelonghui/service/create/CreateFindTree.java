package com.gelonghui.service.create;

import com.gelonghui.entity.BTree;
import com.gelonghui.util.BTreeUtil;

/**
 * 创建二叉查找树：
 *
 * 二叉查找树：
 *      也称二叉搜索树、二叉排序树，特点是：根>=左，根<=右
 *
 * Created by quanwenchao
 * 2018/5/15 15:53:43
 */
public class CreateFindTree {


    /**
     * 创建一棵二叉查找树：
     *      以数组第一个元素为root为基准元素，左孩子们都比它小，右孩子们都比它大
     *
     * 注：想要创建二叉查找树，必须先指定基准元素，然后
     *
     * @param arr 数组，封装二叉树的data值
     * @return
     */
    public static BTree createFindTree(Integer[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }

        BTree root = null; // 树的根节点
        BTree current = null; // 当前节点，用来遍历树
        BTree insert = null; // 带插入节点
        BTree parent = null; // 父节点，最后指向待插入节点的父节点


        // step1：手动创建根节点
        root = new BTree(arr[0], null, null);

        // step2：创建其他节点
        for (Integer i = 1; i < arr.length; ++i) {

            // step3：创建带插入节点
            insert = new BTree(arr[i], null, null);

            // step4：确定待插入节点的位置
            current = root;
            while (current != null) {
                parent = current;
                if (current.getData() > insert.getData()) {
                    current = current.getLeft();
                } else {
                    current = current.getRight();
                }
            }

            // step5：确定是左插还是右插
            if (parent.getData() > insert.getData()) {
                parent.setLeft(insert);
            } else {
                parent.setRight(insert);
            }

        }

        return root;
    }

    public static void main(String[] args) {
        Integer [] arr = new Integer[]{6, 2, 5, 8, 3, 4};

        // 创建二叉查找树
        BTree root = createFindTree(arr);

        // 先序输出
        BTreeUtil.preOrderRecurse(root);



    }

}
