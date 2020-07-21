import java.util.HashMap;

public class LinkedListPalindrome{
// pb 2.6 - overall complexity is O(N), wher N is the length of the input list

    private static class Node {
        Node next;
        int value;

        public Node (int v){
            value = v;
            next = null;
        }

        public int getValue(){
            return value;
        }

        public void setNext(Node n){
            next = n;
        }

        public Node getNext(){
            return next;
        }
    }



    static Node head = null;
    static Node tail = null;
    public static void main (String[] args){

        addNode(1);
        addNode(2);
        addNode(3);
        // addNode(4);
        addNode(3);
        addNode(2);
        addNode(1);

        //version 1
        if (checkPalindrome1())
            System.out.println("List is palindrome");
        else
            System.out.println("List is not palindrome");

        //version 2
        if (checkPalindrome2())
            System.out.println("List is palindrome");
        else
            System.out.println("List is not palindrome");

    }

    public static void addNode(int value){
        Node newNode = new LinkedListPalindrome.Node(value);
        if (head == null) {
            head = newNode;
            tail = head;
        } else
        {
            tail.next = newNode;
            tail = newNode;
        }
    }


    /**
     * This uses a HashMap.
     * O(N)
     */
    public static boolean checkPalindrome1()
    {
        boolean result = true;

        HashMap<Integer, Integer> pos_value = new HashMap<>();
        Node current = head;
        int count = -1;
        while (current!=null){ //O(n)
            count++;
            pos_value.put(count, current.value);
            current = current.next;
        }
        int middle = 0;
        if (count%2==0)
           middle = count/2;
        else
            middle = count/2+1;
        for (int i = 0;i<=middle;i++) //O(n/2)
        {
            if (pos_value.get(i)==pos_value.get(count-i))
                continue;
            else
            {
                result = false;
                break;
            }
        }

       
        return result;
    }

    /**
     * This uses two pointers in the list and a stack.
     * O(N)
     */
    public static boolean checkPalindrome2(){
        boolean result = true;

        Node first = head;
        Node second = head;

        Node stackTop = new LinkedListPalindrome.Node(head.value);

        boolean toggleAdvance = false;
        int count = 0;
        while (first!=null){
            first = first.next;
            count++;
            if (toggleAdvance){
                second = second.next;
                LinkedListPalindrome.Node newStackNode = new LinkedListPalindrome.Node(second.value);
                newStackNode.next = stackTop;
                stackTop = newStackNode;
            }
            toggleAdvance = !toggleAdvance;
        }

        if (count%2==0)
            stackTop = stackTop.next;

        while (second!=null){
            System.out.println(second.value+" =?="+ stackTop.value);
           
            if (second.value != stackTop.value){
                result = false;
                break;
            }

            second = second.next;
            stackTop = stackTop.next;
        }

        return result;
    }

    

    public static int findListLength() // O(n)
    {
        int length = 0;
        Node current = head;
        while (current!=null)
        {
            current = current.next;
            length++;
        }

        return length;
    }
}