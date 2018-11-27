package com.weile.algorithmdemo;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.*;

/**
 * @Auth weile
 * @Time 2018/11/26 10:47
 * @Description TODO
 **/
public class BinaryTreeTraversalTest {

    public BinaryTreeTraversal traversal;

    /**
     * 初始化
     */
    @BeforeTest
    public void init(){

        traversal = new BinaryTreeTraversal();

    }






    @Test
    public void testCenterOrderTraversal() {

        Assert.assertEquals(traversal.nonRecursiveCenterOrderTraversal(Arrays.asList(1,2,3,4)),Arrays.asList(4,2,1,3));
        Assert.assertEquals(traversal.nonRecursiveCenterOrderTraversal(Arrays.asList(1,2,3,4,5,null,6)),Arrays.asList(4,2,5,1,3,6));
        Assert.assertEquals(traversal.recursiveCenterOrderTraversal(Arrays.asList(1,2,3,4,5,null,6)),Arrays.asList(4,2,5,1,3,6));


    }

    @Test
    public void testPreOrderTraversal() {

        Assert.assertEquals(traversal.nonRecursivePreOrderTraversal(Arrays.asList(1,2,3,4,5,null,6)),Arrays.asList(1,2,4,5,3,6));
        Assert.assertEquals(traversal.recursivePreOrderTraversal(Arrays.asList(1,2,3,4,5,null,6)),Arrays.asList(1,2,4,5,3,6));
    }



    @Test
    public void testPostOrderTraversal() {

        Assert.assertEquals(traversal.recursivePostOrderTraversal(Arrays.asList(1,2,3,4,5,null,6)),Arrays.asList(4,5,2,6,3,1));
        Assert.assertEquals(traversal.nonRecursivePostOrderTraversal(Arrays.asList(1,2,3,4,5,null,6)),Arrays.asList(4,5,2,6,3,1));

    }

    @Test
    public void testNonRecursiveLevelTraversal() {
        Assert.assertEquals(traversal.nonRecursiveLevelTraversal(Arrays.asList(1,2,3,4,5,null,6)),Arrays.asList(1,2,3,4,5,6));


    }
}