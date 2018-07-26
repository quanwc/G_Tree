package com.gelonghui.service.print;

import com.gelonghui.entity.BTree;
import com.gelonghui.service.create.CreateFindTree;

/**
 * 要求：
 *      输入一个整数数组，判断该数组是不是某二元查找树的后序遍历的结果。如果是返回true，否则返回false。
 *      假设输入的数组的任意两个数字都互不相同
 *
 * 实现：
 *
 *
 * Created by quanwenchao
 * 2018/5/15 20:00:43
 */
public class VerifyPostOrder {

    public static Boolean compute(BTree root, Integer[] arr) {

        boolean flag = false;


        return flag;
    }

    public static void main(String[] args) {

        Integer[] arrData = new Integer[]{6, 2, 5, 8};
        Integer[] arrParam = new Integer[]{6, 2, 5, 8};

        //CreateFindTree obj = new CreateFindTree();
        //obj.createFindTree(arrData); // 对象调用静态的方法，为什么不可以？

        BTree root = CreateFindTree.createFindTree(arrData);

        Boolean flag = compute(root, arrParam);
        System.out.println("flag: " + flag);


    }
}
