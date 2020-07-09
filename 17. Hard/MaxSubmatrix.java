import java.util.HashMap;

import sun.security.ec.point.Point;

public class MaxSubmatrix{
//problem 17.24 - with Dynaic Programming

    /**
     * Helper class to store the positions in the matrix as pairs of coordinates (i,j).
     */
    static class Position{
        int i,j;
        public Position(int i,int j){
            this.i = i;
            this.j = j;
        }

        @Override
        public boolean equals(Object obj){
            // System.out.printf("\nPosition equals: [%s, %s, %s]%n", i, j, obj);
            if (this == obj)
                return true;
            if (obj == null)
                return false;
            if (getClass() != obj.getClass())
                return false;
            Position other = (Position) obj;
            if (i!=other.i || j!=other.j)
                return false;
        return true;
        }

        @Override
        public int hashCode (){
            int h = Integer.valueOf(i*13+j*11).hashCode();
            // System.out.println("Hashcode for i="+i+", j= "+j+" is "+ h);
            return h ;
        }
        @Override
        public String toString(){
            return "["+i+", "+j+"]";
        }
    }

    //start - left top corner point, end - point, sum
    static HashMap<Position, HashMap<Position, Integer>> subsolutions = new HashMap<>();
    static int maxSum = 0;
    static Position maxStartPos = null;
    static Position maxEndPos = null;

    public static void main(String[] args)
    {
        int n = 5;
        int[][] m = new int[n][n];

        //initialize the matrix with some values
        // int count = 0;
        for (int i = 0; i < n; i++) { 
            for (int j = 0; j < n; j++) 
            { 
                // m[i][j] = count++; 
                m[i][j] = 1; 
            } 
        }

        // let's print a two dimensional array 
        for (int[] a : m) { 
            for (int i : a) { 
                System.out.print(i + "\t"); 
            } 
            System.out.println("\n");
        }

        
        Position leftTop = new Position(0, 0); 
        HashMap<Position, Integer> leftTopSubsol = new HashMap<>();
        // leftTopSubsol.put(leftTop, m[0][0]);

        //Compute the sum between the first element [0,0] and all other elements in the matrix
        for (int i =0;i<n;i++){ //O(NxN)
            for (int j = 0;j<n;j++) {
                Position endPosition = new Position(i,j);
                int sum = 0;
                sum+=m[i][j];
                if (i-1>=0)
                    sum+=leftTopSubsol.get(new Position(i-1,j));
                if (j-1>=0){
                    Position p = new Position(i,j-1);
                    sum+=leftTopSubsol.get(p);
                }
                if (i-1>=0 && j-1>=0)
                    sum-= leftTopSubsol.get(new Position(i-1,j-1));
                
                System.out.println("init: From [0,0] to "+endPosition.toString()+" sum ="+sum);

                leftTopSubsol.put(endPosition, sum);
            }
        }
        // subsolutions.put(leftTop, leftTopSubsol);

        // System.out.println(subsolutions);

        //Search
        maxSum = m[0][0];
        maxStartPos = leftTop;
        maxEndPos = leftTop;

       //O(NxNxNxN) - quite high!
        for (int is =0;is<n;is++)
            for (int js = 0;js<n;js++){
                //starting point
                Position start = new Position(is, js); 
               
                for (int ie =is;ie<n;ie++)
                    for (int je = js;je<n;je++)
                {
                     //end point
                    Position endPosition = new Position(ie,je);
                    System.out.print("From "+start.toString()+" to "+endPosition.toString());

                    int height = ie-is+1;
                    int width = je-js+1;
                    System.out.print(" ("+height+"x"+width+") ");

                    int sum = leftTopSubsol.get(endPosition);
                    System.out.print("sum = "+sum+""+endPosition.toString()+"");

                    Position p =null;
                    if (is-1>=0&&js-1>=0){
                        p = new Position(is-1,js-1);
                        int value = leftTopSubsol.get(p);
                        System.out.print("+"+value+""+p.toString()+"");
                        sum+=value;
                    }
                        
                    if (is-1>=0){
                        p = new Position(is-1,je);
                        int value = leftTopSubsol.get(p);
                        System.out.print("-"+value+""+p.toString()+"");
                        sum-=value;
                    }

                    if (js-1>=0){
                        p = new Position(ie,js-1);
                        int value = leftTopSubsol.get(p);
                        System.out.print("-"+value+""+p.toString()+"");
                        sum-=value;
                    }

                    System.out.println(" sum ="+sum);
                    if (sum>maxSum){
                        maxSum = sum;
                        maxStartPos = start;
                        maxEndPos = endPosition;
                    }


                }
            }

    System.out.println ("Matrix with largest sum is between "+maxStartPos.toString()+" and "+maxEndPos.toString()+" with a sum = "+maxSum);
    }
    
    
}