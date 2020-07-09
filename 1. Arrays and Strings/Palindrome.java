import java.util.HashMap;

public class Palindrome {
//1.4 
//runtime complexity O(n)
    public static void main(String[] args){
        char[] s = new char[]{'t','a','c','j','j', 'c', 'a','t'};
        withHashMap(s);
    }

    static void withHashMap(char[] s ){
        HashMap<Character, Integer> freqs = new HashMap<>();
        int count = 0;

        boolean isPalindrome = true;

        for (int i = 0;i<s.length;i++) //O(n), n = length of string s
        {
            if (s[i]!=' '){
                if (freqs.containsKey(s[i]))
                {
                    int frequency = freqs.get(s[i]);
                    frequency++;
                    freqs.put(s[i], frequency);
                    count++;
                }
                else
                {
                    freqs.put(s[i], 1);
                    count++;
                }
            }
        }

        int oddFreqs = 0;
        for (Character c : freqs.keySet()) { // O(n) at most - it might break earlier or the keyset might be smaller than n, length of s
            if (freqs.get(c) % 2 != 0) {
                if (count % 2 == 0) {
                    isPalindrome = false;
                    break;
                }
            } else {
                oddFreqs++;
                if (oddFreqs > 1) {
                    isPalindrome = false;
                    break;
                }
            }
        }
        
        

        if (isPalindrome)
            System.out.println("The string is a permutation of a palindrome");
        else
            System.out.println("The string is not a permutation of a palindrome");
    }
}