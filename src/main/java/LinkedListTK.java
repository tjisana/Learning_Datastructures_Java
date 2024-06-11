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

    private LinkedListTK reversed_old(){
        if (head!=null && head.next==null){
            return this;
        }
        List<Integer> asList = this.convertToList();
        Collections.reverse(asList);
        return new LinkedListTK(asList);
    }

    public LinkedListTK reversed(){
        return reversed_old();
    }

//    public LinkedListTK reversed_new(LinkedListTK linkedListtk){
//        // 1, 2 , 3
//        //linkedListtk.head
//        //reversed_new(linkedListtk.head.next)
//        //if linkedListtk.head.next==null return
//    }

    static class Node {
        int data;
        Node next;

        Node(int d){
            data=d;
            next=null;
        }
    }
}

