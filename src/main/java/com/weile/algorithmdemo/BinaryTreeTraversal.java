package com.weile.algorithmdemo;

import com.weile.algorithmdemo.datastructure.BinaryTree;

import java.util.*;


/**
 * @Auth weile
 * @Time 2018/11/13 17:51
 * @Description 二叉树遍历
 **/
public class BinaryTreeTraversal {


    /**
     * 中序遍历二叉树节点-递归
     */
    public List<Integer> recursiveCenterOrderTraversal(List<Integer> data) {

        BinaryTree binaryTree = new BinaryTree();
        binaryTree.initTree(data);
        ArrayList<Integer> result = new ArrayList<>();
        recursiveCenterOrderTraversal(binaryTree.getTreeRoot(), result);

        return result;

    }

    /**
     * 后序遍历二叉树节点-递归
     */
    public List<Integer> recursivePostOrderTraversal(List<Integer> data) {

        BinaryTree binaryTree = new BinaryTree();
        binaryTree.initTree(data);
        ArrayList<Integer> result = new ArrayList<>();
        recursivePostOrderTraversal(binaryTree.getTreeRoot(), result);

        return result;

    }

    /**
     * 前序遍历二叉树节点-递归
     */
    public List<Integer> recursivePreOrderTraversal(List<Integer> data) {

        BinaryTree binaryTree = new BinaryTree();
        binaryTree.initTree(data);
        ArrayList<Integer> result = new ArrayList<>();
        recursivePreOrderTraversal(binaryTree.getTreeRoot(), result);

        return result;

    }

    /**
     * 前序遍历二叉树节点-非递归
     */
    public List<Integer> nonRecursivePreOrderTraversal(List<Integer> data) {

        BinaryTree binaryTree = new BinaryTree();
        binaryTree.initTree(data);
        ArrayList<Integer> result = new ArrayList<>();
        Stack<BinaryTree.TreeNode> stack = new Stack<BinaryTree.TreeNode>();

        stack.push(binaryTree.getTreeRoot());
        BinaryTree.TreeNode current = binaryTree.getTreeRoot();


        while (!stack.empty()) {
            //pop出的栈顶元素：下一个遍历到的元素
            BinaryTree.TreeNode pop = stack.pop();
            result.add(pop.getContent());

            //先推右子树入栈
            if (pop.getRight() != null) {
                stack.push(pop.getRight());
            }

            //后推左子树入栈
            if (pop.getLeft() != null) {
                stack.push(pop.getLeft());
            }

        }
        return result;

    }


    /**
     * 中序遍历二叉树节点-非递归
     */
    public List<Integer> nonRecursiveCenterOrderTraversal(List<Integer> data) {

        BinaryTree binaryTree = new BinaryTree();
        binaryTree.initTree(data);
        ArrayList<Integer> result = new ArrayList<>();
        Stack<BinaryTree.TreeNode> stack = new Stack<BinaryTree.TreeNode>();

        //初始化，左子结点入栈，直到最左边的节点，也就是第一个遍历的节点
        stack.push(binaryTree.getTreeRoot());
        BinaryTree.TreeNode peek = stack.peek();
        while (peek.getLeft() != null) {
            stack.push(peek.getLeft());
            peek = peek.getLeft();
        }

        while (!stack.empty()) {
            //pop出的栈顶元素：下一个遍历到的元素即不存在左子结点或者左子结点已经遍历过
            BinaryTree.TreeNode pop = stack.pop();
            result.add(pop.getContent());

            //需要判断右子节点是否存在,存在则需要将右子节点包括其下面的所有左子节点推入栈
            if (pop.getRight() != null) {
                stack.push(pop.getRight());
                BinaryTree.TreeNode popRight = pop.getRight();

                while (popRight.getLeft() != null) {
                    stack.push(popRight.getLeft());
                    popRight = popRight.getLeft();

                }
            }

        }


        return result;

    }

