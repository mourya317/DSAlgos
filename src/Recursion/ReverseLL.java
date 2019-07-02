package Recursion;

import java.util.List;

/**
 * @author Mourya Balla
 * @project Practice
 * @CreatedOn 27-04-2019
 */
public class ReverseLL {

    static class ListNode{
        int v;
        ListNode next;
        ListNode(int v){
            this.v=v;
        }
    }

    public static void main(String[] args) {
        ListNode n = null;
        n= new ListNode(1);
        n.next=new ListNode(2);
        n.next.next=new ListNode(3);
        //n.next.next.next=new ListNode(4);

        print(n);
        System.out.println("--------");
        ListNode r = rev(n);
        print(r);
    }


    public static void print(ListNode head ){
        if(head == null)
            return;
        System.out.print(head.v);
        print(head.next);
    }

    private static ListNode rev(ListNode n){
        if(n==null|| n.next==null) return n;

        ListNode newHeadNode = rev(n.next);

        n.next.next=n;
        n.next=null;
        return newHeadNode;
    }


    private static ListNode revKNodes(ListNode n , int k ){
        if(n==null||n.next==null)return n;
        if(k<1)return n;

        ListNode newHeadK = revKNodes(n.next,k--);

        n.next.next=n;
        n.next=null;
        return newHeadK;

    }



    /*
    important implementation for linked list
     */
    private static ListNode reverseKSubList(ListNode n, int k ){
        ListNode current = n ;
        ListNode next=null;
        ListNode prev=null;
        int count = 0 ;

        //reverse first k nodes
        while(count < k && current!= null){
            next = current.next;
            current.next=prev;
            prev = current;
            current=next;
            count++;
        }

        if(next != null){
            n.next = reverseKSubList(next,k);
        }

        return prev;
    }


    /*
    reverse a liked list iterative - important
     */
    private static ListNode reverseLL(ListNode n){
        ListNode current = n;
        ListNode next = null;
        ListNode prev = null;
        while(current != null){
            next = current.next;
            current.next=prev; // reverse link
            // move prev, current by 1 node
            prev = current;
            current = next;
        }
        return prev;
    }
}
