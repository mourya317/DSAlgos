package LinkedList;

/**
 * @author Mourya Balla
 * @project Practice
 * @CreatedOn 19-05-2019
 */
public class ReorderList {

    public static void main(String[] args) {
      Node n = new Node(1);
      n.next = new Node(2);
      n.next.next = new Node(3);
      n.next.next.next = new Node(4);

      Node r = reorder(n);

      while(r!=null){
          System.out.println(r.data);
          r=r.next;

      }
    }

    /*
    Reoder 1-2 -3-4  to 1-4-2-3   in-place
     */
    public static Node reorder(Node n){
        if(n==null)return null;
        if(n.next == null)return n;

        Node head = n;
        Node p = n;

        //move pointer to penultimate node

        while(p.next.next != null){
            p=p.next;
        }

        Node lastNode = p.next;
        lastNode.next = head.next;
        p.next=null;
        head.next=lastNode;


        return head;

    }
}
