package com.gelonghui.service.print;

import com.gelonghui.entity.BTree;

/**
 * 输入一颗二元查找树，将该树转换为它的镜像，
 * 即在转换后的二元查找树中，左子树的结点都大于右子树的结点。用递归和循环两种方法完成树的镜像转换。
 *
 * Created by quanwenchao
 * 2018/5/19 11:38:29
 */
public class MirrorTree {

    /**
     * 递归：
     *      step1：前序遍历树的每个节点
     *      step2：有子节点，则交换
     *      step3：递归交换左、右子节点
     * @param root
     */
    public static void mirrorRecursively(BTree root) {

        if (root == null) {
            return;
        }

        if (root.getLeft() == null && root.getRight() == null) { // 叶子节点不用交换
            return;
        }

        // 左右子树交换
        BTree temp = root.getLeft();
        root.setLeft(root.getRight());
        root.setRight(temp);


        if (root.getLeft() != null) { // 递归左子树
            mirrorRecursively(root.getLeft());
        }
        if (root.getRight() != null) { // 递归右子树
            mirrorRecursively(root.getRight());
        }

    }


    /**
     * 非递归（循环）方式
     */
    public static void mirrorTree() {

    }


}
