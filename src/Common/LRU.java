package Common;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * @author Mourya Balla
 * @project Practice
 * @CreatedOn 25-07-2019
 */

    class LRU {

        class Node{
            Node next;
            int key;
            public Node(int d){
                this.key=d;
                this.next=null;
            }
        }


    public static void main(String[] args) {
            LRU lru = new LRU(2);
            lru.set(1,2);
            lru.set(2,3);
            lru.set(1,5);
            lru.set(4,5);
            lru.set(6,7);
        System.out.println(lru.get(4));
        System.out.println(lru.get(1));
        lru.set(8,7);
    }

        Map<Integer,Integer> map;
        Node current ;
        Node head;
        int capacity;
        /*Inititalize an LRU cache with size N */
        public LRU(int N) {
            this.capacity = N;
            this.map = new HashMap<>();
            //this.queue = null;
        }

        /*Returns the value of the key x if
         present else returns -1 */
        public int get(int x) {
            if(map.containsKey(x)){
                //move it to start of queue
                if (head.key == x ){
                    current.next=head;
                    head = head.next;
                }else{
                    Node curr = head;
                    while(curr.next != null && curr.next.key != x){
                        curr= curr.next;
                    }

                    current.next = curr.next;
                    curr = curr.next.next;
                    curr.next=null;

                }
                return map.get(x);
            }
            return -1;
        }

        /*Sets the key x with value y in the LRU cache */
        public void set(int x, int y) {
            if(map.size() == 0 ){
                Node n = new Node(x);
                head = n;
                current = n;
            }else if(map.size() < capacity){
                if(head.key == x){
                    head = head.next;
                }
                current.next = new Node(x);
                current=current.next;
            }else{
                map.remove(head.key);
                Node c = head;
                head = head.next;
                c.next=null;
                current.next = new Node(x);
                current=current.next;
            }
            map.put(x,y);
        }
    }

