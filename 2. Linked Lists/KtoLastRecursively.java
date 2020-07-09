import java.util.HashMap;
import java.util.HashSet;

public class KtoLastRecursively
{
    public static void main (String[] args)
    {
        int k=3;
        Node head;
        Node endNode = new Node(1);
        head = endNode;

        endNode = addNode(endNode, 1);
        endNode = addNode(endNode, 2);
        endNode = addNode(endNode, 3);
        endNode = addNode(endNode, 4);
        endNode = addNode(endNode, 5);
        endNode = addNode(endNode, 6);
        endNode = addNode(endNode, 7);

        Node current = head;
        while (current!=null)
        {
             System.out.print(current.getValue()+" ");
             current = current.getNext();
        }
 
       findKth(head, k);
    }

    static Node addNode(Node endNode, int val){
        Node n = new Node (val);
        endNode.setNext(n);
        endNode = n;
        return endNode;
    }

    static int findKth (Node current, int k){
        
        if (current.getNext()==null)
            return 1;
        
        int currentIdx = findKth(current.getNext(),k);
        if (currentIdx==k)
            System.out.println("Found Kth = "+ current.getValue());
        
        currentIdx++;
        return currentIdx;   

    }
    
}