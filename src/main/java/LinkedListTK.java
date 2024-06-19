import java.util.*;

public class LinkedListTK {
    Node head;

    public LinkedListTK(){}
    public LinkedListTK(List<Integer> list){

        for(Integer i: list){
            insert(i);
        }
    }

    public void insert(int data){
        Node newNode = new Node(data);

        if (head==null){
            head=newNode;
        }
        else {
            Node last = head;
            while (last.next!=null){
                last = last.next;
            }

            last.next = newNode;
        }
    }

    public void insert(int data, int position){
        Node newNode = new Node(data);

        if (position==0){
            newNode.next = head;
            head = newNode;
        }
        else{
            Node last = head;
            for(int i=1; last!=null && i<position; i++){
                last = last.next;
            }
            newNode.next = last.next;
            last.next = newNode;


        }
    }

    public Optional<Integer> get(int position){
        if (position==0){
            return Optional.of(head.data);
        }
        else {
            Node currentNode=head;
            int counter = 0;
            do {
                currentNode = currentNode.next;
                counter++;
            }while (currentNode!=null && counter < position);
            //TODO deal with the end of the list
            if (currentNode==null){
                return Optional.empty();
            }
            else{
                return Optional.of(currentNode.data);
            }
        }
    }

    public List<Integer> convertToList(){
        List<Integer> temp = new ArrayList<>();
        Node last = head;
        while(last.next!=null){
            temp.add(last.data);
            last = last.next;
        }
        temp.add(last.data); // we've reached the last node
        return temp;
    }


    public void reverse_iteration(){
        // 1. Save the Node the current Node's next points to
        // 2. change current Node's next to point to the previous Node
        // 3. prev is now head.
        // 4. head is now nxt (notice nxt is purposely spelt differently from next)
        // 5. iterate
        Node prev = null;

        while (head!=null){
            Node nxt = head.next;
            head.next = prev;
            prev = head;
            head = nxt;
        }

        head = prev;
    }

    public void reverse_recurive(){
        reverse_LinkedList(head);
    }

    private void reverse_LinkedList(Node curr){
        // if curr is null return
        // if curr.next is null, we are at last node. set head to curr then return
        // recursively traverse the list
        // set curr.next.next to curr
        // set curr.next to null
        if (curr==null){
            return;
        }
        if(curr.next == null){
            this.head = curr;
            return;
        }
        reverse_LinkedList(curr.next);
        curr.next.next = curr;
        curr.next = null;
    }

    static class Node {
        int data;
        Node next;

        Node(int d){
            data=d;
            next=null;
        }
    }
}

