import java.util.LinkedList;

public class MinimalTree { 
    public static void main (String[] args){

        int[] array = new int[]{1,2,3,4,5,6,7,8,9};

        int medianIdx = array.length/2;
        System.out.println("medianIdx= "+medianIdx+" node = "+ array[medianIdx]);
        Node root = new MinimalTree.Node(array[medianIdx]);

        int endIdxLeft = medianIdx-1;
        int startIdxRight = medianIdx+1;

        Node leftChild = createBranch(root, 0, endIdxLeft , array);
        //    leftChild.setParent(currentNode);
        root.setLeftNode(leftChild);

        Node rightChild = createBranch(root, startIdxRight, array.length-1, array);
        //    rightChild.setParent(currentNode);
        root.setRightNode(rightChild);
            
        //left - current - right
        inOrderTraversal(root, 0);    
    
    }

    public static Node createBranch(Node root, int startIdx, int endIdx, int[] array){

        if (startIdx<0 || endIdx>array.length-1 || startIdx>endIdx)
            return null;

        int medianIdx = startIdx+(endIdx-startIdx)/2;
        System.out.println("medianIdx= "+medianIdx+" node = "+ array[medianIdx]);

        Node currentNode = new MinimalTree.Node(array[medianIdx]);

        if (medianIdx==startIdx)
        {
            // Node leftChild = new MinimalTree.Node(array[startIdx]);
            // currentNode.setLeftNode(leftChild);
            if (startIdx<endIdx){
                Node rightChild = new MinimalTree.Node(array[endIdx]);
                currentNode.setRightNode(rightChild);
            }
          
        }else{

            int endIdxLeft = medianIdx-1;
            int startIdxRight = medianIdx+1;

            if (endIdxLeft>=startIdx)
            {
                Node child = createBranch(currentNode, startIdx, endIdxLeft , array);
                currentNode.setLeftNode(child);
            }

            if (startIdxRight<=endIdx)
            {
                Node rightChild = createBranch(currentNode, startIdxRight, endIdx, array);
                currentNode.setRightNode(rightChild);
            }
        }
        if(currentNode!=null)
            System.out.println(currentNode.toString());
        return currentNode;

    }

    static void inOrderTraversal(Node root, int level){
        if (root!=null){
            inOrderTraversal(root.getRightChild(), level+1);
            visit(root, level);
            inOrderTraversal(root.getLeftChild(), level+1);
            
        }
    }

    static void visit(Node root, int level){
        if (root!=null)
            {
            while (level>=0){
                System.out.print("\t");
                level--;
            }
            System.out.println(root.getValue()+ ": ");
        }
    }

    static class Node{

        int value = -1;

        Node leftChild;
        Node rightChild;

        Node parent;

        public Node(int v){
            value = v;
        }

        public int getValue(){
            return value;
        }
        public Node getLeftChild(){
            return leftChild;
        }
        public Node getRightChild(){
            return rightChild;
        }
        public Node getParent(){
            return parent;
        }

        public void setParent(MinimalTree.Node p){
         parent = p;
        }

        public void setLeftNode(MinimalTree.Node l){
            leftChild = l;
        }

        public void setRightNode(MinimalTree.Node r){
            rightChild = r;
        }

        @Override
        public String toString() {
            String result =  "node = "+value;
            result+= ":left = "+(leftChild!=null ? leftChild.getValue(): "null") ;
            result+= ", right="+(rightChild!=null ? rightChild.getValue(): "null");
            return result;
        }
    }

}