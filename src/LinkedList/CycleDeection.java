package LinkedList;

/**
 * @author Mourya Balla
 * @project Practice
 * @CreatedOn 19-05-2019
 */
public class CycleDeection {

    public static void main(String[] args) {

    }

    private static boolean hasCycle(Node n){
        Node slow = n;
        Node fast = n;


        while(fast !=null && fast.next!=null){
            slow = slow.next;
            fast=fast.next.next;
        }

        if(slow == fast){
            return true;
        }



        return false;
    }

}
