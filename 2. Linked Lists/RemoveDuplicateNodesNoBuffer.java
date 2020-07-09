import java.util.HashSet;

public class RemoveDuplicateNodesNoBuffer
{
    public static void main (String[] args)
    {
        Node head;
        Node endNode = new Node(1);
        head = endNode;

        endNode = addNode(endNode, 2);
        endNode = addNode(endNode, 3);
        endNode = addNode(endNode, 2);
        endNode = addNode(endNode, 2);
        endNode = addNode(endNode, 1);
        endNode = addNode(endNode, 3);
        endNode = addNode(endNode, 4);

        Node current = head;
        while (current!=null)
        {
             System.out.print(current.getValue()+" ");
             current = current.getNext();
        }
 
       head = removeDuplicates(head);
       System.out.print("After removal");
       current = head;
       while (current!=null)
       {
            System.out.print(current.getValue()+" ");
            current = current.getNext();
       }

    }

    static Node addNode(Node endNode, int val){
        Node n = new Node (val);
        endNode.setNext(n);
        endNode = n;
        return endNode;
    }

    static Node removeDuplicates(Node head){
        
        Node current = head;
        while (current!=null)
        {
            Node prev = current;
            Node lookAhead = current.getNext();

            while (lookAhead!=null)
            {
                if (lookAhead.getValue()==current.getValue()){
                    if (prev!=null)
                        prev.setNext(lookAhead.getNext()); 
                }
                else{
                    prev = lookAhead;
                }
                lookAhead = lookAhead.getNext();
            }
            //advance by one
            current = current.getNext();
        }

        return head;
    }

    
}