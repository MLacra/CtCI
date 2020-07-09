public class StackNode<T> {

    T data;
    //convention: last element in stack has index = -1 to signify there is nothing else after it
    int nextIndex;

    //the index in the array
    int index;

    int stackId;

    public StackNode(T d, int sid, int idx){
        data = d;
        stackId= sid;
        index = idx;
        nextIndex = -1;
    }

    public T getData(){
        return data;
    }

    public void setData (T d){
        data = d;
    }

    public int getIndex (){
        return index;
    }

    public void setIndex(int idx){
        index = idx;
    }

    public void setStackId (int id){
        stackId = id;
    }

    public int getStackId (){
        return stackId;
    }

    @Override
    public String toString(){
        return "data = "+data+"; stackId = "+stackId+"; nextIdx = "+ index;
    }

    public int getNextIndex(){
        return nextIndex;
    }

    public void setNextIndex(int nIdx){
        nextIndex = nIdx;
    }

}