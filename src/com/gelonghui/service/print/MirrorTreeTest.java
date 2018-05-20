package com.gelonghui.service.print;

import com.gelonghui.entity.BTree;
import com.gelonghui.util.BTreeUtil;
import org.junit.Test;

/**
 * Created by quanwenchao
 * 2018/5/19 11:50:11
 */
public class MirrorTreeTest {

    /**
     * 功能测试：普通的二叉树
     */
    @Test
    public void test1() {
        BTree tree5 = new BTree(5, null, null);
        BTree tree7 = new BTree(7, null, null);
        BTree tree6 = new BTree(6, tree5, tree7);

        BTree tree9 = new BTree(9, null, null);
        BTree tree11 = new BTree(11, null, null);
        BTree tree10 = new BTree(10, tree9, tree11);

        BTree tree8 = new BTree(8, tree6, tree10);



        System.out.println(tree8);
        MirrorTree.mirrorRecursively(tree8);
        System.out.println(tree8);

    }


    /**
     * 功能测试：向左倾斜的二叉树（二叉树的所有节点都没有右子树）
     */
    @Test
    public void test2() {
        BTree tree5 = new BTree(5, null, null);
        BTree tree4 = new BTree(4, tree5, null);
        BTree tree3 = new BTree(3, tree4, null);
        BTree tree2 = new BTree(2, tree3, null);
        BTree tree1 = new BTree(1, tree2, null);

        System.out.println(tree1);
        MirrorTree.mirrorRecursively(tree1);
        System.out.println(tree1);

        BTreeUtil.levelPrint(tree1);

    }

}
