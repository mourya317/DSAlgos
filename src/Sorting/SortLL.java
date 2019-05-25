package Sorting;

/**
 * @author Mourya Balla
 * @project Practice
 * @CreatedOn 15-05-2019
 */
public class SortLL {

    public static void main(String[] args) {
        Node n = new Node(10);
        n.next=new Node(9);
        n.next.next=new Node(8);
        n.next.next.next=new Node(90);
        n.next.next.next.next=new Node(999);
        n.next.next.next.next.next=new Node(0);
        n.next.next.next.next.next.next=new Node(19);
        n.next.next.next.next.next.next.next=new Node(90);


        Node t= n ;
        while(t!=null){
            System.out.println(t.val);
            t=t.next;
        }
       Node result =  sortLL(n);
        System.out.println("----------------------");

       while(result!=null){
           System.out.println(result.val);
           result=result.next;
       }



    }


    static class Node {
        int val;
        Node next;

        Node(int val){
            this.val=val;
            this.next = null;
        }
    }


    /*
    1. idea is to split and merge recursilvely
     */
    public static Node sortLL(Node head){
        if(head == null || head.next == null){
            return head;
        }

        //split the list in half
        Node p1=head;
        Node firstEnd = splitInHalf(head);
        Node p2=firstEnd.next;
        firstEnd.next=null;

        //sort each list
        p1=sortLL(p1);
        p2=sortLL(p2);

        return merge(p1, p2);


    }

    private static Node merge(Node p1, Node p2) {
        Node head = new Node(Integer.MIN_VALUE);
        Node ptr1 = p1;
        Node ptr2 = p2;
        Node p= head;

        while(ptr1!=null && ptr2!=null){
            if(ptr1.val<ptr2.val){
                //insert into result
                p.next=ptr1;
                ptr1=ptr1.next;
            }else{
                p.next=ptr2;
                ptr2=ptr2.next;
            }

            p=p.next;
        }

        if(ptr1!=null){
            p.next=ptr1;
        }

        if(ptr2!=null){
            p.next=ptr2;
        }

        return head.next;

    }

    private static Node splitInHalf(Node head) {
        Node slow = head;
        Node fast = head;

        while(slow!=null||fast!=null){
            if(fast.next == null || fast.next.next==null){
                return slow;
            }
            slow=slow.next;
            fast=fast.next.next;
        }
        return head;
    }
}
