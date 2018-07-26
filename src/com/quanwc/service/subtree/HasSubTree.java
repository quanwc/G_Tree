package com.gelonghui.service.subtree;

import com.gelonghui.entity.BTree;

/**
 * 要求：
 *      输入两颗二叉树A和B，判断B是不是A的子结构
 *
 * 实现：
 *      在树A中找到和B的根节点的值一样的节点R，
 *      再判断以R为根节点的子树是不是和树B有一样的结构
 *
 * Created by quanwenchao
 * 2018/5/19 09:15:33
 */
public class HasSubTree {

    /**
     * step2：判断树A是否和树B有一样的结构
     * @param root1 树A的根节点
     * @param root2 树B的根节点
     * @return
     */
    public static boolean DoesTree1HaveTree2(BTree root1, BTree root2) {

        // 递归的结束条件：达到了树A或者树B的叶子节点，因为树A的结构更大，所以树A达到null，返回false
        if (root2 == null) {
            return true;
        }
        if (root1 == null) {
            return false;
        }

        if (root1.getData() != root2.getData()) {
            return false;
        }

        // 递归判断左右子树是否相等
        return DoesTree1HaveTree2(root1.getLeft(), root2.getLeft()) && DoesTree1HaveTree2(root1.getRight(), root2.getRight());
    }

    /**
     * step1：在树A中查找与根节点的值一样的节点
     * @param root1 树A的根节点
     * @param root2 树B的根节点
     * @return
     */
    public static boolean hasSubTree(BTree root1, BTree root2) {

        Boolean result = false; // 返回值

        if (root1 != null && root2 != null) {
            if (!result) { // 如果树A、树B根节点值不相等，则判断左子树
                if (root1.getData() == root2.getData()) {
                    result = DoesTree1HaveTree2(root1, root2); // 进行step2判断：判断树A是否和树B有一样的结构
                }
                hasSubTree(root1.getLeft(), root2);
            }
            if (!result) { // 如果树A、树B根节点值不相等，则判断右子树
                hasSubTree(root1.getRight(), root2);
            }
        }

        return  result;
    }

}
