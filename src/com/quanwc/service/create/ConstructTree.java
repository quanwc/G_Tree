package com.gelonghui.service.create;

import com.gelonghui.entity.BTree;
import com.gelonghui.util.BTreeUtil;

/**
 * 要求：
 *      输入某二叉树的前序遍历和中序遍历的结果，重建出该二叉树。
 *      假设输入的前序遍历和中序遍历的结果中都不包含重复的数字。
 *
 *      注: 通过前序和中序可以获得唯一的二叉树；
 *          也可以通过中序和后续获得唯一的二叉树；
 *          但是不能通过前序和后续获得唯一的二叉树
 *
 * 实现：
 *      先序遍历的第一个元素，是根节点；在中序遍历中找到根节点，根节点左侧的就是左子树，右侧的就是右子树，
 *      这样我们就在前序、中序遍历的两个序列中，分别找到了左、右子树对应的子序列
 *      这就是我们处理的思路，其他的元素节点，我们交给递归处理就好。
 *
 * 例子：
 *      前序遍历序列：{1, 2, 4, 7, 3, 5, 6, 8}
 *      中序遍历序列：{4, 7, 2, 1, 5, 3, 8, 6}
 *      检查：将构建好的二叉树，通过后续遍历的方式输出检查是否正确
 *
 * Created by quanwenchao
 * 2018/5/17 20:27:35
 */
public class ConstructTree {


    /**
     * 递归构建二叉树
     * @param startPreOrder 前序序列
     * @param startPre 前序序列的头元素下标
     * @param endPre 前序序列的尾元素下标
     * @param startInOrder 中序序列
     * @param startIn 中序序列的头元素下标
     * @param endIn 中序序列的尾元素下标
     * @return
     */
    public static BTree constructTree(Integer[] startPreOrder, Integer startPre, Integer endPre,
                                      Integer[] startInOrder, Integer startIn, Integer endIn) {

        // step1：前序遍历序列第一个数字是树的根节点
        Integer rootValue = startPreOrder[startPre];
        BTree root = new BTree();
        root.setData(rootValue);
        root.setLeft(null);
        root.setRight(null);


        // step2：在中序遍历序列中找到根节点
        Integer rootInOrder = startIn;
        while (rootInOrder <= endIn && startInOrder[rootInOrder] != rootValue) {
            ++rootInOrder;
        }

        if (startPre == endPre) { // 递归结束条件：startPre和endPre指向同一个元素
            if (startIn == endIn && startPreOrder[startPre] == startInOrder[startIn]) { // 只剩最后一个元素了
                return root;
            } else {
                throw new RuntimeException("Invalid input");
            }
        }

        Integer leftLength = rootInOrder - startIn; // 中序序列中，根节点距离左边的长度
        Integer leftEndPre = startPre + leftLength; // 根据leftLength，在前序中计算出左子树的尾节点

        if (leftLength > 0) {
            // step3：构建左子树
            root.setLeft(constructTree(startPreOrder, startPre + 1, leftEndPre,
                    startInOrder, startIn, rootInOrder - 1));
        }

        if (leftLength < endPre - startPre) {
            // step4：构建右子树
            root.setRight(constructTree(startPreOrder, leftEndPre + 1, endPre,
                    startInOrder, rootInOrder + 1, endIn));
        }

        return root;
    }


    /**
     * 必要判断，调用constructTree()方法递归构建二叉树
     * @param preOrder
     * @param inOrder
     * @return
     */
    public static BTree construct(Integer[] preOrder, Integer[] inOrder) {

        if (preOrder == null || inOrder == null || preOrder.length == 0 || inOrder.length == 0) {
            return null;
        }

        return constructTree(preOrder, 0, preOrder.length-1,
                inOrder, 0, inOrder.length-1);
    }


    public static void main(String[] args) {

        Integer[] preOrder = new Integer[]{1, 2, 4, 7, 3, 5, 6, 8};
        Integer[] inOrder = new Integer[]{4, 7, 2, 1, 5, 3, 8, 6};

        //Integer[] preOrder = new Integer[]{10, 20, 30};
        //Integer[] inOrder = new Integer[]{20, 10, 30};

        BTree root = construct(preOrder, inOrder);

        BTreeUtil.postOrderRecurse(root);

    }
}
