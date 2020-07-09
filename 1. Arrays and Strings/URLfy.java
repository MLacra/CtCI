import java.util.LinkedList;

public class URLfy{
// pb 1.3
    public static void main(String[] args){
        char[] string = new char[]{'M', 'r', ' ', 'J','o','h','n',' ', 'S', 'm', 'i','t', 'h', ' ',' ',' ',' '};
        LinkedList<Character> buffer = new LinkedList<>();


        for (int i = 0;i<string.length;i++)
        {
            if (string[i]==' ')
            {
                buffer.add(string[i+1]);
                buffer.add(string[i+2]);
                string[i]='%';
                string[i+1]='2';
                string[i+2]='0';
                i+=2;
            }
            if (!buffer.isEmpty()){
                if(i+1<string.length){
                    buffer.add(string[i+1]);
                    string[i+1] = buffer.pop();
                }
            }
        }

        for (int i = 0;i<string.length;i++)
        {
            System.out.print(string[i]);
        }

        System.out.println("\n\n");

    }

}