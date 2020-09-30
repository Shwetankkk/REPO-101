package com.company;

public class BinarySearchTree{
    private Node root;
    class Node{
        int data;
        Node left,right;
        public Node(int d){
            data=d;
            left=right=null;
        }
    }
    private Node search(Node root,int data){
        if(root==null||root.data==data) return root;

        if(root.data>data)
            return search(root.left,data);

            return search(root.right,data);
    }
    private void insert(int data){
        root=insertRec(root,data);
    }
    private Node insertRec(Node root,int data){
        if(root==null){
            root=new Node(data);
            return root;
        }
        if(root.data>data)
            root.left= insertRec(root.left,data);
        else if(root.data<data)
            root.right=insertRec(root.right,data);
        return root;
    }
    private void inorder()  {
        inorderRec(root);
    }


    private void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.println(root.data);
            inorderRec(root.right);
        }
    }
    private void delete(int data){
        root=deleteRec(root,data);

    }
    private Node deleteRec(Node root,int data){
        if(root==null) return root;

        if(root.data>data)
            root.left= deleteRec(root.left,data);
        else if(root.data<data)
            root.right=deleteRec(root.right,data);
        else{
            if(root.left==null)
                return root.right;
            else(root.right== null)
                    return root.left;


        }

    }


    public static void main(String[] args) {
        BinarySearchTree tree=new BinarySearchTree();
        tree.insert(10);
        tree.insert(4);
        tree.insert(3);
        tree.insert(7);
        tree.insert(30);
        tree.insert(20);

        tree.inorder();
    }
}
