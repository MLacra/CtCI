import java.util.HashMap;
import java.util.HashSet;

public class KtoLast2Pointers
{
    public static void main (String[] args)
    {
        int k=5;
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
 
       Node kthNode = findKth(head, k);
       if (kthNode!=null)
            System.out.println("kthNode = "+kthNode.getValue());
    }

    static Node addNode(Node endNode, int val){
        Node n = new Node (val);
        endNode.setNext(n);
        endNode = n;
        return endNode;
    }

    static Node findKth (Node current, int k){
        
        Node kDistNode = current;
        Node lookAhead = current;

        int count = 0;
        while (lookAhead!=null)
        {
            if (count>k)
            {
                kDistNode = kDistNode.getNext();
            }

            lookAhead = lookAhead.getNext();
            count++;
        }
        
        return kDistNode;
    }
    
}