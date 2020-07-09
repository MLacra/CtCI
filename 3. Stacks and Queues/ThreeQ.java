public class ThreeQ<T> {

    StackNode<T>[] array;

    StackNode<T> top1, top2, top3;

    int resizeCount = 100;
    int count = 0;
   
    public ThreeQ(){
        array = new StackNode[resizeCount];
    }

    public void push (T dat, int stackId){

        StackNode newNode = new StackNode<T>(dat, stackId, count);

        if (stackId==1){
            if (top1!=null)
                newNode.setNextIndex(top1.getIndex());
            top1 = newNode;
        }else
            if (stackId==2){
                if (top2!=null)
                    newNode.setNextIndex(top2.getIndex());
                 
                top2 = newNode;
            }else if (stackId==3){ 
                if (top3!=null)
                    newNode.setNextIndex(top3.getIndex());
                
                top3 = newNode;
            }

        array[count++] = newNode;

        if (count==resizeCount)
            System.out.println("TODO resize for array - Takes O(n)");

    }

    public T pop(int stackId){
       
        Object[] temp = null;
        if (stackId==1)
        {
            temp = pop(top1);
            top1 = (StackNode) temp[1];
        } else
            if (stackId==2)
            {
                temp = pop(top2);
                top2 = (StackNode)temp[1];
            }
            else
                if (stackId==3)
                {
                    temp = pop(top3);
                    top3 = (StackNode) temp[1];
                }

        return (T)temp[0];
    }
    
    private Object[] pop(StackNode top){

        Object[] toReturn = new Object[2];
        toReturn[0] = (T) top.getData();

        int idToDel = top.getIndex();

        if (top.nextIndex != -1){
            top = array[top.getNextIndex()];
        }
        else
            top = null; //empty stack

        array[idToDel] = null;
        toReturn[1] = top; //need to return the reference if the new top

        return toReturn; 
    }

    public T peek(int stackId){
        if (stackId ==1){
            return top1.getData();
        }
        else
        if (stackId ==2){
            return top2.getData();
        }
        else if (stackId ==3){
            return top3.getData();
        }
        return null;
    }


}