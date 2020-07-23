public class SumListsReverse{
/* pb 2.6 - this is the solution without the follow up question - 
 * the follow up solution could entail using 2 equal stacks (padded if necessary)
 */
    private static class Node{

        Node next;

        int digit;

        public Node(int v){
            digit = v;
        }


    }

    static Node head1 = null;
    static Node head2 = null;

    static Node tail1 = null;
    static Node tail2 = null;
    public static void main(String[] args)
    {

        addDigit1(9);
        addDigit1(7);
        addDigit1(8);

        addDigit2(6);
        addDigit2(8);
        addDigit2(5);


        Node current = head1;
        while (current!=null){
            System.out.print("->"+current.digit);
            current = current.next;
        }
        System.out.print("\n");
        current = head2;
        while (current!=null){
            System.out.print("->"+current.digit);
            current = current.next;
        }


        Node sumHead = addNumbers();
        System.out.print("\n");
        current = sumHead;
        while (current!=null){
            System.out.print("->"+current.digit);
            current = current.next;
        }

    }
    public static void addDigit1(int value){

        Node newNode = new Node(value);

        if (head1==null){
            head1 = newNode;
        }else
        {
            tail1.next = newNode;
        }
        tail1 = newNode;
    }

    public static void addDigit2(int value){

        Node newNode = new Node(value);

        if (head2==null){
            head2 = newNode;
        }else
        {
            tail2.next = newNode;
        }
        tail2 = newNode;
    }

    public static Node addNumbers(){

        Node headSum = null;
        Node tailSum = null;

        Node current1 = head1;
        Node current2 = head2;
        int carrier = 0;
        while (current1!=null && current2 !=null){

            int sum = current1.digit+current2.digit+carrier;

            carrier = sum/10;
            Node newNode = new SumListsReverse.Node(sum%10);

            if (headSum==null)
                headSum = newNode;
            else
                tailSum.next = newNode;
            tailSum = newNode;

            current1 = current1.next;
            current2 = current2.next;
        }

        while (current1!=null){

            int sum = current1.digit+carrier;

            carrier = sum/10;
            Node newNode = new SumListsReverse.Node(sum%10);

            if (headSum==null)
                headSum = newNode;
            else
                tailSum.next = newNode;
            tailSum = newNode;

            current1 = current1.next;
        }


        while (current2!=null){

            int sum = current2.digit+carrier;

            carrier = sum/10;
            Node newNode = new SumListsReverse.Node(sum%10);

            if (headSum==null)
                headSum = newNode;
            else
                tailSum.next = newNode;
            tailSum = newNode;

            current2 = current2.next;
        }

        if (carrier>0)
        {
            Node newNode = new SumListsReverse.Node(carrier);
            tailSum.next = newNode;
            tailSum = newNode;
        }

        return headSum;

    }
}