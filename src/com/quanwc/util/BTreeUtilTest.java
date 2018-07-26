package com.gelonghui.util;

import com.gelonghui.entity.BTree;
import org.junit.Test;

/**
 * Created by quanwenchao
 * 2018/5/22 11:40:57
 */
public class BTreeUtilTest {


    /**
     * 先序遍历（非递归）：
     *
     *            1
     *        2        3
     *     4    5    n   6
     *   n   7
     */
    @Test
    public void test1() {

        // 构建二叉树
        BTree tree7 = new BTree(7, null, null);
        BTree tree4 = new BTree(4, null, tree7);
        BTree tree5 = new BTree(5, null, null);
        BTree tree2 = new BTree(2, tree4, tree5);

        BTree tree6 = new BTree(6, null, null);
        BTree tree3 = new BTree(3, null, tree6);

        BTree tree1 = new BTree(1, tree2, tree3);


        // 前序(非递归)
        BTreeUtil.preOrder(tree1);

    }

    /**
     * 中序遍历（非递归）
     */
    @Test
    public void test2() {

        // 构建二叉树
        BTree tree7 = new BTree(7, null, null);
        BTree tree4 = new BTree(4, null, tree7);
        BTree tree5 = new BTree(5, null, null);
        BTree tree2 = new BTree(2, tree4, tree5);

        BTree tree6 = new BTree(6, null, null);
        BTree tree3 = new BTree(3, null, tree6);

        BTree tree1 = new BTree(1, tree2, tree3);


        // 中序(非递归)
        BTreeUtil.inOrder(tree1);

    }


    /**
     * 后序遍历（非递归）
     */
    @Test
    public void test3() {

        // 构建二叉树
        BTree tree7 = new BTree(7, null, null);
        BTree tree4 = new BTree(4, null, tree7);
        BTree tree5 = new BTree(5, null, null);
        BTree tree2 = new BTree(2, tree4, tree5);

        BTree tree6 = new BTree(6, null, null);
        BTree tree3 = new BTree(3, null, tree6);

        BTree tree1 = new BTree(1, tree2, tree3);


        // 后序(非递归)
        BTreeUtil.postOrder(tree1);

    }

    @Test
    public void test4() {
        System.out.println(Long.MAX_VALUE);
    }

}