    /**
     * 后序遍历二叉树节点-非递归
     */
    public List<Integer> nonRecursivePostOrderTraversal(List<Integer> data) {

        BinaryTree binaryTree = new BinaryTree();
        binaryTree.initTree(data);
        ArrayList<Integer> result = new ArrayList<>();
        Stack<BinaryTree.TreeNode> stack = new Stack<BinaryTree.TreeNode>();

        //初始化，左子结点入栈，直到最左边的节点，也就是第一个遍历的节点
        stack.push(binaryTree.getTreeRoot());
        BinaryTree.TreeNode peek = stack.peek();
        while (peek.getLeft() != null) {
            stack.push(peek.getLeft());
            peek = peek.getLeft();
        }


        BinaryTree.TreeNode lastVisit = null;

        while (!stack.empty()) {


            peek = stack.peek();

            //需要判断右子节点是否存在,存在则需要将右子节点包括其下面的所有左子节点推入栈
            if (peek.getRight() != null && !peek.getRight().equals(lastVisit)) {
                stack.push(peek.getRight());
                BinaryTree.TreeNode popRight = peek.getRight();

                while (popRight.getLeft() != null) {
                    stack.push(popRight.getLeft());
                    popRight = popRight.getLeft();

                }
            } else {

                //pop出的栈顶元素：无右子节点
                BinaryTree.TreeNode pop = stack.pop();
                result.add(pop.getContent());
                lastVisit = pop;

            }


        }


        return result;

    }

    /**
     * 广度层遍历二叉树节点-非递归
     */
    public List<Integer> nonRecursiveLevelTraversal(List<Integer> data) {

        BinaryTree binaryTree = new BinaryTree();
        binaryTree.initTree(data);
        ArrayList<Integer> result = new ArrayList<>();
        ArrayList<BinaryTree.TreeNode> levelNodes = new ArrayList<>();

        //初始化，记录该层对应的节点
        levelNodes.add(binaryTree.getTreeRoot());

        while (!levelNodes.isEmpty()) {

            ArrayList<BinaryTree.TreeNode> tempNodes = new ArrayList<>();

            for (BinaryTree.TreeNode levelNode : levelNodes) {

                result.add(levelNode.getContent());

                if (levelNode.getLeft() != null) {
                    tempNodes.add(levelNode.getLeft());
                }

                if (levelNode.getRight() != null) {
                    tempNodes.add(levelNode.getRight());
                }
            }

            levelNodes = tempNodes;
        }


        return result;

    }


    /**
     * 中序遍历二叉树节点
     *
     * @param node
     */
    private void recursiveCenterOrderTraversal(BinaryTree.TreeNode node, ArrayList<Integer> result) {


        //先遍历左子结点
        if (node.getLeft() != null) {
            recursiveCenterOrderTraversal(node.getLeft(), result);
        }
        //遍历本身
        result.add(node.getContent());

        //遍历右子节点
        if (node.getRight() != null) {
            recursiveCenterOrderTraversal(node.getRight(), result);
        }

    }


    /**
     * 前序遍历二叉树节点
     *
     * @param node
     */
    private void recursivePreOrderTraversal(BinaryTree.TreeNode node, ArrayList<Integer> result) {


        //遍历本身
        result.add(node.getContent());

        //先遍历左子结点
        if (node.getLeft() != null) {
            recursivePreOrderTraversal(node.getLeft(), result);
        }

        //遍历右子节点
        if (node.getRight() != null) {
            recursivePreOrderTraversal(node.getRight(), result);
        }

    }


    /**
     * 后序遍历二叉树节点
     *
     * @param node
     */
    private void recursivePostOrderTraversal(BinaryTree.TreeNode node, ArrayList<Integer> result) {


        //先遍历左子结点
        if (node.getLeft() != null) {
            recursivePostOrderTraversal(node.getLeft(), result);
        }

        //遍历右子节点
        if (node.getRight() != null) {
            recursivePostOrderTraversal(node.getRight(), result);
        }

        //遍历本身
        result.add(node.getContent());
    }


    public static void main(String[] args) {

        //递归遍历二叉树
        BinaryTreeTraversal traverse = new BinaryTreeTraversal();
        List<Integer> integers = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        List<Integer> result = traverse.recursiveCenterOrderTraversal(integers);
        System.out.println(result);

        List<Integer> nonRecursivePreOrderTraversal = traverse.nonRecursivePreOrderTraversal(integers);
        System.out.println(nonRecursivePreOrderTraversal);


    }


}
