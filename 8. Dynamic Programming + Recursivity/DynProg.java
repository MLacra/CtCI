import java.util.HashMap;
public class DynProg {
        
    HashMap<Integer, Integer> solutions ;
    int steps = 0;

    public DynProg(int n){
        this.steps = n;
        solutions = new HashMap<>();
    }
    public void computeSolutions(){
        recursive(steps);
    }

    private int recursive(int n){

        if (solutions.containsKey(n))
            return solutions.get(n);

        switch(n){
            case 1: solutions.put(n, 1); return solutions.get(n);
            case 2: solutions.put(n, 2); return solutions.get(n);
            case 3: solutions.put(n, 3); return solutions.get(n);
        }
        
        int countSols = 0;
        for (int i = 1;i<= Math.floor(n/2);i++){
                if (i!=n-i)
                    countSols += recursive (i) * recursive(n-i);
                else
                    countSols += 1;
        }

        System.out.println("Number of solutions for n= "+n+" is "+countSols);

        solutions.put(n, countSols);
        return countSols;
    }


    public Integer getCountSolutions (int n)
    {
        if (n>steps)
            return null;

        return solutions.get(n);
    }
}