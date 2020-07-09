
import java.util.HashMap;

import javax.lang.model.util.ElementScanner6; 

public class IsUnique 
{
    public static void main(String[] args){
        
        String s = "unique characters";

        HashMap<Character,Integer> chars = new HashMap<>();

        //Complexity O(N)
        for (int i = 0;i<s.length();i++)
        {
            if (!chars.containsKey(s.charAt(i)))
                chars.put(s.charAt(i), 1);
            else
                break;
        }
        if (s.length()==chars.size())
            System.out.println("Contains unique characters");
        else
            System.out.println("Does not contain unique characters");
    }

}