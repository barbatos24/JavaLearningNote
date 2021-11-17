package com.russellzhou.javalearningnote.interview;

import java.util.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class meituan {

    //二分查找
    public static int recursionBinarySearch(int[] arr,int key,int low,int high){

        if(key < arr[low] || key > arr[high] || low > high){
            return -1;
        }
        int middle = (low + high) / 2;			//初始中间位置
        if(arr[middle] > key){
            //比关键字大则关键字在左区域
            return recursionBinarySearch(arr, key, low, middle - 1);
        }else if(arr[middle] < key){
            //比关键字小则关键字在右区域
            return recursionBinarySearch(arr, key, middle + 1, high);
        }else {
            return middle;
        }

    }

    //数组相关
    public static void array(){

        //Array转List
        String[] stringArray = { "a", "b", "c", "d", "e" };
        ArrayList<String> arrayList = new ArrayList<String>(Arrays.asList(stringArray));

        //List转Array
        ArrayList<String> list=new ArrayList<String>();
        String[] strings = list.toArray(new String[list.size()]);

        //Array转Set
        Set<String> set = new HashSet<String>(Arrays.asList(stringArray));


    }

    //二叉树相关
    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    // 用递归的方法进行先序遍历
    public static void qinaxuDigui(TreeNode treeNode) {
        List<Integer> qianxuNumList = new ArrayList<>();
        qianxuNumList.add(treeNode.val);
        System.out.println(treeNode.val);
        if (treeNode.left != null) {
            qinaxuDigui(treeNode.left);
        }
        if (treeNode.right != null) {
            qinaxuDigui(treeNode.right);
        }
    }

    // 用递归的方法进行中序遍历
    public static void zhongxuDigui(TreeNode treeNode) {
        List<Integer> zhongxuNumList = new ArrayList<>();
        if (treeNode.left != null) {
            zhongxuDigui(treeNode.left);
        }
        zhongxuNumList.add(treeNode.val);
        System.out.println(treeNode.val);
        if (treeNode.right != null) {
            zhongxuDigui(treeNode.right);
        }
    }

    // 用递归的方法进行后序遍历
    public void houxuDigui(TreeNode treeNode) {
        List<Integer> houxuNumList = new ArrayList<>();
        if (treeNode.left != null) {
            houxuDigui(treeNode.left);
        }
        if (treeNode.right != null) {
            houxuDigui(treeNode.right);
        }
        houxuNumList.add(treeNode.val);
        System.out.println(treeNode.val);
    }



    public static void main(String[] args){

//        int[] arr = {5,13,19,21,37,56,64,75,80,89,92};
//        System.out.println(recursionBinarySearch(arr,21,0,10));

        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(3);
        TreeNode d = new TreeNode(4);
        TreeNode e = new TreeNode(5);
        TreeNode f = new TreeNode(6);
        TreeNode g = new TreeNode(7);
        a.left = b;
        a.right = c;
        b.right = d;
        c.left = e;
        c.right = f;
        f.left = g;
        zhongxuDigui(a);

    }
}
