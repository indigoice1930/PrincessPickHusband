package Hw8;

import java.util.Scanner;

class TestCircularLinkedList{
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Enter the number of people: ");
        int n = keyboard.nextInt();
        CircularLinkedList cll = new CircularLinkedList();
        for(int i = 0; i < n; i++){
            cll.add(new Node(i+1));
        }
        int position = cll.positionToMarryPrincess();
        System.out.println("You should stand in position " + position + ".");
    }
}
public class CircularLinkedList {
    private Node head;

    public CircularLinkedList( ) {
        head = null;
    }

    public void add(Node node) {
        if (head == null) {
            head = node;
            head.next = head;
            return;
        }
        Node lastNode = head;

        while (lastNode.next != head) {
            lastNode = lastNode.next;
        }

        lastNode.next = node;
        node.next = head;
    }

    public int positionToMarryPrincess(){
        Node cur = head;

        //the loop ends when there is only one node in the list, which means a node is linked to itself
        while(cur.next != cur){
            //In order to remove the 3rd node, go to the second node, and link it to the 4th node, then reset

            //step1: go to the second node
            cur = cur.next;

            //step2: link 2nd node to the 4th node
            cur.next = cur.next.next;

            //step3: start from the 4th node for next loop
            cur = cur.next;
        }

        return cur.position;
    }
}
