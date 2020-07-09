public class Node {

    int value;

    Node next;

    public Node(int val){
        value = val;
        next = null;
    }

    public int getValue(){
        return value;
    }

    public Node getNext(){
        return next;
    }

    public void setNext(Node n){
        next = n;
    }
}