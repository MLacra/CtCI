

public class Stepss{

    public static void main (String[] args){

        int n = 10;
        DynProg dp = new DynProg(n);
        dp.computeSolutions();
        int count = dp.getCountSolutions(n);
        // System.out.println("Number of solutions for n="+n+" is "+count);
        bruteforce(n);
    }

    private static void bruteforce(int n){
        int count = 0;
        for (int i = 0;i<=n;i++)
        {
            for (int j = 0;j<=Math.floor(n/2);j++)
                for (int k = 0; k<=Math.floor(n/3);k++)
                {
                    if (n == 1*i+2*j+3*k)
                        count++;
                }
        }

        System.out.println("[brute force]Number of solutions for n="+n+" is "+count);
    }

}