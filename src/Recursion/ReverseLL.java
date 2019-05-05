package Recursion;

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
}
