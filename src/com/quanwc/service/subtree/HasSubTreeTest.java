package com.gelonghui.service.subtree;

import com.gelonghui.entity.BTree;
import org.junit.Test;

/**
 * Created by quanwenchao
 * 2018/5/19 10:01:34
 */
public class HasSubTreeTest {

    /**
     *
     */
    @Test
    public void test1() {

        // 构建树B
        BTree rootALeft = new BTree(9, null, null);
        BTree rootARight = new BTree(2, null, null);
        BTree rootB = new BTree(8, rootALeft, rootARight);


        // 构建树A
        BTree tree4 = new BTree(4, null, null);
        BTree tree7 = new BTree(7, null, null);
        BTree tree2 = new BTree(2, tree4, tree7);
        BTree tree9 = new BTree(9, null, null);
        BTree tree8 = new BTree(8, tree9, tree2);
        BTree tree6 = new BTree(6, null, null);
        BTree rootA = new BTree(8, tree8, tree6);


        // 调用
        boolean result = HasSubTree.hasSubTree(rootA, rootB);
        System.out.println(result);

    }

    @Test
    public void test2() {

        // 构建树B
        BTree rootALeft = new BTree(9, null, null);
        BTree rootARight = new BTree(2, null, null);
        BTree rootB = new BTree(8, rootALeft, rootARight);


        // 构建树A
        BTree tree2 = new BTree(2, null, null);
        BTree tree9 = new BTree(9, null, null);
        BTree tree8 = new BTree(8, tree9, tree2);
        BTree tree6 = new BTree(6, null, null);
        BTree rootA = new BTree(1, tree8, tree6);


        // 调用
        boolean result = HasSubTree.hasSubTree(rootA, rootB);
        System.out.println(result);

    }

}
