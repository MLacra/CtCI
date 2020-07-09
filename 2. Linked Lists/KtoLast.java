import java.util.HashMap;
import java.util.HashSet;

public class KtoLast
{
    public static void main (String[] args)
    {
        int k=11;
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
 
       Node kthNode = findK(head, k);
       if (kthNode!=null)
            System.out.println("kthNode = "+kthNode.getValue());
      
    }

    static Node addNode(Node endNode, int val){
        Node n = new Node (val);
        endNode.setNext(n);
        endNode = n;
        return endNode;
    }

    static Node findK (Node head, int k){
        
        HashMap<Integer, Node> indexes = new HashMap<>();
        Node current = head;

        int i = 0;
        while (current!=null)
        {
            indexes.put(i, current);
            i++;
            current = current.getNext();
        }

        if (k<indexes.size())
            return indexes.get(indexes.size() - 1 - k);
        else
            {
                System.out.println("\nK index goes circular:");
                return indexes.get(indexes.size() - 1 - (k - (k/indexes.size() * indexes.size())));
            }
    }
    
}