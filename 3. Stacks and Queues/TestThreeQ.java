public class TestThreeQ
{
     public static void main(String[] args){
        
        ThreeQ<String> q = new ThreeQ<>();

        q.push("1", 1);
        q.push("2", 1);
        q.push("3", 1);
        q.push("4", 1);

        q.push("11", 2);
        q.push("22", 2);
        q.push("33", 2);
        q.push("44", 2);

        System.out.println(q.pop(1));
        System.out.println(q.pop(1));
        System.out.println(q.pop(1));

        System.out.println(q.pop(2));
        // System.out.println(q.peek(2));
        // System.out.println(q.peek(2));
        // System.out.println(q.peek(1));
        // System.out.println(q.pop(1));
    }

}