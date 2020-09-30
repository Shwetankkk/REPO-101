package com.company;

public class SinglyLinkedList{
    private static Node head;

    class Node{
        int data;
        Node next;
        Node(int d){
            data=d;next=null;
        }
    }
    private static int length(Node head){
        Node curr=head;
        int length=0;
        while(curr.next!=null){
            length++;
            curr=curr.next;
        }
        return (length+1);
    }

    static void print(Node head){
        Node curr=head;
        while(curr.next!=null){
            System.out.println(curr.data);
            curr=curr.next;

        }
        System.out.println(curr.data);
    }
    private static Node reverse(Node head){
        Node prev=null;
        Node curr=head;
        Node next=null;
        while(curr.next!=null){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;

        }
        head=prev;
        return head;

    }

    private void insert(int i) {
        Node new_node =new Node(i);
        if(head==null)
        {
            head=new_node;
            return;
        }
        new_node.next=null;
        Node last=head;
        while(last.next!=null){
            last=last.next;
        }
        last.next=new_node;
    }
    private static void delete(int data){
        Node curr=head;
        Node prev =null;

        while(curr.data!=data&&curr.next!=null){
            prev=curr;
            curr=curr.next;

        }
        if(curr==null) return;

        prev.next=curr.next;
    }
    private static void deleteAt(int pos){
        if(head==null) return;

        Node curr=head;
        Node prev =null;
        if(pos==0){
            head=curr.next;
            return;
        }
        while(pos>0&&curr.next!=null){
            prev=curr;
            curr=curr.next;
            pos--;
        }

        prev.next=curr.next;

    }

    public static void main(String[] args) {
        SinglyLinkedList sll=new SinglyLinkedList();
        sll.insert(1);
        sll.insert(2);
        sll.insert(3);
        sll.insert(4);
        sll.insert(5);
        sll.insert(6);

        print(head);


        System.out.println("After reversing");
        print(sll.reverse(head));
        delete(3);
        System.out.println("After deleting 3");
        print(head);
        deleteAt(2);
        System.out.println("After deleting at 2");
        print(head);
        System.out.println("Size of Linked list is "+length(head));

    }

}
