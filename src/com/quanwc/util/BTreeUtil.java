package com.gelonghui.util;

import com.gelonghui.entity.BTree;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

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

        /*
         * 双端队列：是指队列两端都可以进出队，但如果只从一边进出队，就实现了栈
         * 栈在java中没有专门的数据结构，是用双端队列Deque来实现的
         * 栈：push()、pop()方法
         */
        Deque<BTree> stack = new LinkedList<BTree>();

        BTree p = root; // 指向当前遍历的节点

        while (!stack.isEmpty() || p != null) {

            /*
             * 一直遍历到左子树最下边，边遍历边保存根节点到栈中（每个节点都可以看成一个新的子树的根节点）
             * 若节点不为空先访问再压栈，因为需要借助遍历过的节点进入右子树
             */
            while (p != null) {
                System.out.print(p.getData() + " "); // 输出
                stack.push(p); // 入栈
                p = p.getLeft(); // 进入p的左子树
            }

            /*
             * 出栈，并进入右子树，开始新的一轮遍历
             * 栈为空，说明根节点、和根节点的left遍历完了
             */
            if (!stack.isEmpty()) {
                p = stack.pop(); // 出栈
                p = p.getRight(); // 进入p的右子树
            }
        }
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

        Deque<BTree> stack = new LinkedList<BTree>();

        BTree p = root; // p指向当前遍历的节点

        while (!stack.isEmpty() || p != null) { //一直遍历到左子树最下边，边遍历边保存根节点到栈中(每个节点都可以看成一个新的子树的根节点)

            while (p != null) {
                stack.push(p);
                p = p.getLeft();
            }

            if (!stack.isEmpty()) {
                p = stack.pop();
                System.out.print(p.getData() + " ");
                p = p.getRight(); //进入右子树，此时p是右子树的根节点（开始新一轮的遍历）
            }

        }

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
     *
     * 相对前序、中序的非递归方式比较难，因为前序、中序都有根节点来串联，而后续是左、右、根，访问左、右节点之间没有串联，是扩过根节点的，所以需要pre节点
     *
     * BiTree pre = null;//当前节点的之前访问的节点
     *
     */
    public static void postOrder(BTree root) {

        Stack<BTree> stack1 = new Stack<BTree>();
        Stack<Integer> stack2 = new Stack<Integer>();

        Integer i = 1; // 0: 入栈  1: 出栈

        while (root != null || !stack1.isEmpty()) {

            while (root != null) {
                stack1.push(root);
                stack2.push(0);
                root = root.getLeft(); // 左子树
            }


            while (!stack1.isEmpty() && stack2.peek() == i) { // 栈顶为1，出栈、输出
                stack2.pop();
                System.out.print(stack1.pop().getData() + " ");
            }

            if (!stack1.isEmpty()) {
                stack2.pop();
                stack2.push(1);

                root = stack1.peek();
                root = root.getRight(); // 右子树
            }
        }



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

    public static void main(String[] args) {
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

}
