package Recursion;

/**
 * @author Mourya Balla
 * @project Practice
 * @CreatedOn 27-04-2019
 */
public class SwapNodesInPairs {


    static class ListNode{
        int v;
        ListNode next;
        ListNode(int v){
            this.v=v;
        }


    }

    public static void print(ListNode head ){
        if(head == null)
            return;
        System.out.print(head.v);
        print(head.next);
    }

    public static void main(String[] args) {
        ListNode n=null;
        n= new ListNode(1);
        n.next=new ListNode(2);
        n.next.next=new ListNode(3);
        n.next.next.next=new ListNode(4);

        print(n);

        ListNode result = swapPairs(n);
        System.out.println("\n----------------------------");
        //print listnode
        print(result);
    }

    /*
    swap first 2 and recur for remaining
     */
    private static ListNode swapPairs(ListNode head){
        if(head == null || head.next == null){
            return head;
        }

        //store head of next pair
        ListNode remaining = head.next.next;
        ListNode newHead = head.next;
        head.next.next=head;

        head.next = swapPairs(remaining);

        return newHead;
    }
}
