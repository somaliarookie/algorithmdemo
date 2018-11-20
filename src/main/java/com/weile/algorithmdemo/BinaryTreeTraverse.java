package com.weile.algorithmdemo;

import com.weile.algorithmdemo.datastructure.BinaryTree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * @Auth weile
 * @Time 2018/11/13 17:51
 * @Description 二叉树遍历-递归遍历
 **/
public class BinaryTreeTraverse {


    /**
     * 递归方式遍历二叉树
     */
    public  void recursionTraverse(int nodes)
    {

        BinaryTree binaryTree = new BinaryTree();
        binaryTree.initTree(nodes);
        ArrayList<Integer> result = new ArrayList<>();
        centerRecursionTraverseNode(binaryTree.getTreeRoot(),result);

    }


    /**
     * 递归方式遍历二叉树
     */
    public  void recursionTraverseWithData(List<Integer> data)
    {

        BinaryTree binaryTree = new BinaryTree();
        binaryTree.initTree(data);
        ArrayList<Integer> result = new ArrayList<>();
        centerRecursionTraverseNode(binaryTree.getTreeRoot(),result);

        System.out.println(result);
    }


    /**
     * 中序遍历二叉树节点
     * @param node
     */
    public void centerRecursionTraverseNode(BinaryTree.TreeNode node,ArrayList<Integer> result) {


        //先遍历左子结点
        if (node.getLeft() != null) {
            centerRecursionTraverseNode(node.getLeft(),result);
        }
        //遍历本身
        result.add(node.getContent());

        //遍历右子节点
        if (node.getRight()!=null) {
            centerRecursionTraverseNode(node.getRight(),result);
        }

    }


    public static void main(String[] args) {
//        BinaryTreeTraverse traverse=new BinaryTreeTraverse();
//        traverse.recursionTraverse(10);

        BinaryTreeTraverse traverse1 = new BinaryTreeTraverse();
        List<Integer> integers = new ArrayList<>(Arrays.asList(1,2,3,4));

        traverse1.recursionTraverseWithData(integers);

    }


}
