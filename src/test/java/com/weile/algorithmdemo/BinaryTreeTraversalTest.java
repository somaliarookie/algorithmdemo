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
    public void testRecursiveCenterOrderTraversal() {
    }

    @Test
    public void testNonRecursiveCenterOrderTraversal() {

        Assert.assertEquals(traversal.nonRecursiveCenterOrderTraversal(Arrays.asList(1,2,3,4)),Arrays.asList(4,2,1,3));
        Assert.assertEquals(traversal.nonRecursiveCenterOrderTraversal(Arrays.asList(1,2,3,4,5,null,6)),Arrays.asList(4,2,5,1,3,6));

    }
}