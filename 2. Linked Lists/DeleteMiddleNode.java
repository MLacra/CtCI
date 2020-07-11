public class DeleteMiddleNode{
//problem 2.3- 3 solutions

    private static class Node {
        Node next;
        Integer value;
        boolean toRemoveFlag = false; // use a flag to mark to nodes that should not be displayed, i.e., removed

        public Node (int v){
            value = v;
            next = null;
        }

        public Integer getValue(){
            if (toRemoveFlag)
                return null;
            return value;
        }
    }

    static Node head =null;
    static Node end = null;


    public static void main(String[] args){

        head = new DeleteMiddleNode.Node(1);
        end = head;

        addNode(2);
        addNode(3);
        Node toRemove = addNode(4);
        addNode(5);
        addNode(6);

        //print the nodes
        Node c = head;
        while (c!=null){
            System.out.print("->"+c.getValue());
            c= c.next;
        }

        /**
         * We cannot really remove the node as we would need to know the previous node to the one we are trying to remove.
         * Normally, we go through the whole chain as we need to find the previous node to 
         * the one we ar removing (and in a singly list, we don't have that 
         * information from a single node). 
         */

        //Version 1. - skip showing the node
        System.out.println("\n\nRemove the node - Version 1");
        c = head;
        while (c!=null){

            //either 
            if(c==toRemove){
                c= c.next;
                continue;
            }
            System.out.print("->"+c.getValue());
            c= c.next;
        }

        //Version 2. - use a flag in the node
        System.out.println("\n\nRemove the node - Version 2");
        c = head;
        toRemove.toRemoveFlag = true;

        while (c!=null){
            if (c.getValue()!=null)
                System.out.print("->"+c.getValue());
            c= c.next;
        }


        //Version 3. - overwrite the node's value
        System.out.println("\n\nRemove the node - Version 3");
        c = toRemove;
        Node previousToLast = null;
        while (c.next!=null)
        {
            c.value = c.next.value;
            previousToLast = c;
            c = c.next;
        }
        previousToLast.next = null;

        toRemove.toRemoveFlag = false; // for testing purposes, revert flag from version 2
        c = head;
        while (c!=null){
            
            System.out.print("->"+c.getValue());
            c= c.next;
        }

    }

    /**
     * Helper method to add a node at the end of the list.
     */
    private static Node addNode (int v){

        Node newNode = new DeleteMiddleNode.Node(v);

        end.next = newNode;
        end = newNode;

        return newNode;
    }


}