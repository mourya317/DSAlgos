package LinkedList;

/**
 * @author Mourya Balla
 * @project Practice
 * @CreatedOn 19-05-2019
 */
public class AddNumbers {
    public static void main(String[] args) {
        Node m = new Node(2);
        m.next = new Node(4);
        m.next.next = new Node(3);

        Node n = new Node(5);
        n.next = new Node(6);
        n.next.next = new Node(4);

        Node res = add(m, n );

        while(res != null){
            System.out.println(res.data);
            res = res.next;
        }

    }


    static class Node{
        int data;
        Node next;

        Node(int data){
            this.data=data;
            this.next = null;
        }
    }

    /*
    numbers are in reverse order in LL
     */
    public static Node add(Node m, Node n){
        if(m.next == null && n.next == null){
            return new Node(m.data+n.data);
        }

        Node r = new Node(Integer.MIN_VALUE);
        Node p = r;

        Node p1 = m;
        Node p2 = n;

        int carry = 0 ; int sum = 0;
        while(p1 != null || p2 !=null){

            sum = carry; // prev carry will be the initial value of sum
            if(p1 !=null){
              sum +=p1.data;
              p1 = p1.next;
            }

            if(p2 != null){
                sum +=p2.data;
                p2=p2.next;
            }

            if(sum > 9){
                carry = 1;
                sum = sum -10;
            }else{
                carry = 0;
            }


            Node res = new Node(sum);
            p.next = res;
            p=p.next;
        }

        //Check the last carry value
        if(carry > 0 ){
            Node c = new Node(carry);
            p.next = c ;
        }
        return r.next;
    }
}
