package com.weile.algorithmdemo.datastructure;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auth weile
 * @Time 2018/11/13 17:56
 * @Description 二叉树
 **/
public class BinaryTree {

    private TreeNode treeRoot;


    public void initTree(int childrenNums) {
        TreeNode node = new TreeNode((int) (Math.random() * 100), null, null);
        treeRoot = node;

        initChildren(childrenNums, node,null);

    }

    public void initTree(List<Integer> data)
    {
        if (data != null && data.size()>0) {
            TreeNode node = new TreeNode(data.get(0), null, null);
            treeRoot =node;
            initChildren(data.size()-1,treeRoot, data);

        }
    }


    public TreeNode getTreeRoot() {
        return treeRoot;
    }

    public void setTreeRoot(TreeNode treeRoot) {
        this.treeRoot = treeRoot;
    }

    /**
     * 初始化孩子节点 递归式
     *
     * @param childrenStock
     * @param node
     */
    public int initChildren(int childrenStock, TreeNode node,List<Integer> data) {

        //创建左子结点本身
        if (childrenStock-- > 0) {
            TreeNode left = new TreeNode(data==null?null:data.get(data.size()-childrenStock-1), null, null);
            node.setLeft(left);

        }
        if (childrenStock-- > 0) {   //创建右子结点本身
            TreeNode right = new TreeNode(data==null?null:data.get(data.size()-childrenStock-1), null, null);
            node.setRight(right);
        }
        //填充左子结点
        if (childrenStock > 0) {
            childrenStock=initChildren(childrenStock, node.getLeft(),data);
        }
        //填充右子节点
        if (childrenStock > 0) {
           childrenStock= initChildren(childrenStock, node.getRight(),data);
        }

        return childrenStock;

    }


    /**
     * 树节点
     */
    public class TreeNode {

        private Integer content; //节点值
        private TreeNode left; //左子节点
        private TreeNode right; //右子节点

        public TreeNode(Integer content, TreeNode left, TreeNode right) {
            this.content = content;
            this.left = left;
            this.right = right;
        }


        public Integer getContent() {
            return content;
        }

        public void setContent(Integer content) {
            this.content = content;
        }

        public TreeNode getLeft() {
            return left;
        }

        public void setLeft(TreeNode left) {
            this.left = left;
        }

        public TreeNode getRight() {
            return right;
        }

        public void setRight(TreeNode right) {
            this.right = right;
        }
    }


    public static void main(String[] args) {

        BinaryTree tree1 = new BinaryTree();
        tree1.initTree(3);

        BinaryTree tree2 = new BinaryTree();
        List<Integer> integers = new ArrayList();
        integers.add(1);
        integers.add(2);
        integers.add(3);
        integers.add(-1);
        integers.add(4);
        integers.add(-1);
        integers.add(5);
        integers.add(6);
        integers.add(7);
        integers.add(8);
        integers.add(9);
        integers.add(-1);
        tree2.initTree(integers);

    }
}
