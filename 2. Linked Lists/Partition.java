public class Partition
{
    // pb 2.4
    private static class Node{
        int value;
        Node next;

        public Node(int v){
            value = v;
        }

        public int getValue(){
            return value;
        }
    }

    static Node head = null;
    static Node end = null;

    public static void main(String[] args){

        addNode(1);
        addNode(2);
        addNode(10);
        addNode(11);
        addNode(3);
        addNode(4);
        addNode(5);
        addNode(6);

        //example from book
        // addNode(3);
        // addNode(5);
        // addNode(8);
        // addNode(5);
        // addNode(10);
        // addNode(2);
        // addNode(1);

        int x = 5;

        Node head = version1(x);
        // Node head = version2(x);
       
        Node current =  head;

        while (current!=null)
        {
            System.out.print("->"+current.value);
            current = current.next;
        }
    }

    /**
     * This version uses two linked lists: 1 for the smaller items, 1 for the larger items
     * At the end, the two lists are linked together.
     */
    public static Node version1 (int x){
            Node endLeft = null;
            Node headLeft = null;

            Node endRight = null;
            Node headRight= null;

            Node current = head;

            while(current!=null)
            {
                if (current.value<x)
                {
                    if (headLeft!=null){
                        endLeft.next = current;
                        endLeft = current;
                    }
                    else {
                        headLeft = current;
                        endLeft = current;
                    }
                    
                }else
                {
                    if (headRight!=null){
                        endRight.next = current;
                        endRight = current;
                    }
                    else {
                        headRight = current;
                        endRight = current;
                    }
                }
                current = current.next;
            }
        endLeft.next = headRight;
        endRight.next = null; //break the circle

        return headLeft;
    }


    /**
     * This version does not use extra lists.
     * 
     * Swaps the larger values with the smaller values in the same list, until no swaps are possible anymore.
     */
    public static Node version2(int x){
        Node prevCurrent = null;
        Node prevRunner = null;

        Node current = head;
        Node runner = head;
        //init current pointer

        while (runner!=null && current!=null)
        {

            while(current!=null && current.value < x)
            {
                prevCurrent = current;
                current = current.next;
            }
            runner = current;
            while (runner!=null && runner.value >= x)
            {
                prevRunner = runner;
                runner = runner.next;
            }

            if (runner!=null && current!=null){
                int buffer = current.value;
                current.value = runner.value;
                runner.value = buffer;
            }
        }

        if (runner!=null && current==null){
                prevRunner.next = null;;
                runner.next = head;
                head=  runner;
        }

        return head;
        
    }


    public static void addNode(int v){

        Node newNode = new Partition.Node(v);
        if (head==null){
            head = newNode;
            end = newNode;
        }else{
            end.next = newNode;
            end = newNode;
        }
        
    }

}